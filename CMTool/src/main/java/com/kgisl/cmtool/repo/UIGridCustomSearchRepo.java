package com.kgisl.cmtool.repo;

import java.util.List;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UIGridCustomSearchRepo {

	@PersistenceContext
	EntityManager entityManager;

	public List<Object[]> getDocumentListByFilter(String docId, String processId, String subProcessId) {

		boolean filterAdded = false;

		String jpqlQuery = "SELECT cd.cmCaseDocId.docuId AS DOCU_ID, " + "d.docuName AS DOCU_NAME, "
				+ "sp.subProcessName AS SUB_PROCESS_NAME, " + "sp.cmProcess.processName AS PROCESS_NAME, "
				+ "cd.deleteInd AS DELETE_IND " + "FROM CmCaseDoc cd "
				+ "JOIN CmDocument d on d.docId = cd.cmCaseDocId.docuId "
				+ "JOIN CmSubProcess sp on sp.subProcessId = cd.cmCaseDocId.subProcessId " + "WHERE ";

		if (null != docId && !docId.isEmpty() && !docId.equalsIgnoreCase("")) {
			jpqlQuery += "cd.cmCaseDocId.docuId = :docId";
			filterAdded = true;
		}

		if (null != subProcessId && !subProcessId.isEmpty() && !subProcessId.equalsIgnoreCase("")) {
			if (filterAdded) {
				jpqlQuery += " AND ";
			}
			jpqlQuery += "cd.cmCaseDocId.subProcessId = :subProcessId";
			filterAdded = true;
		}

		if (null != processId && !processId.isEmpty() && !processId.equalsIgnoreCase("")) {
			if (filterAdded) {
				jpqlQuery += " AND ";
			}
			jpqlQuery += "sp.cmProcess.processId = :processId";
		}

		System.out.println(jpqlQuery);

		Query query = entityManager.createQuery(jpqlQuery);

		if (null != processId && !processId.isEmpty() && !processId.equalsIgnoreCase(""))
			query.setParameter("processId", processId);

		if (null != docId && !docId.isEmpty() && !docId.equalsIgnoreCase(""))
			query.setParameter("docId", docId);

		if (null != subProcessId && !subProcessId.isEmpty() && !subProcessId.equalsIgnoreCase(""))
			query.setParameter("subProcessId", subProcessId);
	
		return query.getResultList();

	}

}
