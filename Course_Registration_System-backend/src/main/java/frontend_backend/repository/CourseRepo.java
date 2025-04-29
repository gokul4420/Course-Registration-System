package frontend_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frontend_backend.model.Course;

@Repository                                       //entity name model, type
public interface CourseRepo extends JpaRepository<Course,String> {

}
