package com.project.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.quiz.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions,Integer>{
	@Query(value="SELECT * FROM Questions LIMIT :noOfQuestion", nativeQuery=true)
	List<Questions> findQuestionByNumber(int noOfQuestion);

}
