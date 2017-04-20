package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee extends com.core.app.modelo.Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID")
	private int businessEntityID;

	@Column(name="BirthDate")
	private Object birthDate;

	@Column(name="CurrentFlag")
	private boolean currentFlag;

	@Column(name="Gender")
	private Object gender;

	@Column(name="HireDate")
	private Object hireDate;

	@Column(name="JobTitle")
	private Object jobTitle;

	@Column(name="LoginID")
	private Object loginID;

	@Column(name="MaritalStatus")
	private Object maritalStatus;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="NationalIDNumber")
	private Object nationalIDNumber;

	@Column(name="OrganizationLevel")
	private short organizationLevel;

	@Column(name="OrganizationNode")
	private String organizationNode;

	private String rowguid;

	@Column(name="SalariedFlag")
	private boolean salariedFlag;

	@Column(name="SickLeaveHours")
	private short sickLeaveHours;

	@Column(name="VacationHours")
	private short vacationHours;

	//bi-directional many-to-one association to EmployeeDepartmentHistory
	@OneToMany(mappedBy="employee")
	private List<EmployeeDepartmentHistory> employeeDepartmentHistories;

	//bi-directional many-to-one association to EmployeePayHistory
	@OneToMany(mappedBy="employee")
	private List<EmployeePayHistory> employeePayHistories;

	//bi-directional many-to-one association to JobCandidate
	@OneToMany(mappedBy="employee")
	private List<JobCandidate> jobCandidates;

	public Employee() {
	}

	public int getBusinessEntityID() {
		return this.businessEntityID;
	}

	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}

	public Object getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Object birthDate) {
		this.birthDate = birthDate;
	}

	public boolean getCurrentFlag() {
		return this.currentFlag;
	}

	public void setCurrentFlag(boolean currentFlag) {
		this.currentFlag = currentFlag;
	}

	public Object getGender() {
		return this.gender;
	}

	public void setGender(Object gender) {
		this.gender = gender;
	}

	public Object getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Object hireDate) {
		this.hireDate = hireDate;
	}

	public Object getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(Object jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Object getLoginID() {
		return this.loginID;
	}

	public void setLoginID(Object loginID) {
		this.loginID = loginID;
	}

	public Object getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(Object maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Object getNationalIDNumber() {
		return this.nationalIDNumber;
	}

	public void setNationalIDNumber(Object nationalIDNumber) {
		this.nationalIDNumber = nationalIDNumber;
	}

	public short getOrganizationLevel() {
		return this.organizationLevel;
	}

	public void setOrganizationLevel(short organizationLevel) {
		this.organizationLevel = organizationLevel;
	}

	public String getOrganizationNode() {
		return this.organizationNode;
	}

	public void setOrganizationNode(String organizationNode) {
		this.organizationNode = organizationNode;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public boolean getSalariedFlag() {
		return this.salariedFlag;
	}

	public void setSalariedFlag(boolean salariedFlag) {
		this.salariedFlag = salariedFlag;
	}

	public short getSickLeaveHours() {
		return this.sickLeaveHours;
	}

	public void setSickLeaveHours(short sickLeaveHours) {
		this.sickLeaveHours = sickLeaveHours;
	}

	public short getVacationHours() {
		return this.vacationHours;
	}

	public void setVacationHours(short vacationHours) {
		this.vacationHours = vacationHours;
	}

	public List<EmployeeDepartmentHistory> getEmployeeDepartmentHistories() {
		return this.employeeDepartmentHistories;
	}

	public void setEmployeeDepartmentHistories(List<EmployeeDepartmentHistory> employeeDepartmentHistories) {
		this.employeeDepartmentHistories = employeeDepartmentHistories;
	}

	public EmployeeDepartmentHistory addEmployeeDepartmentHistory(EmployeeDepartmentHistory employeeDepartmentHistory) {
		getEmployeeDepartmentHistories().add(employeeDepartmentHistory);
		employeeDepartmentHistory.setEmployee(this);

		return employeeDepartmentHistory;
	}

	public EmployeeDepartmentHistory removeEmployeeDepartmentHistory(EmployeeDepartmentHistory employeeDepartmentHistory) {
		getEmployeeDepartmentHistories().remove(employeeDepartmentHistory);
		employeeDepartmentHistory.setEmployee(null);

		return employeeDepartmentHistory;
	}

	public List<EmployeePayHistory> getEmployeePayHistories() {
		return this.employeePayHistories;
	}

	public void setEmployeePayHistories(List<EmployeePayHistory> employeePayHistories) {
		this.employeePayHistories = employeePayHistories;
	}

	public EmployeePayHistory addEmployeePayHistory(EmployeePayHistory employeePayHistory) {
		getEmployeePayHistories().add(employeePayHistory);
		employeePayHistory.setEmployee(this);

		return employeePayHistory;
	}

	public EmployeePayHistory removeEmployeePayHistory(EmployeePayHistory employeePayHistory) {
		getEmployeePayHistories().remove(employeePayHistory);
		employeePayHistory.setEmployee(null);

		return employeePayHistory;
	}

	public List<JobCandidate> getJobCandidates() {
		return this.jobCandidates;
	}

	public void setJobCandidates(List<JobCandidate> jobCandidates) {
		this.jobCandidates = jobCandidates;
	}

	public JobCandidate addJobCandidate(JobCandidate jobCandidate) {
		getJobCandidates().add(jobCandidate);
		jobCandidate.setEmployee(this);

		return jobCandidate;
	}

	public JobCandidate removeJobCandidate(JobCandidate jobCandidate) {
		getJobCandidates().remove(jobCandidate);
		jobCandidate.setEmployee(null);

		return jobCandidate;
	}

}