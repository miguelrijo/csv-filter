package model.entities;

public class Record {
	
	private String lastName= "";
	private String firstName= "";
	private String hiredDate= "";
	private String department= "";
	private String reasonForRejection = "";
	private boolean validated = true;
	
	
	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
		this.validated = false;
	}

	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getHiredDate() {
		return hiredDate;
	}
	
	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
