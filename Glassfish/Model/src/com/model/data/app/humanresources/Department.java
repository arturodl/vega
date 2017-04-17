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
import javax.xml.bind.annotation.XmlRootElement;

import com.core.app.modelo.Entidad;


@XmlRootElement(name="Department")
@Entity(name="Department")
@Table(name="Department", schema="HumanResources")
@Access(AccessType.FIELD)
public class Department extends Entidad{
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="DepartmentID")
   @Basic(optional=false)
   private Integer departmentID;
   
   @Column(name="DepartmentID", updatable = false, insertable = false)
   @Basic(optional = false)
   private Integer id;
   
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

  
}
