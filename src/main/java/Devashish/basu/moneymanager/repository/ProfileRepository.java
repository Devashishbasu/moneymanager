package Devashish.basu.moneymanager.repository;

import Devashish.basu.moneymanager.entity.ProfileEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
  Optional<ProfileEntity> findByEmail(String email);
}
