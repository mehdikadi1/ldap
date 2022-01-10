package com.ensate.ldap.services;



import com.ensate.ldap.Repository.RoleDAO;
import com.ensate.ldap.dao.Role;
import com.ensate.ldap.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    public RoleDAO roleDAO;

    @Autowired
    public UserService userService;

    public Role save(Role entity) {
        return roleDAO.save(entity);
    }

    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    public Optional<Role> findById(Long id) {
        return roleDAO.findById(id);
    }

    public void deleteById(Long id) {
        roleDAO.deleteById(id);
    }

    public String save(Role entity, String uid) {
        String ro = entity.getRole();
        User userLdap = userService.findByIdWithoutRoles(uid).get();
        List<Role> roles = userLdap.getRoles();
        if(roles.size()==0) roles = new ArrayList<Role>();
        for(Role r : roles) {
            if(r.getRole().equals(ro)) return "EXISTS";
        }
        roleDAO.save(entity);
        return "ADDED";
    }

    public String deleteByUid(String uid, String role) {
        List<Role> roleb = roleDAO.findByRole(role);
        Optional<User> u = userService.findByIdWithoutRoles(uid);
        User user = u.isPresent()? u.get() : new User();
        for(Role r : roleb) {
            List<User> users = r.getUsers();
            for(User us : users) {
                if(us.getUid().equals(uid) && r.getRole().equals(role)) {
                    this.deleteById(r.getId());
                    return "DELETED";
                }
            }
        }
        return "NOT";
    }
}
