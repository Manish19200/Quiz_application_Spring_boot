package com.project.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.quiz.entity.Questions;
import com.project.quiz.entity.QuizQuestion;
import com.project.quiz.entity.Response;
import com.project.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizser;
	
	@PostMapping("/create")
	public ResponseEntity<String> creteQuiz(@RequestParam int noOfQuestion, @RequestParam String title){
		return quizser.createdQuiz(noOfQuestion,title);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuizQuestion>> getQuiz(@PathVariable int id){
		return quizser.getQuiz(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> res){
		return quizser.submit(id,res);
	}

}
