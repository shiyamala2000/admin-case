package com.kgisl.cmtool.entity;

import java.security.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "CM_PROCESS")
public class CmProcess {

	@Id
	@Column(name = "PROCESS_ID")
	private String processId;

	@Column(name = "PROCESS_NAME")
	private String processName;

	@Column(name = "CM_CASE_ID")
	private String cmCaseId;

	@Column(name = "DELETE_IND")
	private String deleteInd;

//	@Column(name = "LAST_MODIFIED_BY")
//	private String lastModifiedBy;

//	@Column(name = "LAST_MODIFIED_DATE")
//	private Timestamp lastModifiedDate;

	@ManyToOne
	@JoinColumn(name = "CM_CASE_ID", referencedColumnName = "CASE_ID", insertable = false, updatable = false)
	private CmCase cmCase;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getCmCaseId() {
		return cmCaseId;
	}

	public void setCmCaseId(String cmCaseId) {
		this.cmCaseId = cmCaseId;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public CmCase getCmCase() {
		return cmCase;
	}

	public void setCmCase(CmCase cmCase) {
		this.cmCase = cmCase;
	}

}
