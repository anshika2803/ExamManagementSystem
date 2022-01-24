package com.knackriser.ExamManagementSystem.Topic;

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
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicRepository tr;
	
	// get all 
	@GetMapping("/topic")
	public List<Topic> getAllCourses(){
		return tr.findAll();
	}		
	
	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic topic) {
		return tr.save(topic);
	}
	
	// get  by id rest API
	@GetMapping("/topic/{topicId}")
	public ResponseEntity<Topic> getTopicById(@PathVariable Long topicId) {
		Topic topic = tr.findById(topicId)
				.orElseThrow(()-> new ResourceNotFoundException("Topic not exist with id :" + topicId));
		return ResponseEntity.ok(topic);
	}
	
	// update  rest API
	
	@PutMapping("/topic/{topicId}")
	public ResponseEntity<Topic> updateTopic(@PathVariable Long topicId, @RequestBody Topic topicDetails){
		Topic topic = tr.findById(topicId)
				.orElseThrow(() -> new ResourceNotFoundException("Topic not exist with id :" + topicId));

		
		topic.setTopicName(topicDetails.getTopicName());
    	topic.setSubjectName(topicDetails.getSubjectName());
    	
		
    	Topic updatedTopic = tr.save(topic);
    	return ResponseEntity.ok(updatedTopic);
	}
	
	// delete  rest API
	@DeleteMapping("/topic/{topicId}")
	public ResponseEntity<Map<String, Boolean>> deleteTopic(@PathVariable Long topicId){
		Topic topic = tr.findById(topicId)
				.orElseThrow(() -> new ResourceNotFoundException("Topic not exist with id :" + topicId));
		
		tr.delete(topic);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}