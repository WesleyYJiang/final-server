//package com.example.webdevhw.services;
//
//import com.example.webdevhw.models.EssayQuestion;
//import com.example.webdevhw.models.FillInTheBlankQuestion;
//import com.example.webdevhw.models.Question;
//import com.example.webdevhw.models.TrueFalseQuestion;
//import com.example.webdevhw.repositories.EssayQuestionRepository;
//import com.example.webdevhw.repositories.FillInTheBlankQuestionRepository;
//import com.example.webdevhw.repositories.MultipleChoiceQuestionRepository;
//import com.example.webdevhw.repositories.QuestionRepository;
//import com.example.webdevhw.repositories.TrueFalseRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class QuestionService {
//  @Autowired
//  QuestionRepository baseRepo;
//  @Autowired
//  FillInTheBlankQuestionRepository fillRepo;
//  @Autowired
//  TrueFalseRepository trueRepo;
//  @Autowired
//  EssayQuestionRepository essayRepo;
//  @Autowired
//  MultipleChoiceQuestionRepository mcRepo;
//
//  @PostMapping("/api/exam/joined/base")
//  public Question createBaseQuestion() {
//    Question q = new BaseQuestionJoined();
//    q.setExam("descriptions 123");
//    q.setInstructions("instructions 123");
//    q.setPoints(123);
//    q.setTitle("title 123");
//    return baseRepo.save(q);
//  }
//  @GetMapping("/api/inheritance/joined/fill")
//  public FillInTheBlankQuestion createFillQuestion() {
//    FillInTheBlankQuestion q = new FillInTheBlankQuestion();
//    q.setDescription("descriptions 234");
//    q.setInstructions("instructions 234");
//    q.setPoints(234);
//    q.setTitle("title 234");
//    q.setVariables("variables 234");
//    return fillRepo.save(q);
//  }
//  @GetMapping("/api/inheritance/joined/true")
//  public TrueFalseQuestion createTrueQuestion() {
//    TrueFalseQuestion q = new TrueFalseQuestion();
//    q.setDescription("descriptions 345");
//    q.setInstructions("instructions 345");
//    q.setPoints(345);
//    q.setTitle("title 345");
//    q.setIsTrue(true);
//    return trueRepo.save(q);
//  }
//}