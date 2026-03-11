package com.question.controllers;


import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/hi")
    public String getdemo(){
        return "Hello";
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        System.out.println("question = " + question.getQuestion());
        System.out.println("quizId = " + question.getQuizId());
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question getOne(@PathVariable Long id){
        return questionService.getOne(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);

    }
}
