package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Comment;
import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
import iyteyazilim.projects.digitalcard.repository.ICommentRepository;
import iyteyazilim.projects.digitalcard.repository.IUserRepository;
import iyteyazilim.projects.digitalcard.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Comment addComment(Comment comment) {
        comment.setDate(new Date());

        // Validate that a user is provided
        //if (comment.getUser() == null || comment.getUser().getId() == null) {
        //    throw new ValidationException("A valid User must be provided for the comment.");
        //}
        User user = userRepository.findById(comment.getUser().getId())
               .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + comment.getUser().getId()));

        comment.setUser(user);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment doesn't exist with given id : " + id));
    }

    @Override
    public Comment updateComment(Long id, Comment updatedComment) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment doesn't exist with given id: " + id));

        // Update only if fields are not null (optional based on your needs)
        if (updatedComment.getText() != null) {
            comment.setText(updatedComment.getText());
        }
        if (updatedComment.getRate() != 0) {  // Assuming `0` is not a valid rate
            comment.setRate(updatedComment.getRate());
        }

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment doesn't exist with given id : " + id));
        commentRepository.delete(comment);
    }
}
