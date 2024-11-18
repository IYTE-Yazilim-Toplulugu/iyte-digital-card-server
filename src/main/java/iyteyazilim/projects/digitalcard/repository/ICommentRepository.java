package iyteyazilim.projects.digitalcard.repository;

import iyteyazilim.projects.digitalcard.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
