package com.kgisl.cmtool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminScreenSearchModel {
	
	private String docId;
	private String subProcessId;
	private String processId;
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getSubProcessId() {
		return subProcessId;
	}
	public void setSubProcessId(String subProcessId) {
		this.subProcessId = subProcessId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}

}
