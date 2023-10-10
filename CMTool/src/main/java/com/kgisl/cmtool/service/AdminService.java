package com.kgisl.cmtool.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kgisl.cmtool.entity.CmCaseDoc;
import com.kgisl.cmtool.entity.CmCaseDocId;
import com.kgisl.cmtool.entity.CmCustCase;
import com.kgisl.cmtool.entity.CmCustCaseLink;
import com.kgisl.cmtool.entity.CmDocument;
import com.kgisl.cmtool.entity.CmProcess;
import com.kgisl.cmtool.entity.CmSubProcess;
import com.kgisl.cmtool.model.AdminScreenGridModel;
import com.kgisl.cmtool.model.CMScreedGridModel;
import com.kgisl.cmtool.repo.CmCaseDocRepo;
import com.kgisl.cmtool.repo.CmCustCaseLinkRepo;
import com.kgisl.cmtool.repo.CmCustCaseRepo;
import com.kgisl.cmtool.repo.CmDocumentRepo;
import com.kgisl.cmtool.repo.CmProcessRepo;
import com.kgisl.cmtool.repo.CmSubProcessRepo;
import com.kgisl.cmtool.repo.UIGridCustomSearchRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AdminService {

	@Autowired
	CmSubProcessRepo subProcessRepo;

	@Autowired
	CmCaseDocRepo cmCaseDocRepo;

	@Autowired
	CmDocumentRepo cmDocumentRepo;

	@Autowired
	UIGridCustomSearchRepo uiGridCustomSearchRepo;

	@Autowired
	CmCustCaseLinkRepo caseLinkRepo;

	@Autowired
	CmProcessRepo cmProcessRepo;

	@Autowired
	CmCustCaseRepo custCaseRepo;
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("deprecation")
	public List<AdminScreenGridModel> fetchAllDocumentList() {

//		List<CmSubProcess> object = subProcessRepo.findAll();

		List<AdminScreenGridModel> uiModel = new ArrayList<>();

		List<CmCaseDoc> cases = cmCaseDocRepo.findAll();

		for (CmCaseDoc caseDoc : cases) {

			AdminScreenGridModel model = new AdminScreenGridModel();

			model.setDocumentId(String.valueOf(caseDoc.getCmCaseDocId().getDocuId()));

			if (caseDoc.getDeleteInd().equalsIgnoreCase("F"))
				model.setStatus("Active");
			else
				model.setStatus("Inactive");

			model.setDocumentName(cmDocumentRepo.getById(caseDoc.getCmCaseDocId().getDocuId()).getDocuName());

			model.setSubProcessType(caseDoc.getCmSubProcess().getSubProcessName());

			model.setProcessType(caseDoc.getCmSubProcess().getCmProcess().getProcessName());

			uiModel.add(model);
		}

		return uiModel;
	}

	public List<AdminScreenGridModel> serachBasedOnFilter(String docId, String processId, String subProcessId) {

		List<Object[]> results = uiGridCustomSearchRepo.getDocumentListByFilter(docId, processId, subProcessId);

		List<AdminScreenGridModel> screenGridModels = new ArrayList<>();

		for (Object[] result : results) {

			AdminScreenGridModel model = new AdminScreenGridModel();

			model.setDocumentId((String) result[0]);
			model.setDocumentName((String) result[1]);
			model.setProcessType((String) result[3]);
			model.setSubProcessType((String) result[2]);
			model.setStatus((String) result[4]);

			screenGridModels.add(model);

		}

		return screenGridModels;
	}

	public List<CMScreedGridModel> searchCaseDocuments(String caseId) {

		List<CmCustCaseLink> custCases = caseLinkRepo.findByCmCustCaseCaseRelationId(caseId);

		List<CMScreedGridModel> cmList = new ArrayList<>();

		for (CmCustCaseLink custCase : custCases) {

			CMScreedGridModel model = new CMScreedGridModel();

			model.setRole("Admin");
			model.setProposerName("Proposer");
			model.setDocumentName(custCase.getCmDocument().getDocuName());
			model.setReceivedStatus(custCase.getReceivedStatus());
			model.setDocDueDate(custCase.getDocuDueDate());
			model.setReceivedDate(custCase.getReceivedDate());

			cmList.add(model);

		}

		return cmList;
	}

	public Map<String, List<Map<String, List<String>>>> getSearchTabDropDownMenu() {

		Map<String, List<Map<String, List<String>>>> mapForDropDownMenu = new HashMap<>();

		List<CmProcess> processList = cmProcessRepo.findAll();

		for (CmProcess process : processList) {

			List<CmSubProcess> spForGivenProcess = subProcessRepo.findByCmProcessProcessId(process.getProcessId());

			List<Map<String, List<String>>> processVSspMap = new ArrayList<>();

			for (CmSubProcess subProcess : spForGivenProcess) {

				Map<String, List<String>> subProcessVSDocsMap = new HashMap<>();

				List<CmCaseDoc> docListForGivenSubProcess = cmCaseDocRepo
						.findByCmSubProcessSubProcessId(subProcess.getSubProcessId());

				List<String> docList = new ArrayList<>();

				for (CmCaseDoc doc : docListForGivenSubProcess) {
					docList.add(doc.getCmDocument().getDocuName() + "(" + doc.getCmDocument().getDocId() + ")");
				}

				subProcessVSDocsMap.put(subProcess.getSubProcessName() + "(" + subProcess.getSubProcessId() + ")",
						docList);
				processVSspMap.add(subProcessVSDocsMap);
			}

			mapForDropDownMenu.put(process.getProcessName() + "(" + process.getProcessId() + ")", processVSspMap);
		}

		return mapForDropDownMenu;
	}

	public ResponseEntity<String> addNewDocument(String processId, List<String> subProcessIdList,
			String nameOfNewDocument) {

		String responseMessage = "";

		List<CmDocument> docIDs = cmDocumentRepo.findByDocuName(nameOfNewDocument);

		if (docIDs.isEmpty()) {

			CmDocument cmDocument = new CmDocument();
			cmDocument.setDocuName(nameOfNewDocument);
			int newDocId = CmDocument.generateNextDocId(entityManager); 
			cmDocument.setDocId(newDocId);
			cmDocumentRepo.save(cmDocument);
			
			for (String subProcessId : subProcessIdList) {
				insertIntoCmCaseDoc(subProcessId, newDocId, nameOfNewDocument);
			}

		}

		else {

			for (CmDocument docId : docIDs) {

				for (String subProcessId : subProcessIdList) {

					List<CmCaseDoc> recordsAlreadyPresent = cmCaseDocRepo
							.findByCmCaseDocIdSubProcessIdAndCmCaseDocIdDocuId(subProcessId, docId.getDocId());

					if (recordsAlreadyPresent.size() >= 1) {

						responseMessage = "A Record Already Exists for the Document Name: " + nameOfNewDocument
								+ " under the selected Sub-Process: "
								+ subProcessRepo.findById(subProcessId).get().getSubProcessName()+"\n";

					}

					else {

						responseMessage = responseMessage + insertIntoCmCaseDoc(subProcessId, docId.getDocId(), nameOfNewDocument) + "\n";

					}

				}

			}
		}

		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(responseMessage);
	}

	private String insertIntoCmCaseDoc(String subProcessId, int newDocId, String nameOfNewDocument) {
		
		CmCaseDoc cmCaseDoc = new CmCaseDoc();
		
//		CmCaseDocId cmCaseDocId = new CmCaseDocId(subProcessId, newDocId);
		CmCaseDocId cmCaseDocId = new CmCaseDocId();

		cmCaseDoc.setCmCaseDocId(cmCaseDocId);
		
		cmCaseDocRepo.save(cmCaseDoc);
				
		return "Document: "+ nameOfNewDocument + " added for Sub-process: "+ subProcessRepo.findById(subProcessId).get().getSubProcessName();
		
	}

	public HashSet<String> getAllCaseIDs() {

		List<CmCustCase> records = custCaseRepo.findAll();
		HashSet<String> caseIDs = new HashSet<>();
		for(CmCustCase record : records) {
			caseIDs.add(record.getCaseRelationId());
		}
		return caseIDs;
	}

}
