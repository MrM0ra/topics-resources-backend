package com.topics.resources.backend.services.interfaces;

import java.util.List;

import com.topics.resources.backend.entities.Resource;

public interface ResourceServiceInterface {

	public Resource createResource(Resource newResource);
	public Resource findResourceById(long resourceId);
	public List<Resource> findAllResources();
	public Resource editResource(long resourceId, Resource editedResource);
	public void deleteResource(long resourceId);
	
}
