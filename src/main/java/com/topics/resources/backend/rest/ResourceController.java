package com.topics.resources.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topics.resources.backend.entities.Resource;
import com.topics.resources.backend.services.implementation.ResourceServiceImplementation;

/**
 * Rest controller for the resources operations
 * @author victor.mora
 *
 */

@RestController
public class ResourceController {

	@Autowired
	private ResourceServiceImplementation resourceService;
	
	/**
	 * Returns every single Resource on the db
	 * @return all the resources in the db
	 */
	@GetMapping("/resource")
	public List<Resource> getResources(){
		return resourceService.findAllResources();
	}
	
	/**
	 * Returns a Resource with the specified id
	 * @param resourceId the id of the Resource
	 * @return Resource with the specific id, null if it doesn't exists
	 */
	@GetMapping("/resource/{resourceId}")
	public Resource getResource(@PathVariable long resourceId) {
		return resourceService.findResourceById(resourceId);
	}
	
	/**
	 * Adds a new Resource to the db
	 * @param resource the Resource to be added to the database
	 * @return the created new Resource on the database
	 */
	@PostMapping("/resources")
	public Resource addReaource(@RequestBody Resource resource) {
		return resourceService.createResource(resource);
	}
	
	/**
	 * Edits an existent Resource from the database
	 * @param resource a Resource with the new information to insert into the modifying Resource
	 * @param resourceId the id of the Resource to be modified
	 * @return the modified Resource, null if the id doesn't exists
	 */
	@PutMapping("resources/{resourceId}")
	public Resource editResource(@RequestBody Resource resource, @PathVariable long resourceId) {
		return resourceService.editResource(resourceId, resource);
	}
	
}
