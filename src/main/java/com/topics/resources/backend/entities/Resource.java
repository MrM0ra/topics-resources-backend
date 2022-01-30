package com.topics.resources.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Resource entity for the db model
 * @author victor.mora
 *
 */

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resourceId;
	
	private String resourceName;
	
	private String resourceURL;
	
	private long topicId;
	
	private String ownerId;

	public Resource() {
		
	}
	
	public Resource(String resourceName, String resourceURL, long topicId) {
		super();
		this.resourceName = resourceName;
		this.resourceURL = resourceURL;
		this.topicId = topicId;
	}
	
	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	public String getResourceURL() {
		return resourceURL;
	}

	public void setResourceURL(String topicURL) {
		this.resourceURL = topicURL;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	
	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
}
