package com.topics.resources.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.topics.resources.backend.entities.Topic;

/**
 * Repository to save all topics
 * @author victor.mora
 *
 */

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long>{
	
	public List<Topic> findAllByOwnerId(String ownerId);
	
}
