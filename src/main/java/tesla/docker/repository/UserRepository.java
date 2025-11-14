package tesla.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesla.docker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
