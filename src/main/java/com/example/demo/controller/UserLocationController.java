package com.example.demo.controller;
import com.example.demo.services.*;
import com.example.demo.entities.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserLocationController {
	@Autowired
	private UserLocationService userLocationService;

    @PostMapping("/create_data")
    public UserLocation createData(@RequestBody UserLocation userLocation) {
        return userLocationService.createUserLocation(userLocation);
    }

    @PutMapping("/update_data/{id}")
    public UserLocation updateData(@PathVariable Long id, @RequestBody UserLocation updatedUserLocation) {
        return userLocationService.updateUserLocation(id, updatedUserLocation);
    }

    @GetMapping("/get_users/{n}")
    public List<UserLocation> getNearestUsers(@PathVariable int n) {
        return userLocationService.getNearestUsers(n);
    }
    
    @GetMapping("/getalluser")
    public List<UserLocation> getallusers() {
        return userLocationService.getallusers();
    }
}
