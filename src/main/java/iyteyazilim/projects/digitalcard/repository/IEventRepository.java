package iyteyazilim.projects.digitalcard.repository;

import iyteyazilim.projects.digitalcard.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event, Long> {
}
