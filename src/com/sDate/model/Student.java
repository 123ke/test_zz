package com.sDate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="JPA_STUDENT")
public class Student {
	private Integer id;
	private String name;
	private String email;
	private Date brith;
	private Address address;
	private Integer addressId;
	
	
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBrith() {
		return brith;
	}
	public void setBrith(java.util.Date date) {
		this.brith = (Date) date;
	}
	@JoinColumn(name="ADDRESS_ID")
	@ManyToOne
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Column(name="ADD_ID")
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", brith=" + brith + ", address=" + address + "]";
	}
}
