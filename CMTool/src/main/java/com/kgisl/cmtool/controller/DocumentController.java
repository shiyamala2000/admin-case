package com.kgisl.cmtool.controller;

import java.io.IOException;
import java.net.SocketTimeoutException;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kgisl.cmtool.service.UploadDocToDMSService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

	private final UploadDocToDMSService uploadDocToDMSService;

	public DocumentController(UploadDocToDMSService uploadDocToDMSService) {
		this.uploadDocToDMSService = uploadDocToDMSService;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("companyId") String companyId, @RequestParam("companyName") String companyName,
			@RequestParam("actualFilename") String actualFilename, @RequestParam("dms") String dms) {
		try {

//            byte[] documentData = file.getBytes();
			String originalFilename = file.getOriginalFilename();
			ResponseEntity<String> result = uploadDocToDMSService.processDocument(file, originalFilename, companyId,
					companyName, actualFilename);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body("Error uploading document.");
		}
	}
	
}
