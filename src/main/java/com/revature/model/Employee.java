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
public class Employee {
	
	@Id
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String sensitiveInfo;
	
	@JoinColumn(name="manager_name")
	@ManyToOne
	private Employee manager;
	
	@Column(name="im_a_manager")
	private boolean isManager;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password, String sensitiveInfo, Employee manager, boolean isManager) {
		super();
		this.username = username;
		this.password = password;
		this.sensitiveInfo = sensitiveInfo;
		this.manager = manager;
		this.isManager = isManager;
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

	public String getSensitiveInfo() {
		return sensitiveInfo;
	}

	public void setSensitiveInfo(String sensitiveInfo) {
		this.sensitiveInfo = sensitiveInfo;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isManager ? 1231 : 1237);
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sensitiveInfo == null) ? 0 : sensitiveInfo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (isManager != other.isManager)
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sensitiveInfo == null) {
			if (other.sensitiveInfo != null)
				return false;
		} else if (!sensitiveInfo.equals(other.sensitiveInfo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", sensitiveInfo=" + sensitiveInfo
				+ ", manager=" + manager + ", isManager=" + isManager + "]";
	}

	
	
	
	
	
}
