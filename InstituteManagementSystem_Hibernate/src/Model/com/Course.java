package Model.com;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {	
	

@Id	
private int cid;


private String cname;

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
}
