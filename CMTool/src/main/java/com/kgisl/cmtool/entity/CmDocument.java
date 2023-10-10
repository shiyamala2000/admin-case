package com.kgisl.cmtool.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "CM_DOCUMENT")
public class CmDocument {

	@Id
	@Column(name = "DOC_ID")
	private int docId;

	@Column(name = "DOCU_NAME")
	private String docuName;

	@Column(name = "DELETE_IND")
	private String deleteInd;

//	    @Column(name = "LAST_MODIFIED_BY")
//	    private String lastModifiedBy;

//	    @Column(name = "LAST_MODIFIED_DATE")
//	    private Timestamp lastModifiedDate;

	public static int generateNextDocId(EntityManager entityManager) {

		String jpqlQuery = "SELECT MAX(d.docId) FROM CmDocument d";

		int maxDocId = entityManager.createQuery(jpqlQuery, Integer.class).getSingleResult();

		return maxDocId + 1;

	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocuName() {
		return docuName;
	}

	public void setDocuName(String docuName) {
		this.docuName = docuName;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

}
