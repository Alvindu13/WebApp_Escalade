package com.escalade.svc.implementation;

import com.escalade.data.repository.CommentRepository;
import com.escalade.data.model.Comment;
import com.escalade.svc.contracts.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repo;

    /**
     * Créer un commentaire
     * @param c
     */
    @Override
    public void saveComment(Comment c) {
        repo.save(c);
    }

    /**
     * Récupère tous les commentaires
     * @param siteId filtre
     * @param pageable
     * @return
     */
    @Override
    public Page<Comment> getAllCommentBySiteId(int siteId, Pageable pageable) {
        return repo.findAllBySiteId(siteId, pageable);
    }


}
