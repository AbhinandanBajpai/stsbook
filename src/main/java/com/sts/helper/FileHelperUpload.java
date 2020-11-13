package com.sts.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelperUpload {
	
	public final String UPLOAD_DIR="C:\\Users\\abhib\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\firststsproject\\src\\main\\resources\\static\\image";

	 	public boolean uploadFile(MultipartFile mfile) {
	 		
	 		boolean ff=false;
	 		
	 	 try {
	 		 //read
			
//	 	    InputStream inputStream = mfile.getInputStream();
//	 	    
//	 	    byte[] data= new byte[inputStream.available()];
//	 	    
//	 	    inputStream.read(data);
//	 	    
//	 	    //write
//	 	    
//	 	    FileOutputStream fo = new FileOutputStream(UPLOAD_DIR+"\\"+mfile.getOriginalFilename());
//	 	    fo.write(data);
//	 	    fo.close();
	 		 
	 		 Files.copy(mfile.getInputStream(),Paths.get(UPLOAD_DIR+"\\"+mfile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
	 	    
	 	    ff=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 	 return ff;
	 	}
}
