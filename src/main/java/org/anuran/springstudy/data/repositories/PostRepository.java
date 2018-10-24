package org.anuran.springstudy.data.repositories;

import org.anuran.springstudy.data.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

	
}
