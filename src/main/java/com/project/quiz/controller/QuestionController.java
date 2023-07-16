package com.project.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quiz.entity.Questions;
import com.project.quiz.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@GetMapping("/questions")
	public ResponseEntity<List<Questions>> getAllQuestion(){
		return service.getAllQuestion();
	}
	
	@PostMapping("/newQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
		return service.addNewQuestion(question);
	}
	
	@DeleteMapping("/deletequestion/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id){
		return service.deleteQuestion(id);}
	

}
