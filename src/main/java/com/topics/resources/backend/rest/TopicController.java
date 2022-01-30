package com.topics.resources.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class TopicController {

	@Autowired
	private TopicServiceImplementation topicService;
	
	/**
	 * Returns every single Topic on the db
	 * @return all the topics in the db
	 */
	@GetMapping("/topics")
	private List<Topic> getTopics() {
		return topicService.findAllTopics();
	}
	
	@GetMapping("/topics/{ownerId}")
	public List<Topic> getTopicsByOwnerId(@PathVariable String ownerId) {
		return topicService.findAllTopicsByOwnerId(ownerId);
	}
	
	/**
	 * Returns a Topic with the specified id
	 * @param topicId the id of the Topic
	 * @return Topic with the specific id, null if it doesn't exists
	 */
	@GetMapping("/topics/{topicId}")
	private Topic getTopic(@PathVariable long topicId) {
		return topicService.findTopicById(topicId);
	}
	
	/**
	 * Adds a new topic to the db
	 * @param topic the topic to be added to the database
	 * @return the created new topic on the database
	 */
	@PostMapping("/topics")
	private Topic addTopics(@RequestBody Topic topic) {
		return topicService.createTopic(topic);
	}
	
	/**
	 * Edits an existent topic from the database
	 * @param topicId the id of the topic to be modified
	 * @param topic a topic with the new information to insert into the modifying topic
	 * @return the modified topic, null if the id doesn't exists
	 */
	@PutMapping("/topics/{topicId}")
	private Topic getTopic(@PathVariable long topicId, @RequestBody Topic topic) {
		return topicService.editTopic(topicId, topic);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/topics/top")
	private List<Topic> getTopTopics() {
		return topicService.topTopics();
	}
}
