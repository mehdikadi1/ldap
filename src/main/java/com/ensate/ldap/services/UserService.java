package com.ensate.ldap.services;


import com.ensate.ldap.Repository.UserDAO;
import com.ensate.ldap.dao.Privilege;
import com.ensate.ldap.dao.Role;
import com.ensate.ldap.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;
    
    public List<User> findAllWithoutRoles(){
        return userDao.findAll();
    }

    public List<User> findAll() {
        List<User> newListUserLdapBD = new ArrayList<>();
        List<User> listUserLdap = userDao.findAll();
        String roles="";
        for(User user : listUserLdap){
            roles += user.getGidNumber();
            List<Role> listRoleBD = user.getRoles();
            for(Role role : listRoleBD) {
                roles += "," + role.getRole();
            }
            user.setGidNumber(roles);
            newListUserLdapBD.add(user);
            roles ="";
        }
        return newListUserLdapBD;
    }

    public Optional<User> findByIdWithoutRoles(String id){
        return userDao.findById(id);
    }

    public Optional<User> findById(String id) {
        Optional<User> userbd = userDao.findById(id);
        if(userbd.isPresent()) {
            String roles= userbd.get().getGidNumber();
            List<Role> listRoleBD = userbd.get().getRoles();
            for(Role role : listRoleBD) {
                roles += ","+role.getRole();
            }
            userbd.get().setGidNumber(roles);
        }
        return userbd;
    }

    public <S extends User> List<S> saveAll(Iterable<S> entities) {

        return userDao.saveAll(entities);
    }

    public List<Privilege> userPrivilege(String uid){
        List<Role> rolesList = this.findByIdWithoutRoles(uid).get().getRoles();
        List<Privilege> privilegeList = new ArrayList<>();
        for(Role role : rolesList) {
            List<Privilege> pl = role.getPrivileges();
            for(Privilege p : pl) {
                privilegeList.add(p);
            }
        }
        return privilegeList;
    }
}
