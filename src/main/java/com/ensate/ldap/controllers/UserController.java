package com.ensate.ldap.controllers;

import com.ensate.ldap.dao.Privilege;
import com.ensate.ldap.dao.User;
import com.ensate.ldap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/bd")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findall")
    public List<User> findAll() {

        return userService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Optional<User> findById(@PathVariable("id") String id) {

        return userService.findById(id);
    }

    @GetMapping("/find/privileges/uid/{uid}")
    public List<Privilege> userPrivilege(@PathVariable("uid") String uid) {

        return userService.userPrivilege(uid);
    }

}
