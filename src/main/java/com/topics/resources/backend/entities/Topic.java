package com.topics.resources.backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(targetEntity=Resource.class, mappedBy="topicId", fetch=FetchType.EAGER)
	private List<Long> resources;	
	
	private String ownerId;

	public Topic() {
		
	}
	
	public Topic(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public Topic(String topicDescription, String ownerId) {
		this.topicDescription = topicDescription;
		this.ownerId=ownerId;
	}
	
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

	public List<Long> getResources() {
		return resources;
	}

	public void setResources(List<Long> resources) {
		this.resources = resources;
	}

	public int getResourcesCount() {
		return this.getResources()!=null ? this.getResources().size() : 0;
	}
	
	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	
	
}
