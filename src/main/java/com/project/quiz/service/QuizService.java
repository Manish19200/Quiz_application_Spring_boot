package com.project.quiz.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quiz.entity.Questions;
import com.project.quiz.entity.Quiz;
import com.project.quiz.entity.QuizQuestion;
import com.project.quiz.entity.Response;
import com.project.quiz.repository.QuestionRepository;
import com.project.quiz.repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
	QuizRepository quizrepo;
	@Autowired
	QuestionRepository questionrepo;
	
	public ResponseEntity<String> createdQuiz(int noOfQuestion, String title) {
		Quiz quiz= new Quiz();
		quiz.setTitle(title);
		
		List<Questions> questions = questionrepo.findQuestionByNumber(noOfQuestion);
		quiz.setQuestion(questions);
		quizrepo.save(quiz);
		return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuizQuestion>> getQuiz(int id) {
		List<Questions> dbQuestion = quizrepo.findById(id).get().getQuestion();
		List<QuizQuestion> userQuestion = new ArrayList<>();
		for(Questions q: dbQuestion) {
			QuizQuestion uq = new QuizQuestion(q.getId(),q.getQuestion(),q.getChoice1(),q.getChoice2(),q.getChoice3(),q.getChoice4());
			userQuestion.add(uq);
		}
		return new ResponseEntity<>(userQuestion,HttpStatus.OK);
	}

	public ResponseEntity<Integer> submit(int id, List<Response> res) {
		Quiz quiz = quizrepo.findById(id).get();
		List<Questions> question = quiz.getQuestion();
		int score= 0;
		int i= 0;
		for(Response response:res) {
			if(response.getRes().equals(question.get(i).getAnswer()));
				score++;
			i++;
		}
	
		return new ResponseEntity<>(score,HttpStatus.OK);
	}

	
	

}
