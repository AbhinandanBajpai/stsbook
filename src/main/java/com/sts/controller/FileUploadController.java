package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sts.helper.FileHelperUpload;

@RestController
public class FileUploadController {
	
	@Autowired
	FileHelperUpload filehelperupload;
	
	@PostMapping("upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ){
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		try {
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("MUST_CONTAIN_A_FILE");
		}
		
		if(file.getContentType().equals("image/jpg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("MUST_BE_JPEG");
		}
//		
        boolean uploadFile = filehelperupload.uploadFile(file);
		
		if(uploadFile) {
			return ResponseEntity.ok("file Is Uploaded");
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
		
	}

}
