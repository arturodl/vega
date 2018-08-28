package com.model.data.app.humanresources;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.core.app.modelo.Entidad;
import com.core.app.otd.xml.CustomDateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement(name="Department")
@Entity(name="Department")
@Table(name="Department") //, schema="HumanResources"      
@Access(AccessType.FIELD)
public class Department extends Entidad implements Serializable{
	
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;

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
   @Temporal(TemporalType.TIMESTAMP)
   @Basic(optional=true)   
   private Date modifiedDate;
	
   @XmlTransient
   @JsonIgnore
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

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss a z")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ"
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", 
				timezone = "America/Mexico_City", locale = "es_MX")
	@XmlJavaTypeAdapter(CustomDateTimeFormatter.class)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

  
}
