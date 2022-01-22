package com.topics.resources.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Topic class for the db model
 * @author victor.mora
 *
 */
@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long topicId;
	
	private String topicDescription;
	
	private String topicURL;
	
	private List<Long> resources;

	
	
	
	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public String getTopicURL() {
		return topicURL;
	}

	public void setTopicURL(String topicURL) {
		this.topicURL = topicURL;
	}

	public List<Long> getResources() {
		return resources;
	}

	public void setResources(List<Long> resources) {
		this.resources = resources;
	}
	
	
	
	
	
}
