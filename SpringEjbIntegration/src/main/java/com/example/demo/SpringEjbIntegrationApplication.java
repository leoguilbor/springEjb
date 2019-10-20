package com.example.demo;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import simpleEjb.HelloStatelessWorld;

@SpringBootApplication
public class SpringEjbIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEjbIntegrationApplication.class, args);
	}
	
	@Bean  
	public Context context() throws NamingException {
	    Properties jndiProps = new Properties();
	    jndiProps.put("java.naming.factory.initial", 
	      "org.jboss.naming.remote.client.InitialContextFactory");
	    jndiProps.put("jboss.naming.client.ejb.context", true);
	    jndiProps.put("java.naming.provider.url", 
	      "http-remoting://localhost:8080");
	    return new InitialContext(jndiProps);
	}
	
	@Bean
	public HelloStatelessWorld helloStatelessWorld(Context context) 
	  throws NamingException {
	  
	    return (HelloStatelessWorld) 
	      context.lookup(this.getFullName(HelloStatelessWorld.class));
	}

	private String getFullName(Class classType) {
	    String moduleName = "simpleEjb-0.0.1-SNAPSHOT/";
	    String beanName = classType.getSimpleName();
	    String viewClassName = classType.getName();
	    return moduleName + beanName + "!" + viewClassName;
	}
}
