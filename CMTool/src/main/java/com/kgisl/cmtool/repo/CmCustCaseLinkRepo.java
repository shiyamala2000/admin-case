package com.kgisl.cmtool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.cmtool.entity.CmCustCaseLink;
import com.kgisl.cmtool.entity.CmCustCaseLinkId;

@Repository
public interface CmCustCaseLinkRepo extends JpaRepository<CmCustCaseLink, CmCustCaseLinkId>{
	
	 List<CmCustCaseLink> findByCmCustCaseCaseRelationId(String caseRelationId);

}
