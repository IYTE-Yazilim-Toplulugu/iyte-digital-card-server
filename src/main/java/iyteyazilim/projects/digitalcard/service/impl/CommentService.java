package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Comment;
import iyteyazilim.projects.digitalcard.repository.ICommentRepository;
import iyteyazilim.projects.digitalcard.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public List<Comment> getComment() {
        return null;
    }

    @Override
    public Comment getComment(Integer id) {
        return null;
    }

    @Override
    public void updateComment(Integer id, Comment comment) {

    }

    @Override
    public void deleteComment(Integer id) {

    }
}
