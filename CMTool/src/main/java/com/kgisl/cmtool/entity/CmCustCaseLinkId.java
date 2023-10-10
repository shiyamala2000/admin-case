package com.kgisl.cmtool.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CmCustCaseLinkId implements Serializable{
	
	@Column(name="CASE_RELATION_ID")
	private String caseRelationId;
	
	@Column(name="DOCU_ID")
	private int docuId;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmCustCaseLinkId that = (CmCustCaseLinkId) o;
        return Objects.equals(caseRelationId, that.caseRelationId) &&
               Objects.equals(docuId, that.docuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseRelationId, docuId);
    }

	public String getCaseRelationId() {
		return caseRelationId;
	}

	public void setCaseRelationId(String caseRelationId) {
		this.caseRelationId = caseRelationId;
	}

	public int getDocuId() {
		return docuId;
	}

	public void setDocuId(int docuId) {
		this.docuId = docuId;
	}

}
