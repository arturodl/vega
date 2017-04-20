package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the JobCandidate database table.
 * 
 */
@Entity
@NamedQuery(name="JobCandidate.findAll", query="SELECT j FROM JobCandidate j")
public class JobCandidate extends com.core.app.modelo.Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JobCandidateID")
	private int jobCandidateID;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Resume")
	private Object resume;

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

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Object getResume() {
		return this.resume;
	}

	public void setResume(Object resume) {
		this.resume = resume;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}