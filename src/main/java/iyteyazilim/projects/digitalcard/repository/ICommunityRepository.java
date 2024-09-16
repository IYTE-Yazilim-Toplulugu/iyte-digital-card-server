package iyteyazilim.projects.digitalcard.repository;

import iyteyazilim.projects.digitalcard.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ICommunityRepository extends JpaRepository<Community, Long> {
    Optional<Community> findByEmail(String email);
}
