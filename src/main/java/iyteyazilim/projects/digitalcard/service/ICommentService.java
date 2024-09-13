package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Comment;

import java.util.List;

public interface ICommentService {
    public void addComment(Comment comment);
    public List<Comment> getComment();
    public Comment getComment(Integer id);
    public void updateComment(Integer id, Comment comment);
    public void deleteComment(Integer id);
}
