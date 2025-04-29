package frontend_backend.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import frontend_backend.model.Course;
import frontend_backend.model.CourseRegistry;
import frontend_backend.model.User;
import frontend_backend.service.CourseService;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {
	
	@Autowired
	CourseService courseservice;
	
	@PostMapping("/login")
	public String loginpage(@RequestBody User user) {
		return courseservice.loginpage(user);
		
	}
	
	@PostMapping("/Signup")
	public String Signuppage(@RequestBody User user) {
		return courseservice.Signuppage(user);
	}
	
	@GetMapping("/user_login")
	public List <User> getalluserrecords(){
		return courseservice.getalluserrecords();
	}
	
	@GetMapping("/courses")
	public List<Course>availableCourses(){
		return courseservice.availableCourses();
	}
	
	@GetMapping("courses/{courseId}")
	public Optional<Course> availableonecourses(@PathVariable ("courseId") String courseId){
		return courseservice.availableonecourse(courseId);
	}
	
	@GetMapping("courseRegistry")
	public List<CourseRegistry>registerStudents(){
		return courseservice.registerStudents();
	}
	
	@GetMapping("courseRegistry/{id}")
	public Optional<CourseRegistry>availableonestudents(@PathVariable ("id")int id){
		return courseservice.availableonestudents(id);
	}
	
	@GetMapping("/courses/all")
	public List<Course> getallcourse(){
		return courseservice.getallcourse();
	}
	
	@PostMapping("courses/enrollment")
	public String enrollStudents(@RequestParam ("name")String name,
			@RequestParam("emailId")String emailId,
			@RequestParam("courseName") String courseName,
			@RequestParam("amountpaid") boolean amountpaid) {
		 courseservice.enrollStudents(name,emailId,courseName,amountpaid);
		 return "Congradualations " +name+ "enrollment Successful "+courseName;
	}
	
//	 @GetMapping("/courses/enrolled")
//	 
//	 public List<CourseRegistry> getAllEnrolled() {
//		 return courseservice.getAllEnrolled();
//		 
//	    }
	
	@PostMapping("courses/Registration")
	public String courseRegistration(@RequestParam ("courseId")String courseId,
			@RequestParam("courseName")String courseName,
			@RequestParam("trainer")String trainer,
			@RequestParam( "durationInWeeks")int  durationInWeeks,
			@RequestParam("coursefee")int coursefee) {
	        courseservice.courseRegistration(courseId,courseName,trainer,durationInWeeks,coursefee);
	        return "Congratulation! course added successfully";
	}
	
	@PutMapping("courses/updatedcourses/{courseId}")
	public String updatecourse(@PathVariable ("courseId") String courseId,
			@RequestParam("courseName")String courseName,
			@RequestParam("trainer")String trainer,
     		@RequestParam( "durationInWeeks")int  durationInWeeks,
     		@RequestParam("coursefee")int coursefee) {
		courseservice.updatecourse(courseId,courseName,trainer,durationInWeeks,coursefee);
		return "updated succesfully";
	}
//	@PutMapping("courses/updatedcourses/{courseId}")
//	public String updatecourse(@PathVariable("courseId") String courseId,
//	                           @RequestParam("courseName") String courseName,
//	                           @RequestParam("trainer") String trainer,
//	                           @RequestParam("durationInWeeks") int durationInWeeks) {
//	    courseservice.updatecourse(courseId, courseName, trainer, durationInWeeks);
//	    return "Course updated successfully";
//	}

	@PutMapping("courses/updatedstudents/{id}")
	public String updateStudent(@PathVariable ("id")int id,@RequestBody CourseRegistry cs) {
		courseservice.updateStudent(id,cs);
		return "Student updated successfully";
	}
//	@DeleteMapping("/students/delete/{rno}")
//	public String deletestudent(@PathVariable int rno) {
//		 studentservice.deletestudent(rno);
//		 return "deleted";
//	}
	@DeleteMapping("course/delete/{id}")
	public String deleteStudents(@PathVariable int id) {
		courseservice.deleteStudents(id);
		return "deleted successfully";
	}
	
	@DeleteMapping("courses/delete/{courseId}")
	public String deletecourse(@PathVariable String courseId) {
		courseservice.deleteStudents(courseId);
		return "course deleted successfully";
	}
			
}
