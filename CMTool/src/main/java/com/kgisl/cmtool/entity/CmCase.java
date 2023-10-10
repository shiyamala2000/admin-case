package com.kgisl.cmtool.entity;

import java.io.Serializable;
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
@Table(name = "CM_CASE")
public class CmCase{
	
	@Id
    @Column(name = "CASE_ID")
    private String caseId;

    @Column(name = "CASE_NAME")
    private String caseName;

    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name = "DELETE_IND")
    private String deleteInd;

//    @Column(name = "LAST_MODIFIED_BY")
//    private String lastModifiedBy;
//
//    @Column(name = "LAST_MODIFIED_DATE")
//    private Timestamp lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", insertable = false, updatable = false)
    private CmCompany cmCompany;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public CmCompany getCmCompany() {
		return cmCompany;
	}

	public void setCmCompany(CmCompany cmCompany) {
		this.cmCompany = cmCompany;
	}
    
}
