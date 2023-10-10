package com.kgisl.cmtool.entity;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "CM_CASE_DOC")
public class CmCaseDoc {

	@EmbeddedId
	private CmCaseDocId cmCaseDocId;

	@Column(name = "DELETE_IND")
	private String deleteInd;

//	@Column(name = "LAST_MODIFIED_BY")
//	private String lastModifiedBy;
//
//	@Column(name = "LAST_MODIFIED_DATE")
//	private Timestamp lastModifiedDate;

	@ManyToOne
	@JoinColumn(name = "SUB_PROCESS_ID", referencedColumnName = "SUB_PROCESS_ID", insertable = false, updatable = false)
	private CmSubProcess cmSubProcess;
	
	@ManyToOne
	@JoinColumn(name = "DOCU_ID", referencedColumnName = "DOC_ID", insertable = false, updatable = false)
	private CmDocument cmDocument;

	public CmCaseDocId getCmCaseDocId() {
		return cmCaseDocId;
	}

	public void setCmCaseDocId(CmCaseDocId cmCaseDocId) {
		this.cmCaseDocId = cmCaseDocId;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public CmSubProcess getCmSubProcess() {
		return cmSubProcess;
	}

	public void setCmSubProcess(CmSubProcess cmSubProcess) {
		this.cmSubProcess = cmSubProcess;
	}

	public CmDocument getCmDocument() {
		return cmDocument;
	}

	public void setCmDocument(CmDocument cmDocument) {
		this.cmDocument = cmDocument;
	}

}
