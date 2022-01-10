package com.ensate.ldap.controllers;

import com.ensate.ldap.dao.Role;
import com.ensate.ldap.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/bd/role")
public class RoleController {
    @Autowired
    public RoleService roleService;

    @PostMapping("/add")
    public Role save(@RequestBody Role entity) {
        return roleService.save(entity);
    }

    @GetMapping("/findall")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Optional<Role> findById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        roleService.deleteById(id);
    }

    @PostMapping("/add/uid/{uid}")
    public String save(@RequestBody Role entity, @PathVariable("uid") String uid) {
        return roleService.save(entity, uid);
    }

    @DeleteMapping("/delete/uid/{uid}/role/{role}")
    public String deleteByUid(@PathVariable("uid") String uid, @PathVariable("role") String role) {
        return roleService.deleteByUid(uid, role);
    }
}
