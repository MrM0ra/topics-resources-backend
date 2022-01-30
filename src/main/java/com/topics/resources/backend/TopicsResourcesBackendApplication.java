package com.topics.resources.backend;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.topics.resources.backend.entities.Resource;
import com.topics.resources.backend.entities.Topic;
import com.topics.resources.backend.services.implementation.ResourceServiceImplementation;
import com.topics.resources.backend.services.implementation.TopicServiceImplementation;

@SpringBootApplication
public class TopicsResourcesBackendApplication {

	@Autowired
	private TopicServiceImplementation topicService;
	
	@Autowired
	private ResourceServiceImplementation resourceService;
	
	public static void main(String[] args) {
		SpringApplication.run(TopicsResourcesBackendApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner dummy(/*UserrService uService, PersonRepository pRep, 
			RoleeRepository rRep, PersonRoleRepository prolRep*/) {
		return (args) -> {
			topicService.createTopic(new Topic("Microservice with spring boot", "12345"));
			topicService.createTopic(new Topic("Concurrency"));
			topicService.createTopic(new Topic("Node JS"));
			topicService.createTopic(new Topic("REST"));
			topicService.createTopic(new Topic("NoSQL"));
			topicService.createTopic(new Topic("Angular", "12345"));
			topicService.createTopic(new Topic("Testing"));
			topicService.createTopic(new Topic("ORM"));
			topicService.createTopic(new Topic("OAUTH"));
			topicService.createTopic(new Topic("SOAP"));
			
			resourceService.createResource(new Resource("Microservice with spring boot", "https://www.udemy.com/microservice-with-spring-boot", 1));
			resourceService.createResource(new Resource("Build microservice", "https://www.udemy.com/build-microservice", 1));
			resourceService.createResource(new Resource("Spring boot JPA", "https://www.udemy.com/spring-boot-JPA", 1));
			resourceService.createResource(new Resource("Concurrency patterns", "https://www.udemy.com/concurrency-patterns", 2));
			resourceService.createResource(new Resource("Multithreadin-patterns-presentation", "https://www.udemy.com/multithreadin-patterns-presentation", 2));
			
			System.out.println(topicService.findAllTopicsByOwnerId("12345"));
		};
	}
	
}
