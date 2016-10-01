package com.model.data.app.humanresources;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name="Deparment")
@Table(name="Deparment",schema="HumanResources")
@Access(AccessType.FIELD)
public class Department {
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="DepartmentID")
   @Basic(optional=false)
   private Integer departmentID;
   
   @Column(name="Name")
   @Basic(optional=true)
   private String name;
   
   @Column(name="GroupName")
   @Basic(optional=true)
   private String groupName;
   
   @Column(name="ModifiedDate")
   @Temporal(TemporalType.DATE)
   @Basic(optional=true)
   private Date modifiedDate;
	
	public Integer getDepartmentID() {
		return departmentID;
	}
	
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

  
}
