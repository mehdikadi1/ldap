package com.ensate.ldap.Repository;

import com.ensate.ldap.dao.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
	List<Role> findByRole(String role);
}
