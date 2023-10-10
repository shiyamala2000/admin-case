package com.kgisl.cmtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CM_CUST_CASE_LINK")
public class CmCustCaseLink {
	
	@EmbeddedId
	CmCustCaseLinkId caseLinkId;
	
	@Column(name="RECEIVED_STATUS")
	private String receivedStatus;
	
	@Column(name="RECEIVED_DATE")
	private String receivedDate;
	
	@Column(name="DOCU_DUE_DATE")
	private String docuDueDate;
	
	@Column(name="DOCU_APPROVAL")
	private String docuApproval;
	
	@Column(name = "DELETE_IND")
	private String deleteInd;
	
	@ManyToOne
    @JoinColumn(name = "CASE_RELATION_ID", referencedColumnName = "CASE_RELATION_ID", insertable = false, updatable = false)
    private CmCustCase cmCustCase;
	
	@ManyToOne
	@JoinColumn(name = "DOCU_ID", referencedColumnName = "DOC_ID", insertable = false, updatable = false)
    private CmDocument cmDocument;

	public CmCustCaseLinkId getCaseLinkId() {
		return caseLinkId;
	}

	public void setCaseLinkId(CmCustCaseLinkId caseLinkId) {
		this.caseLinkId = caseLinkId;
	}

	public String getReceivedStatus() {
		return receivedStatus;
	}

	public void setReceivedStatus(String receivedStatus) {
		this.receivedStatus = receivedStatus;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getDocuDueDate() {
		return docuDueDate;
	}

	public void setDocuDueDate(String docuDueDate) {
		this.docuDueDate = docuDueDate;
	}

	public String getDocuApproval() {
		return docuApproval;
	}

	public void setDocuApproval(String docuApproval) {
		this.docuApproval = docuApproval;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public CmCustCase getCmCustCase() {
		return cmCustCase;
	}

	public void setCmCustCase(CmCustCase cmCustCase) {
		this.cmCustCase = cmCustCase;
	}

	public CmDocument getCmDocument() {
		return cmDocument;
	}

	public void setCmDocument(CmDocument cmDocument) {
		this.cmDocument = cmDocument;
	}

}
