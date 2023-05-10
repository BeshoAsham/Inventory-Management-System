package com.project.pr.controllers;

import com.project.pr.dto.loginDto;
import com.project.pr.dto.userDto;
import com.project.pr.models.user;
import com.project.pr.response.loginMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.pr.services.userService;
import java.util.List;


@RestController
@RequestMapping("/user")
public class userController {
    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/getAll")
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/register")
    public loginMessage register(@RequestBody userDto newUser) {
        return userService.register(newUser);

    }

    @PutMapping("/admin/update")
    public ResponseEntity<user> updateUser(@RequestBody user updatedUser) {
        userService.updateUser(updatedUser);
        return new ResponseEntity<user>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete")
    public String deleteUser(@RequestParam Integer ID) {
        userService.deleteUser(ID);
        return "deleted successfully";
    }

    @PostMapping("/login")
    public loginMessage login(@RequestBody loginDto loginDTO) {
        return userService.loginUser(loginDTO);

    }
}
