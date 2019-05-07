package com.radt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	public User() {
		super();
	}
	public User(Long id, String username, String password, String email, String city, String lattitue, String longitude,
			String temperature, Date creationDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
		this.lattitue = lattitue;
		this.longitude = longitude;
		this.temperature = temperature;
		this.creationDate = creationDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long   id;
	private String username;
	private String password;
	private String email;
	private String city;
	private String lattitue;
	private String longitude;
	private String temperature;
    
    @CreationTimestamp
    private Date   creationDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLattitue() {
		return lattitue;
	}
	public void setLattitue(String lattitue) {
		this.lattitue = lattitue;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", city="
				+ city + ", lattitue=" + lattitue + ", longitude=" + longitude + ", temperature=" + temperature
				+ ", creationDate=" + creationDate + "]";
	}
    
	
}
