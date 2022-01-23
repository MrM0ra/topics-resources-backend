package com.topics.resources.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topics.resources.backend.entities.Topic;
import com.topics.resources.backend.services.implementation.TopicServiceImplementation;

/**
 * Rest controller for the topics operations
 * @author victor.mora
 *
 */
@RestController
public class TopicController {

	@Autowired
	private TopicServiceImplementation topicService;
	
	@GetMapping("/topics")
	private List<Topic> getTopics() {
		return topicService.findAllTopics();
	}
	
	@GetMapping("/topics/{topicId}")
	private Topic getTopic(@PathVariable long topicId) {
		return topicService.findTopicById(topicId);
	}
	
	@PostMapping("/topics")
	private Topic addTopics(@RequestBody Topic topic) {
		return topicService.createTopic(topic);
	}
	
	@PutMapping("/topics/{topicId}")
	private Topic getTopic(@PathVariable long topicId, @RequestBody Topic topic) {
		return topicService.editTopic(topicId, topic);
	}
	
}
