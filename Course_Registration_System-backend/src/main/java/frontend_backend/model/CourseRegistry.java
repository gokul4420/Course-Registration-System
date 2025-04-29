package frontend_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseRegistry {
	
	@Id  // to mention primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;// NO Need to provide value
	private String name;
	private String emailId;
	private String courseName;
	private boolean amountpaid;
	
	public boolean isAmountpaid() {
		return amountpaid;
	}
	public void setAmountpaid(boolean amountpaid) {
		this.amountpaid = amountpaid;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public CourseRegistry(String name, String emailId, String courseName,boolean amountpaid ) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.courseName = courseName;
		this.amountpaid=amountpaid;
		
	}
	public CourseRegistry() {
		
	}

}
