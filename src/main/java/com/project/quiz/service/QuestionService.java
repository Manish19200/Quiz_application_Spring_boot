package com.project.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quiz.entity.Questions;
import com.project.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository repo;
	//GET ALL QUESTION
	public ResponseEntity<List<Questions>> getAllQuestion() {
		try{
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	//SAVE
	public ResponseEntity<String> addNewQuestion(Questions question) {
		try{repo.save(question);
		return new ResponseEntity<>("Your Question is added to the database",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Something is wrong",HttpStatus.BAD_REQUEST);
	}
	// DELETE
	public ResponseEntity<String> deleteQuestion(int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>("SQuestion is deleted from the database",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Something is wrong",HttpStatus.BAD_REQUEST);
	}

	

}
