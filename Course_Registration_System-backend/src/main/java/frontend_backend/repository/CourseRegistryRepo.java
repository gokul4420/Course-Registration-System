package frontend_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frontend_backend.model.CourseRegistry;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry,Integer> {

}