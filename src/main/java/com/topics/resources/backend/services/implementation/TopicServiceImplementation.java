package com.topics.resources.backend.services.implementation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topics.resources.backend.entities.Topic;
import com.topics.resources.backend.repositories.TopicRepository;
import com.topics.resources.backend.services.interfaces.TopicServiceInterface;

/**
 * Services to be used when handling topics
 * @author victor.mora
 *
 */

@Service
public class TopicServiceImplementation implements TopicServiceInterface {

	private TopicRepository topRepo;

	@Autowired
	public TopicServiceImplementation(TopicRepository topRepo) {
		this.topRepo=topRepo;
	}
	
	/**
	 * Looks for a topic with the given id
	 * @param topicId the id for the topic to look for
	 * @return Topic that has the given id if found, otherwise null
	 */
	@Override
	public Topic findTopicById(long topicId) {
		if(topRepo.existsById(topicId)) {
			return topRepo.findById(topicId).get();
		}else {
			return null;
		}
	}
	
	/**
	 * Creates a new Topic 
	 * @return the new topic created
	 */
	@Override
	public Topic createTopic(Topic topic) {
		topRepo.save(topic);
		return this.findTopicById(topic.getTopicId());
	}
	
	/**
	 * Returns every existent topic 
	 * @return All topics saved in the TopicRepository
	 */
	@Override
	public List<Topic> findAllTopics(){
		return (List<Topic>) topRepo.findAll();
	}
	
	/**
	 * Edits a existent topic, found with the given id, with editedTopic's information the information
	 * @param topicId id for the topic that is going to be edited
	 * @param editedTopic topic with the new information
	 * @return edited topic stored in the topic repository or null if no topic exists for the given id
	 */
	@Override
	public Topic editTopic(long topicId, Topic editedTopic) {
		if(this.findTopicById(topicId)!=null) {
			Topic toEdit = this.findTopicById(topicId);
			toEdit.setTopicDescription(editedTopic.getTopicDescription());
			return topRepo.save(toEdit);
		}else {
			return null;
		}
	}
	
	/**
	 * Deletes a topic
	 * @param topicId the id of the topic to be deleted
	 */
	@Override
	public void deleteTopicById(long topicId) {
		topRepo.deleteById(topicId);
	}

	/**
	 * Returns every existent topic in a list ordered by the quantity of resources
	 * @return All topics saved in the TopicRepository in a list ordered by the quantity of resources
	 */
	@Override
	public List<Topic> topTopics() {
		return this.findAllTopics().stream().sorted(Comparator.comparingInt(Topic::getResourcesCount).reversed()).collect(Collectors.toList());
	}
	
}
