package com.ensate.ldap.services;


import com.ensate.ldap.Repository.PrivilegeDAO;
import com.ensate.ldap.dao.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeService {
    @Autowired
    public PrivilegeDAO privilegeDAO;

    public Optional<Privilege> findById(Long id) {
        return privilegeDAO.findById(id);
    }

    public void deleteById(Long id) {
        privilegeDAO.deleteById(id);
    }

    public Privilege  save(Privilege entity) {
        return privilegeDAO.save(entity);
    }

    public List<Privilege> findAll() {
        return privilegeDAO.findAll();
    }


}
