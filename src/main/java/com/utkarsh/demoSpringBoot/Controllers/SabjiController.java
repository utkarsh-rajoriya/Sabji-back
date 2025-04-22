package com.utkarsh.demoSpringBoot.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utkarsh.demoSpringBoot.Models.Sabji;
import com.utkarsh.demoSpringBoot.Services.SabjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SabjiController {

    @Autowired
    private SabjiService service;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        try{
            return new ResponseEntity<>("Hello", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/world")
    public ResponseEntity<?> getWorld() {
        try{
            return new ResponseEntity<>("World", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getSabjis() {
        try{
        return new ResponseEntity<>(service.getSabjis(), HttpStatus.OK);
        }
        catch(Exception e){
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addSabji")
    public ResponseEntity<?> addSabji(
            @RequestPart("sabji") String sabjiJson, // Accept JSON as a string
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            Sabji sabji = objectMapper.readValue(sabjiJson, Sabji.class);
            return new ResponseEntity<>(service.addSabji(sabji, imageFile), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/images/{imageName}")
    public ResponseEntity<?> getImage(@PathVariable String imageName) {
        try {
            return new ResponseEntity<>(service.getImage(imageName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}