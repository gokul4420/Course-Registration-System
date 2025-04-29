package frontend_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import frontend_backend.model.Course;
import frontend_backend.model.CourseRegistry;
import frontend_backend.model.User;
import frontend_backend.repository.CourseRegistryRepo;
import frontend_backend.repository.CourseRepo;
import frontend_backend.repository.UserRepositry;

@Service
public class CourseService {
	
	@Autowired
	CourseRepo courserepo;
	
	@Autowired
	CourseRegistryRepo courseregistryrepo;
	
	@Autowired
	UserRepositry userrepository;
	
	public List<Course> availableCourses() {
		return courserepo.findAll();
		
	}

	public List<CourseRegistry> registerStudents() {
		return courseregistryrepo.findAll();
		
	}

	public String enrollStudents(String name, String emailId, String courseName,boolean amountpaid) {
		CourseRegistry courseregistry=new CourseRegistry(name,emailId,courseName,amountpaid);
		 courseregistryrepo.save(courseregistry);
		return "add";
		
	}

//	public Course updatecourse(String courseId, String courseName, String trainer, int durationInWeeks) {
//		Course obj=courserepo.findById(courseId).orElseThrow();
//		obj.setCourseId(courseId);
//		obj.setCourseName(courseName);
//		obj.setDurationInWeeks(durationInWeeks);
//		obj.setTrainer(trainer);
//		return courserepo.save(obj);
//		
//		
//	}
	public Course updatecourse(String courseId, String courseName, String trainer, int durationInWeeks,int coursefee) {
	    Course obj = courserepo.findById(courseId).orElseThrow();
	    obj.setCourseId(courseId);
	    obj.setCourseName(courseName);
	    obj.setTrainer(trainer);
	    obj.setDurationInWeeks(durationInWeeks);
	    obj.setCoursefee(coursefee);
	    return courserepo.save(obj);
	}


	public String courseRegistration(String courseId, String courseName, String trainer, int durationInWeeks,int coursefee) {
		Course cu=new Course(courseId,courseName,trainer,durationInWeeks,coursefee);
		courserepo.save(cu);
		return "course added sucessfully";
		
	}

	public void updateStudent(int id,CourseRegistry cs) {
		CourseRegistry cr= courseregistryrepo.findById(id).orElseThrow();
		cr.setName(cs.getName());
		cr.setEmailId(cs.getEmailId());
		cr.setCourseName(cs.getCourseName());
		cr.setAmountpaid(cs.isAmountpaid());
		
		courseregistryrepo.save(cr);
	}

	public void deleteStudents(int id) {
		courseregistryrepo.deleteById(id);
		
	}

	public void deleteStudents(String courseId) {
		courserepo.deleteById(courseId);
	}

	

	public Optional<Course> availableonecourse(String courseId) {
		 return courserepo.findById(courseId);
		 
		
	}

	public Optional<CourseRegistry> availableonestudents(int id) {
		return courseregistryrepo.findById(id);
	}

	public String loginpage(User user) {
		User us=userrepository.findByUsername(user.getUsername());
		if(us!=null && us.getPassword().equals(user.getPassword()) && us.getRole().equals(user.getRole()) ) {
			return "true";
		}
		else {
			return "false";
		}
	}

	public List<Course> getallcourse() {
		return courserepo.findAll();
	}

	public String Signuppage(User user) {
		userrepository.save(user);
		return "user added successfully";
		
	}

	public List<User> getalluserrecords() {
		return userrepository.findAll();
	}

//	public List<CourseRegistry> getAllEnrolled() {
//        return courseregistryrepo.findAll();
//    }

//	public void updateCourse(Course course){
//		courserepo.save(course);
//	}
}
	

	
	
//	public Student updatestudent(int rno, Student student) {
//		Student ob=studentrepository.findById(rno).orElseThrow();
//		ob.setName(student.getName());
//		ob.setGender(student.getGender());
//		ob.setTechnology(student.getTechnolgy());
//		return studentrepository.save(ob);
//
//}
