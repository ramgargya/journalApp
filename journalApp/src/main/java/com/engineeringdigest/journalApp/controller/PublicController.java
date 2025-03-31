package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.api.response.WeatherResponse;
import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.UserService;
import com.engineeringdigest.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@CrossOrigin("http://localhost:5500/")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }


    @PostMapping("/create-user")
    public User signUp(@RequestBody User user) {
        userService.saveNewUser(user);
        return user;
    }


//    @PostMapping("/login")
//    public void login(@RequestBody User user) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
//            );
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }










    @GetMapping("/weather/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city) {
        WeatherResponse weather = weatherService.getWeather(city);
        if(weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
