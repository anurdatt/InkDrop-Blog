package org.anuran.springstudy.data.repositories;

import org.anuran.springstudy.data.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
