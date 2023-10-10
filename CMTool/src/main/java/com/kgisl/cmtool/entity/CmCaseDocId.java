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
public class CmCaseDocId implements Serializable{
	
	@Column(name = "SUB_PROCESS_ID")
    private String subProcessId;

    @Column(name = "DOCU_ID")
    private int docuId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmCaseDocId that = (CmCaseDocId) o;
        return Objects.equals(subProcessId, that.subProcessId) &&
               Objects.equals(docuId, that.docuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subProcessId, docuId);
    }

	public String getSubProcessId() {
		return subProcessId;
	}

	public void setSubProcessId(String subProcessId) {
		this.subProcessId = subProcessId;
	}

	public int getDocuId() {
		return docuId;
	}

	public void setDocuId(int docuId) {
		this.docuId = docuId;
	}
    
}
