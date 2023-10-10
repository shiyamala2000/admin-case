package com.kgisl.cmtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "CM_CUST_CASE")
public class CmCustCase {

	@Id
	@Column(name = "CASE_RELATION_ID")
	private String caseRelationId;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "SUB_PROCESS_ID")
	private String subProcessId;

	@Column(name = "POLICY_APPROVAL_STATUS")
	private String policyApprovalStatus;

	@Column(name = "DELETE_IND")
	private String deleteInd;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", insertable = false, updatable = false)
	private CmUser cmUser;

	@ManyToOne
	@JoinColumn(name = "SUB_PROCESS_ID", referencedColumnName = "SUB_PROCESS_ID", insertable = false, updatable = false)
	private CmSubProcess cmSubProcess;

	public String getCaseRelationId() {
		return caseRelationId;
	}

	public void setCaseRelationId(String caseRelationId) {
		this.caseRelationId = caseRelationId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSubProcessId() {
		return subProcessId;
	}

	public void setSubProcessId(String subProcessId) {
		this.subProcessId = subProcessId;
	}

	public String getPolicyApprovalStatus() {
		return policyApprovalStatus;
	}

	public void setPolicyApprovalStatus(String policyApprovalStatus) {
		this.policyApprovalStatus = policyApprovalStatus;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public CmUser getCmUser() {
		return cmUser;
	}

	public void setCmUser(CmUser cmUser) {
		this.cmUser = cmUser;
	}

	public CmSubProcess getCmSubProcess() {
		return cmSubProcess;
	}

	public void setCmSubProcess(CmSubProcess cmSubProcess) {
		this.cmSubProcess = cmSubProcess;
	}
}
