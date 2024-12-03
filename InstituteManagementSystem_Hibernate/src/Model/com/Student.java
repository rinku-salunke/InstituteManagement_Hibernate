package Model.com;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	
@Id
private int sid;
private String sname;

@ManyToOne(cascade = CascadeType.ALL)
private Batch batch;


public int getSid() {
	return sid;
}


public void setSid(int sid) {
	this.sid = sid;
}


public String getSname() {
	return sname;
}


public void setSname(String sname) {
	this.sname = sname;
}


public Batch getBatch() {
	return batch;
}


public void setBatch(Batch batch) {
	this.batch = batch;
}
}
