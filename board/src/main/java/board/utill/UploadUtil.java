package board.utill;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	public Map<String, String> map = new HashMap<>(); //ㅇㅎㅇㅎㅇㅎㅇㅎ
	
	public Map<String, String> requestParse(HttpServletRequest request){
		
		// enctype = multipart/form-data 확인
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); 

		if(isMultipart){  
			// 전송된 파일을 디스크에 저장하기 위한 객체 
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			// 업로드 가능 사이즈 지정
			upload.setSizeMax(2000*1024); // 2MB 제한
			
			// 사용자의 request를 분석 
			List<FileItem> fileItems = null;
			
			
				try {
					fileItems = upload.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
		
			String fieldName = null, fileName = null, value = null;
			
			Iterator<FileItem> iter = fileItems.iterator();
			
			while(iter.hasNext()){
				
				FileItem item = iter.next();
				
				// text,password, checkbox ... 			
				if(item.isFormField()){
					// 요소명
					fieldName = item.getFieldName();
					
					// 요소안에 들어있는 value 값 
					try {
						value = item.getString("utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					map.put(fieldName, value);
					
				}else{ // type= file 로 넘어오는 작업
					
					//요소명
					fieldName =item.getFieldName();
					
					//파일명
					fileName = item.getName();
					
					File file = null;
					
					if(!fileName.isEmpty() && item.getSize() > 0){
						//파일 저장
						String path = "c:\\upload\\";
						// 중복되지 않은 고유한 키 값 생성
						UUID uuid = UUID.randomUUID(); // D:\\upload\\고유값_업로드파일명

						file = new File(path+uuid.toString()+"_"+fileName);
						
						try {
							item.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
						map.put(fieldName, file.getName());
					}
		
				}
		
			}
		
		}
		
		return map;
	}
}
