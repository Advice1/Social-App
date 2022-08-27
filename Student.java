package multiImageRetrival;
//controller class
public class Student {
	//declaring variable
	private String name;
	private String surname;
	private String department;
	private String StdNumber;
	private String facebook;
	
	private String instagram;
	private String tweeter;
	
	public Student() {}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Accessors and mutators#################################### 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStdNumber() {
		return StdNumber;
	}
	public void setStdNumber(String stdNumber) {
		StdNumber = stdNumber;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTweeter() {
		return tweeter;
	}
	public void setTweeter(String tweeter) {
		this.tweeter = tweeter;
	}

}
