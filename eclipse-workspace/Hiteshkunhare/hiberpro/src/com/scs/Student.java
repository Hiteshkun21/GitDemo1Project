package com.scs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Student")
public class Student {
@Id	
private int rno;
@Column
 private String sname;
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
 
}
