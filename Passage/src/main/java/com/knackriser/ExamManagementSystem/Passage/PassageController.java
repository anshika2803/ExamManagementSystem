package com.knackriser.ExamManagementSystem.Passage;

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
@RequestMapping("/passage")
public class PassageController {

	@Autowired
	private PassageRepository pr;
	
	// get all 
	@GetMapping("/passage")
	public List<Passage> getAllPassages(){
		return pr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/passage")
	public Passage createPassage(@RequestBody Passage passage) {
		return pr.save(passage);
	}
	
	// get  by id rest API
	@GetMapping("/passage/{passageId}")
	public ResponseEntity<Passage> getPassageById(@PathVariable Long passageId) {
		Passage passage = pr.findById(passageId)
				.orElseThrow(() -> new ResourceNotFoundException("Passage not exist with id :" + passageId));
		return ResponseEntity.ok(passage);
	}
	
	// update  rest API
	
	@PutMapping("/passage/{passageId}")
	public ResponseEntity<Passage> updatePassage(@PathVariable Long passageId, @RequestBody Passage passageDetails){
		Passage passage = pr.findById(passageId)
				.orElseThrow(() -> new ResourceNotFoundException("Passage not exist with id :" + passageId));
		
		passage.setPassageName(passageDetails.getPassageName());
		passage.setLanguage(passageDetails.getLanguage());
    	
		
		Passage updatedPassage = pr.save(passage);
    	return ResponseEntity.ok(updatedPassage);
	}
	
	// delete  rest API
	@DeleteMapping("/passage/{passageId}")
	public ResponseEntity<Map<String, Boolean>> deletePassage(@PathVariable Long passageId){
		Passage passage = pr.findById(passageId)
				.orElseThrow(() -> new ResourceNotFoundException("Passage not exist with id :" + passageId));
		
		pr.delete(passage);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}