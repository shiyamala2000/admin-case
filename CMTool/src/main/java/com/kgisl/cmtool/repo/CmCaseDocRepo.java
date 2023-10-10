package com.kgisl.cmtool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.cmtool.entity.CmCaseDoc;
import com.kgisl.cmtool.entity.CmCaseDocId;

@Repository
public interface CmCaseDocRepo extends JpaRepository<CmCaseDoc, CmCaseDocId> {
	
	 List<CmCaseDoc> findByCmSubProcessSubProcessId(String subProcessId);
	 
	 List<CmCaseDoc> findByCmDocumentDocId(int docuId);
	 
	 List<CmCaseDoc> findByCmCaseDocIdSubProcessIdAndCmCaseDocIdDocuId(String subProcessId, int docuId);

}
