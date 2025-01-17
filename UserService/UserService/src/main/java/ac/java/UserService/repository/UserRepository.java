package ac.java.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac.java.UserService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
