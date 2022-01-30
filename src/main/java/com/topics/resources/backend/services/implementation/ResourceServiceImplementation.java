package com.topics.resources.backend.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topics.resources.backend.entities.Resource;
import com.topics.resources.backend.repositories.ResourceRepository;
import com.topics.resources.backend.services.interfaces.ResourceServiceInterface;

/**
 * Services to be used when handling resources
 * @author victor.mora
 *
 */

@Service
public class ResourceServiceImplementation implements ResourceServiceInterface {

	private ResourceRepository resRepo;
	
	@Autowired
	public ResourceServiceImplementation(ResourceRepository resRepo) {
		this.resRepo=resRepo;
	}
	
	/**
	 * Creates a new resource
	 * @param newResource the new resource to add in the repository
	 * @return the added new resource
	 */
	@Override
	public Resource createResource(Resource newResource) {
		return resRepo.save(newResource);
	}
	
	/**
	 * Finds a resource by a given id
	 * @param resourceId the id for the resource to be found
	 * @return the resource with the given id, null if no resource found
	 */
	@Override
	public Resource findResourceById(long resourceId) {
		return resRepo.findById(resourceId).get();
	}
	
	/**
	 * Finds all the resources in the repository
	 * @return a list with all the resources in the repository
	 */
	@Override
	public List<Resource> findAllResources(){
		return (List<Resource>) resRepo.findAll();
	}
	
	/**
	 * Finds all the resources that has the specified ownerId
	 * @param ownerId the id of the owner 
	 * @return all the resources which ownerId's is the same as the one passed over
	 */
	@Override
	public List<Resource> findAllResourcesByOwnerId(String ownerId){
		return resRepo.findAllByOwnerId(ownerId);
	}
	
	/**
	 * Searchs a resource with the given id, if found, swaps its information with the one in editedResource
	 * @param resourceId the id for the resource to search
	 * @param editedResource the resource with the new information to be replaced in the repository
	 * @return the edited resource, null if resource not found for the given id
	 */
	@Override
	public Resource editResource(long resourceId, Resource editedResource) {
		if(this.findResourceById(resourceId)!=null) {
			Resource toEditResource = this.findResourceById(resourceId);
			toEditResource.setResourceName(editedResource.getResourceName());
			toEditResource.setResourceURL(editedResource.getResourceURL());
			toEditResource.setTopicId(editedResource.getTopicId());
			return resRepo.save(toEditResource);
		}
		return null;
	}
	
	/**
	 * Deletes a resource given its id
	 * @param resourceId the id of the resource to be deleted
	 */
	@Override
	public void deleteResource(long resourceId) {
		resRepo.deleteById(resourceId);
	}
	
}
