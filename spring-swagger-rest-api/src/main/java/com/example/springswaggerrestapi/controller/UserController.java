package com.example.springswaggerrestapi.controller;

import com.example.springswaggerrestapi.Repository.UserRepository;
import com.example.springswaggerrestapi.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "add user ", notes = "Create a new user", tags = {"CREATE USER HERE"})
    @PostMapping("/saveUser") // Update the path to match your actual controller mapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //	@PostMapping("/createUser")
//	public User saveData(@RequestBody User user)
//	{
//		userRepository.save(user);
//		return user;
//	}
    @ApiOperation(value = "get all user by id ",notes = "get all user if exist",tags = {"GET ALL USER"})
    @GetMapping("GetAllData")
    public List<User> getAll(){
        List<User> userList= userRepository.findAll();
        return userList;
    }
    @ApiOperation(value = "get user by id ",notes = "get user if exist",tags = {"GET USER"})
    @GetMapping("GetById/{id}")
    public Optional<User> getById(@PathVariable int id) {

        Optional<User> userById=userRepository.findById(id);

        return userById;

    }
    @ApiOperation(value = "delete user by id ",notes = "delete user if exist",tags = {"DELETE USER"})
    @DeleteMapping("deleteID/{id}")
    public String deleteById(@PathVariable int id) {

        userRepository.deleteById(id);

        return "deleted successfully";

    }
}
