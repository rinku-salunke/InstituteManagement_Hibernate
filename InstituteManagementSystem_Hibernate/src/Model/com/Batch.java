package Model.com;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Batch {

@Id	
private int bid;

private String bname;


@ManyToOne(cascade = CascadeType.ALL)
private Faculty faculty;


public int getBid() {
	return bid;
}


public void setBid(int bid) {
	this.bid = bid;
}


public String getBname() {
	return bname;
}


public void setBname(String bname) {
	this.bname = bname;
}


public Faculty getFaculty() {
	return faculty;
}


public void setFaculty(Faculty faculty) {
	this.faculty = faculty;
}
}

