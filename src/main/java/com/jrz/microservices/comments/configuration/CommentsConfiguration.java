package com.jrz.microservices.comments.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentsConfiguration {
	@Bean(name = "org.dozer.Mapper")
	  public DozerBeanMapper dozerBean() {
	    return new DozerBeanMapper();
	  }
}
