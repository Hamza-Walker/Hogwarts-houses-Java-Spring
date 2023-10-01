package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoomService {

    private final String ROOMS_API_URL = "http://localhost:8080/api/rooms";
    private final RestTemplate restTemplate;

    @Autowired
    public RoomService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Room> getAllRooms(){
        ResponseEntity<Room[]> responseEntity = restTemplate.getForEntity(ROOMS_API_URL, Room[].class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(responseEntity.getBody());
        } else {
            // Handle the error or exception
            return Collections.emptyList();
        }
    }


}
