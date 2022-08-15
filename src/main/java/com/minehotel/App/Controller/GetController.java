package com.minehotel.App.Controller;

import com.minehotel.App.Entity.AppUser;
import com.minehotel.App.Entity.Role;
import com.minehotel.App.Services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class GetController {

    @Autowired
    private UserServiceImplementation userImpl;

    @GetMapping("/")
    public String homepage(){
        return "Welcome";
    }

    @GetMapping("/get/user")
    public ResponseEntity<?> fetchUser(@RequestBody String email){
        return new ResponseEntity<>(userImpl.getUserByEmail(email), HttpStatus.FOUND);
    }

    @GetMapping("/get/users")
    public ResponseEntity<?> fetchUsers(){
        return new ResponseEntity<>(userImpl.getUsers(),HttpStatus.FOUND);
    }
}
