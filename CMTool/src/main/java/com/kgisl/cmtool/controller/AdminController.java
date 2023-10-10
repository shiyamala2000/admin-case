package com.kgisl.cmtool.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.cmtool.entity.CmCaseDoc;
import com.kgisl.cmtool.entity.CmSubProcess;
import com.kgisl.cmtool.model.AdminScreenGridModel;
import com.kgisl.cmtool.model.AdminScreenSearchModel;
import com.kgisl.cmtool.model.CMScreedGridModel;
import com.kgisl.cmtool.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/fetchAll")
	public List<AdminScreenGridModel> fetchAllDocumentList(){
		
		return adminService.fetchAllDocumentList();
	}

	@PostMapping("/search")
	public List<AdminScreenGridModel> searchBasedOnFilter(@RequestBody AdminScreenSearchModel model){
		
		return adminService.serachBasedOnFilter(model.getDocId(), model.getProcessId(), model.getSubProcessId());
		
	}
	
	@PostMapping("/searchCaseDocuments")
	public List<CMScreedGridModel> searchCaseDocuments(@RequestParam String caseId){
		
		return adminService.searchCaseDocuments(caseId);
	}
	
	@GetMapping("/searchTabDropDownMenu")
	public Map<String, List<Map<String, List<String>>>> getSearchTabDropDownMenu(){
		
		return adminService.getSearchTabDropDownMenu();
		
	}
	
	@PostMapping("/addNewDocument")
	public ResponseEntity<String> addNewDocument(@RequestParam String processId, @RequestParam List<String> subProcessId, @RequestParam String nameOfNewDocument){
		
		return adminService.addNewDocument(processId, subProcessId, nameOfNewDocument);
		
	}
	
	@GetMapping("/getAllCaseIDs")
	public HashSet<String> getAllCaseIDs(){
		
		return adminService.getAllCaseIDs();
		
	}
}
