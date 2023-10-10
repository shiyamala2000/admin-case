package com.kgisl.cmtool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CMScreedGridModel {
	
	private String role;
	private String proposerName;
	private String DocumentName;
	private String docDueDate;
	private String receivedStatus;
	private String receivedDate;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getProposerName() {
		return proposerName;
	}
	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}
	public String getDocumentName() {
		return DocumentName;
	}
	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}
	public String getDocDueDate() {
		return docDueDate;
	}
	public void setDocDueDate(String docDueDate) {
		this.docDueDate = docDueDate;
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

}
