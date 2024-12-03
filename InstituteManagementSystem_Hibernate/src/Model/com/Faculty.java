
	package Model.com;

	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;

	@Entity
	public class Faculty {

	@Id
	private int fid;

	private String fname;

@ManyToOne(cascade=CascadeType.ALL)
private Course course;

public int getFid() {
	return fid;
}

public void setFid(int fid) {
	this.fid = fid;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}
}


