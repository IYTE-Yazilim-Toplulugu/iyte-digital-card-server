package iyteyazilim.projects.digitalcard.repository;

import iyteyazilim.projects.digitalcard.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICommunityRepository extends JpaRepository<Community, Long> {
    
}
