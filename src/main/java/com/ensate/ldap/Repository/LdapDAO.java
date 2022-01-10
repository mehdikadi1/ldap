package com.ensate.ldap.Repository;

import com.ensate.ldap.dao.UserLdap;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdapDAO extends LdapRepository<UserLdap> {
	UserLdap findByUid(String uid);

}
