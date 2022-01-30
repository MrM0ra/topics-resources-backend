package com.topics.resources.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.topics.resources.backend.entities.Resource;

/**
 * Repository to save all Resources
 * @author victor.mora
 *
 */

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {

	public List<Resource> findAllByOwnerId(String ownerId);
	
}
