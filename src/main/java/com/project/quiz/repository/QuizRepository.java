package com.project.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
