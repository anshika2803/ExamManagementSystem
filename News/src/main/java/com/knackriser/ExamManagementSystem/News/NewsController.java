package com.knackriser.ExamManagementSystem.News;

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
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsRepository nr;
	
	// get all 
	@GetMapping("/news")
	public List<News> getAllCourses(){
		return nr.findAll();
	}		
	
	// create  rest API
	@PostMapping("/news")
	public News createNews(@RequestBody News news) {
		return nr.save(news);
	}
	
	// get  by id rest API
	@GetMapping("/news/{newsId}")
	public ResponseEntity<News> getNewsById(@PathVariable Long newsId) {
		News news = nr.findById(newsId)
				.orElseThrow(() -> new ResourceNotFoundException("news not exist with id :" + newsId));
		return ResponseEntity.ok(news);
	}
	
	// update  rest API
	
	@PutMapping("/news/{newsId}")
	public ResponseEntity<News> updateNews(@PathVariable Long newsId, @RequestBody News newsDetails){
		News news = nr.findById(newsId)
				.orElseThrow(() -> new ResourceNotFoundException("News not exist with id :" + newsId));
		
		news.setFileName(newsDetails.getFileName());
		news.setExam(newsDetails.getExam());
		news.setNewsType(newsDetails.getNewsType());

		
    	News updatedNews = nr.save(news);
    	return ResponseEntity.ok(updatedNews);
	}
	
	// delete  rest API
	@DeleteMapping("/news/{newsId}")
	public ResponseEntity<Map<String, Boolean>> deleteNews(@PathVariable Long newsId){
		News news = nr.findById(newsId)
				.orElseThrow(() -> new ResourceNotFoundException("News not exist with id :" + newsId));
		
		nr.delete(news);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}