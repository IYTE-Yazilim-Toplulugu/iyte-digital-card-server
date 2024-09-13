package iyteyazilim.projects.digitalcard.repository;

import iyteyazilim.projects.digitalcard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
