package com.topics.resources.backend.services.interfaces;

import java.util.List;

import com.topics.resources.backend.entities.Topic;

public interface TopicServiceInterface {

	public Topic findTopicById(long topicId);
	public Topic createTopic(Topic topic);
	public List<Topic> findAllTopics();
	public Topic editTopic(long topicId, Topic editedTopic);
	public void deleteTopicById(long topicId);
	public List<Topic> topTopics();
	
}
