package com.minehotel.App.Controller;

import com.minehotel.App.Entity.AppUser;
import com.minehotel.App.Entity.Role;
import com.minehotel.App.Entity.UpdateUserEntity;
import com.minehotel.App.Services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class PostController {

    @Autowired
    private UserServiceImplementation userImpl;

    @PostMapping("/register/user")
    public ResponseEntity<?> createUser(@RequestBody AppUser user){
        return new ResponseEntity<>(userImpl.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/create/role")
    public ResponseEntity<?> createRole(@RequestBody Role role){
        return new ResponseEntity<>(userImpl.saveRole(role),HttpStatus.CREATED);
    }

    @PostMapping("/update/role/user")
    public ResponseEntity<?> addRoleToUser(@RequestBody UpdateUserEntity form){
        userImpl.assignUserRole(form.getRole(), form.getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
