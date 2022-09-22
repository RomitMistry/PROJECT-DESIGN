package model;

public class modelstudentreg {
	private int id;
	private String fname, lname, email, gender, password;
	private long phone;
	
	public int getid() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfname() {
		return fname;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}

	public String getlname() {
		return lname;
	}

	public void setlname(String lname) {
		this.lname = lname;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public long getphone() {
		return phone;
	}

	public void setphone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "modelstudentreg [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender="
				+ gender + ", password=" + password + ", phone=" + phone + "]";
	}


}
