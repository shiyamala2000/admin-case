package com.kgisl.cmtool.entity;

import java.security.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "CM_COMPANY")
public class CmCompany {
	
	@Id
    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "DELETE_IND")
    private String deleteInd;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

//    @Column(name = "LAST_MODIFIED_BY")
//    private String lastModifiedBy;

//    @Column(name = "LAST_MODIFIED_DATE")
//    private Timestamp lastModifiedDate;
    
}
