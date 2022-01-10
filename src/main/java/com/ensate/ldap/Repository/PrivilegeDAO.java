package com.ensate.ldap.Repository;

import com.ensate.ldap.dao.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeDAO extends JpaRepository<Privilege, Long> {

}
