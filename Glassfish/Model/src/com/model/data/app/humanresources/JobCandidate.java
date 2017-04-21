package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the JobCandidate database table.
 * 
 */
@Entity(name="JobCandidate")
@Table(name="JobCandidate", schema="HumanResources")
@Access(AccessType.FIELD)
public class JobCandidate extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JobCandidateID")
	private int jobCandidateID;
	
	@Column(name="JobCandidateID", updatable = false, insertable = false)
	@Basic(optional = false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Resume")
	private String resume;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID")
	private Employee employee;

	public JobCandidate() {
	}

	public int getJobCandidateID() {
		return this.jobCandidateID;
	}

	public void setJobCandidateID(int jobCandidateID) {
		this.jobCandidateID = jobCandidateID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}