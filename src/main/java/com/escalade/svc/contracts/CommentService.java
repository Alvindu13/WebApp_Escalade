package com.escalade.svc.contracts;

import com.escalade.data.model.Comment;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface CommentService {

    void saveComment(Comment c);
    Page<Comment> getAllCommentBySiteId(int siteId, Pageable pageable);

}
