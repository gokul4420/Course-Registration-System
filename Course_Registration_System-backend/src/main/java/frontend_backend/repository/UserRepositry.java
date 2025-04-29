package frontend_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import frontend_backend.model.User;

public interface UserRepositry extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
