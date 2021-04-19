package com.te.springmvc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class EmployeeBean implements Serializable {

	@Id
	@Column
	private Integer empid;

	@Column
	private String firstName;

	@Column
	private String LastName;

	@Column
	private Date dob;

	@Column
	private String email;

	@Column
	private String password;

}
