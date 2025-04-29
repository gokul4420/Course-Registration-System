package frontend_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String courseId;
	private String courseName;
	private String trainer;
	private int durationInWeeks;
	private int coursefee;
	
	public Course(String courseId, String courseName, String trainer, int durationInWeeks,int coursefee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.trainer = trainer;
		this.durationInWeeks = durationInWeeks;
		this.coursefee=coursefee;
	}
    public Course() {
		
	}
	
	public int getCoursefee() {
		return coursefee;
	}

	public void setCoursefee(int coursefee) {
		this.coursefee = coursefee;
	}

	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public int getDurationInWeeks() {
		return durationInWeeks;
	}
	public void setDurationInWeeks(int durationInWeeks) {
		this.durationInWeeks = durationInWeeks;
	}

}
