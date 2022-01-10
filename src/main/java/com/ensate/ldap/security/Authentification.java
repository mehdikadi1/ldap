package com.ensate.ldap.security;

import org.springframework.context.annotation.Configuration;
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;


@Configuration
public class Authentification {

	public boolean userVerify(String uname, String passwd){

		boolean userVerify = false;
		Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://192.168.70.133:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "cn="+uname+",dc=ensate,dc=uae,dc=ac,dc=ma");
		env.put(Context.SECURITY_CREDENTIALS, passwd);

		try {
		    DirContext ctx = new InitialDirContext(env);
		    System.out.println("connected");
		    System.out.println(ctx.getEnvironment());
		    userVerify = true;
		    ctx.close();
		 
		} catch (AuthenticationNotSupportedException ex) {
		    System.out.println("The authentication is not supported by the server");
		} catch (AuthenticationException ex) {
		    System.out.println("incorrect password or username");
		} catch (NamingException ex) {
		    System.out.println("error when trying to create the context");
		}
		return userVerify;
	}

}
