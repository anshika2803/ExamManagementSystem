package com.knackriser.ExamManagementSystem.Question;

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
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionRepository qr;
	
	// get all 
	@GetMapping("/question")
	public List<Question> getAllQuestions(){
		return qr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/question")
	public Question createQuestion(@RequestBody Question question) {
		return qr.save(question);
	}
	
	// get  by id rest API
	@GetMapping("/question/{questionId}")
	public ResponseEntity<Question> getQuestionById(@PathVariable Long questionId) {
		Question question = qr.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not exist with id :" + questionId));
		return ResponseEntity.ok(question);
	}
	
	// update  rest API
	
	@PutMapping("/question/{questionId}")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long questionId, @RequestBody Question questionDetails){
		Question question = qr.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not exist with id :" + questionId));
		
		question.setQuestion(questionDetails.getQuestion());
		question.setOption1(questionDetails.getOption1());
		question.setOption2(questionDetails.getOption2());
		question.setOption3(questionDetails.getOption3());
		question.setOption4(questionDetails.getOption4());
		question.setSubjectName(questionDetails.getSubjectName());
		question.setQuestionType(questionDetails.getQuestionType());


    	
		
		Question updatedQuestion= qr.save(question);
    	return ResponseEntity.ok(updatedQuestion);
	}
	
	// delete  rest API
	@DeleteMapping("/question/{questionId}")
	public ResponseEntity<Map<String, Boolean>> deleteQuestion(@PathVariable Long questionId){
		Question question = qr.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not exist with id :" + questionId));
		
		qr.delete(question);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}