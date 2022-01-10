package com.ensate.ldap.controllers;

import com.ensate.ldap.dao.Privilege;
import com.ensate.ldap.services.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeBdService;

    @PostMapping("/add")
    public <S extends Privilege> S save(@RequestBody S entity) {
        
        return (S) privilegeBdService.save(entity);
    }

    @GetMapping("/findall")
    public List<Privilege> findAll() {
        return privilegeBdService.findAll();
    }
    @GetMapping("/find/id/{id}")
    public Optional<Privilege> findById(@PathVariable("id") Long id) {
        
        return privilegeBdService.findById(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        
        privilegeBdService.deleteById(id);
    }


}
