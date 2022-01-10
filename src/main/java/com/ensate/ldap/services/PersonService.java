package com.ensate.ldap.services;

import com.ensate.ldap.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import java.util.List;


@Service
public class PersonService {
	private static final Integer THREE_SECONDS = 3000;

	@Autowired
	private LdapTemplate ldapTemplate;

	public List<User> getPersonNamesByLastName(String lastName) {
		SearchControls sc = new SearchControls();
		sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
		sc.setTimeLimit(THREE_SECONDS);
		sc.setCountLimit(10);
		sc.setReturningAttributes(
				new String[] { "sn", "givenName", "uid", "cn", "description", "title", "telephoneNumber", "street",
						"postalCode", "postOfficeBox", "l", "st", "initials", "mail", "o", "postalAddress" });

		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "person"));
		filter.and(new EqualsFilter("cn", lastName));

		return ldapTemplate.search(LdapUtils.emptyLdapName(), filter.encode(), sc, new PersonAttributesMapper());
	}


	private class PersonAttributesMapper implements AttributesMapper<User> {
		public User mapFromAttributes(Attributes attrs) throws NamingException {
			User person = new User();
			person.setGivenname((String) attrs.get("givenName").get());
			person.setLastname((String) attrs.get("sn").get());
			person.setUid((String) attrs.get("uid").get());
			person.setFullname((String) attrs.get("fullname").get());
			person.setGidNumber((String) attrs.get("gidNumber").get());
			person.setMail((String) attrs.get("mail").get());

			return person;
		}
	}
}
