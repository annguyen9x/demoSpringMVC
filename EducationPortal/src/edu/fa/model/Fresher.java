package edu.fa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//Biểu diễn một table trong DB ???
public class Fresher {
	
	@Id//Biểu diễn cột id (là khóa chính) trong DB ???
	@GeneratedValue(strategy = GenerationType.AUTO)//Tự động tăng, không cần truyền vào ID
	private int id;
	private String username;
	private String password;
	private String location;
	@Column(name = "years")//Thay thế tên trong cột DB để không trùng từ khóa trong Derby DB
	private int year;
	
	public Fresher() {
		super();
	}

	public Fresher(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Fresher(String username, String password, String location, int year) {
		super();
		this.username = username;
		this.password = password;
		this.location = location;
		this.year = year;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "username=" + username + ", location=" + location + ";";
	}
	
}
