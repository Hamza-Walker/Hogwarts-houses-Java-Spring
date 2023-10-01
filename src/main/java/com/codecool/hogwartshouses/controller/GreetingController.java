package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web") // Change the base URL path for this controller
public class GreetingController {

    private final RoomService roomService;

    @Autowired
    public GreetingController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/greeting") // Unique path for the greeting method
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Witches and Wizards") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}