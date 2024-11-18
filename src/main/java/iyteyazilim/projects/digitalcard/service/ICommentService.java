package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Comment;

import java.util.List;

public interface ICommentService {
    public Comment addComment(Comment comment);
    public List<Comment> getComments();
    public Comment getComment(Long id);
    public Comment updateComment(Long id, Comment comment);
    public void deleteComment(Long id);
}
