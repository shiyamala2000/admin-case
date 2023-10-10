package com.kgisl.cmtool.service;

import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UploadDocToDMSService {

	@Value("${doors.username}")
	private String username;

	@Value("${doors.password}")
	private String password;

	private final RestTemplate restTemplate;

	public UploadDocToDMSService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<String> processDocument(MultipartFile file, String originalFilename, String companyId, String companyName,
			String actualFilename) {

		String apiUrl = "https://demo.kgisl.com/Doors/api/docprocessing/doc" + "?originalFilename=" + originalFilename
				+ "&companyId=" + companyId + "&companyName=" + companyName + "&actualFilename=" + actualFilename;

		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String response;
		String plainCreds = username + ':' + password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes, false);
		String base64Creds = new String(base64CredsBytes);

		HttpStatus httpStatus = HttpStatus.ACCEPTED;

		try {

			map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
			response = restTemplate.postForObject(apiUrl, requestEntity, String.class);

		} catch (HttpStatusCodeException e) {
			httpStatus = HttpStatus.valueOf(e.getStatusCode().value());
			response = e.getResponseBodyAsString();
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = e.getMessage();
		}

		return new ResponseEntity<>(response, httpStatus);
	}
	
	class MultipartInputStreamFileResource extends InputStreamResource {

		private final String filename;

		MultipartInputStreamFileResource(InputStream inputStream, String filename) {
			super(inputStream);
			this.filename = filename;
		}

		@Override
		public String getFilename() {
			return this.filename;
		}

		@Override
		public long contentLength() throws IOException {
			return -1; 
		}
	}
}
