package org.anuran.springstudy.data.repositories;

import org.anuran.springstudy.data.entites.views.TagView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagViewRepository extends JpaRepository<TagView, Integer> {

}
