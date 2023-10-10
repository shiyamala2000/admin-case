package com.kgisl.cmtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CM_USER")
public class CmUser {
	
	@Id
	@Column(name="CUSTOMER_ID")
	private String customerId;
	
	@Column(name="CUSTOMER_FIRST_NAME")
	private String customeFirstName;
	
	@Column(name="CUSTOMER_LAST_NAME")
	private String customeLastName;
	
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	
	@Column(name="CUSTOMER_CONTACTNO")
	private String custContactNo;
	
	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;
	
	@Column(name="CUSTOMER_DOB")
	private String customerDob;
	
	@Column(name="CUSTOMER_STATUS")
	private String customerStatus;
	
	@Column(name="DELETE_IND")
	private String deleteInd;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomeFirstName() {
		return customeFirstName;
	}

	public void setCustomeFirstName(String customeFirstName) {
		this.customeFirstName = customeFirstName;
	}

	public String getCustomeLastName() {
		return customeLastName;
	}

	public void setCustomeLastName(String customeLastName) {
		this.customeLastName = customeLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustContactNo() {
		return custContactNo;
	}

	public void setCustContactNo(String custContactNo) {
		this.custContactNo = custContactNo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

}
