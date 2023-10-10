package com.kgisl.cmtool.entity;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "CM_SUB_PROCESS")
public class CmSubProcess{

	@Id
    @Column(name = "SUB_PROCESS_ID")
    private String subProcessId;

    @Column(name = "SUB_PROCESS_NAME")
    private String subProcessName;

    @Column(name = "CM_PROCESS_ID")
    private String cmProcessId;

    @Column(name = "DELETE_IND")
    private String deleteInd;

//    @Column(name = "LAST_MODIFIED_BY")
//    private String lastModifiedBy;

//    @Column(name = "LAST_MODIFIED_DATE")
//    private Timestamp lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "CM_PROCESS_ID", referencedColumnName = "PROCESS_ID", insertable = false, updatable = false)
    private CmProcess cmProcess;

	public String getSubProcessId() {
		return subProcessId;
	}

	public void setSubProcessId(String subProcessId) {
		this.subProcessId = subProcessId;
	}

	public String getSubProcessName() {
		return subProcessName;
	}

	public void setSubProcessName(String subProcessName) {
		this.subProcessName = subProcessName;
	}

	public String getCmProcessId() {
		return cmProcessId;
	}

	public void setCmProcessId(String cmProcessId) {
		this.cmProcessId = cmProcessId;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public CmProcess getCmProcess() {
		return cmProcess;
	}

	public void setCmProcess(CmProcess cmProcess) {
		this.cmProcess = cmProcess;
	}

}
