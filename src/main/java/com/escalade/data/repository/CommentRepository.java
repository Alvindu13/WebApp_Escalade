package com.escalade.data.repository;

import com.escalade.data.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    Page<Comment> findAllBySiteId(int siteId, Pageable pageable);
}
