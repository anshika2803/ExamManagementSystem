package com.knackriser.ExamManagementSystem.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private DocumentRepository dr;
	
	// get all 
	@GetMapping("/document")
	public List<Document> getAllDocuments(){
		return dr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/document")
	public Document createDocument(@RequestBody Document document) {
		return dr.save(document);
	}
	
	// get  by id rest API
	@GetMapping("/document/{documentId}")
	public ResponseEntity<Document> getDocumentById(@PathVariable Long documentId) {
		Document document = dr.findById(documentId)
				.orElseThrow(() -> new ResourceNotFoundException("Document not exist with id :" + documentId));
		return ResponseEntity.ok(document);
	}
	
	// update  rest API
	
	@PutMapping("/document/{documentId}")
	public ResponseEntity<Document> updateDocument(@PathVariable Long documentId, @RequestBody Document documentDetails){
		Document document = dr.findById(documentId)
				.orElseThrow(() -> new ResourceNotFoundException("Document not exist with id :" + documentId));
		
		document.setFileName(documentDetails.getFileName());
    	document.setFileType(documentDetails.getFileType());
    	document.setDocumentType(documentDetails.getDocumentType());
    	document.setCourseName(documentDetails.getCourseName());
    	document.setCenter(documentDetails.getCenter());


    	
		
    	Document updatedDocument = dr.save(document);
    	return ResponseEntity.ok(updatedDocument);
	}
	
	// delete  rest API
	@DeleteMapping("/document/{documentId}")
	public ResponseEntity<Map<String, Boolean>> deleteDocument(@PathVariable Long documentId){
		Document document = dr.findById(documentId)
				.orElseThrow(() -> new ResourceNotFoundException("Document not exist with id :" + documentId));
		
		dr.delete(document);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}