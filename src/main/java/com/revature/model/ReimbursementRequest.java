package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class ReimbursementRequest {
	
	@Id
	@Column(name="request_id")
	@GeneratedValue(generator = "req_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "req_id_seq", sequenceName = "req_id_seq")
	private int id;
	@Column
	private String description;
	@Column
	private double amount_requested;
	@Column
	boolean approved_status;
	
	@JoinColumn(name="created_by")
	@ManyToOne
	private Employee employee;
	
	@JoinColumn(name="manager")
	@ManyToOne
	private Employee manager;
	
	@JoinColumn(name="approved_by")
	@ManyToOne
	private Employee approver;

	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementRequest(int id, String description, double amount_requested, boolean approved_status,
			Employee employee, Employee manager, Employee approver) {
		super();
		this.id = id;
		this.description = description;
		this.amount_requested = amount_requested;
		this.approved_status = approved_status;
		this.employee = employee;
		this.manager = manager;
		this.approver = approver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount_requested() {
		return amount_requested;
	}

	public void setAmount_requested(double amount_requested) {
		this.amount_requested = amount_requested;
	}

	public boolean isApproved_status() {
		return approved_status;
	}

	public void setApproved_status(boolean approved_status) {
		this.approved_status = approved_status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Employee getApprover() {
		return approver;
	}

	public void setApprover(Employee approver) {
		this.approver = approver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount_requested);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (approved_status ? 1231 : 1237);
		result = prime * result + ((approver == null) ? 0 : approver.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementRequest other = (ReimbursementRequest) obj;
		if (Double.doubleToLongBits(amount_requested) != Double.doubleToLongBits(other.amount_requested))
			return false;
		if (approved_status != other.approved_status)
			return false;
		if (approver == null) {
			if (other.approver != null)
				return false;
		} else if (!approver.equals(other.approver))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [id=" + id + ", description=" + description + ", amount_requested="
				+ amount_requested + ", approved_status=" + approved_status + ", employee=" + employee + ", manager="
				+ manager + ", approver=" + approver + "]";
	}

	
	
}
