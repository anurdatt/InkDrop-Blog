package org.anuran.springstudy.data.repositories;

import org.anuran.springstudy.data.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
