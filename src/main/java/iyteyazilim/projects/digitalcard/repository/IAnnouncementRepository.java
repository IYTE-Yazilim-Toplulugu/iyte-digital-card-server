package iyteyazilim.projects.digitalcard.repository;

import iyteyazilim.projects.digitalcard.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnnouncementRepository extends JpaRepository<Announcement, Long> {
}
