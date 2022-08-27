package Admin_Service;

public class Admin {
	String name;
	String surname;
	String StuffId;
	String JobTitle;
	String title;
	String service;
	/**
	 * Accessors and mutators
	 * @return
	 */
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	
	
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

	public String getStuffId() {
		return StuffId;
	}

	public void setStuffId(String stuffId) {
		StuffId = stuffId;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
}
