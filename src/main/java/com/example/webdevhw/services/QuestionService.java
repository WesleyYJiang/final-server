package com.example.webdevhw.services;

import com.example.webdevhw.models.EssayQuestion;
import com.example.webdevhw.models.Exam;
import com.example.webdevhw.models.FillInTheBlankQuestion;
import com.example.webdevhw.models.MultipleChoiceQuestion;
import com.example.webdevhw.models.Question;
import com.example.webdevhw.models.TrueFalseQuestion;
import com.example.webdevhw.repositories.EssayQuestionRepository;
import com.example.webdevhw.repositories.ExamRepository;
import com.example.webdevhw.repositories.FillInTheBlankQuestionRepository;
import com.example.webdevhw.repositories.MultipleChoiceQuestionRepository;
import com.example.webdevhw.repositories.QuestionRepository;
import com.example.webdevhw.repositories.TrueFalseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class QuestionService {
  @Autowired
  QuestionRepository baseRepo;
  @Autowired
  FillInTheBlankQuestionRepository fillRepo;
  @Autowired
  TrueFalseRepository trueRepo;
  @Autowired
  EssayQuestionRepository essayRepo;
  @Autowired
  MultipleChoiceQuestionRepository mcRepo;
  @Autowired
  ExamRepository examRepository;

  @PostMapping("/api/exam/{examid}/question")
  public Question createBaseQuestion(
    @PathVariable("examid") int examid,
    @RequestBody Question newQuestion) {
      Optional<Exam> data = examRepository.findById(examid);

      if(data.isPresent()) {
        Exam exam = data.get();
        newQuestion.setExam(exam);
        return baseRepo.save(newQuestion);
      }
      return null;
  }

  @PostMapping("/api/exam/{examid}/fill")
  public Question createFillInTheBlankQuestion(
          @PathVariable("examid") int examid,
          @RequestBody FillInTheBlankQuestion newQuestion) {
    Optional<Exam> data = examRepository.findById(examid);

    if(data.isPresent()) {
      Exam exam = data.get();
      newQuestion.setExam(exam);
      return fillRepo.save(newQuestion);
    }
    return null;
  }

  @PostMapping("/api/exam/{examid}/multi")
  public Question createMultipleChoiceQuestion(
          @PathVariable("examid") int examid,
          @RequestBody MultipleChoiceQuestion newQuestion) {
    Optional<Exam> data = examRepository.findById(examid);

    if(data.isPresent()) {
      Exam exam = data.get();
      newQuestion.setExam(exam);
      return mcRepo.save(newQuestion);
    }
    return null;
  }

  @PostMapping("/api/exam/{examid}/tf")
  public Question createTrueFalseQuestion(
          @PathVariable("examid") int examid,
          @RequestBody TrueFalseQuestion newQuestion) {
    Optional<Exam> data = examRepository.findById(examid);

    if(data.isPresent()) {
      Exam exam = data.get();
      newQuestion.setExam(exam);
      return trueRepo.save(newQuestion);
    }
    return null;
  }

  @PostMapping("/api/exam/{examid}/tf")
  public Question createEssayQuestion(
          @PathVariable("examid") int examid,
          @RequestBody EssayQuestion newQuestion) {
    Optional<Exam> data = examRepository.findById(examid);

    if(data.isPresent()) {
      Exam exam = data.get();
      newQuestion.setExam(exam);
      return essayRepo.save(newQuestion);
    }
    return null;
  }


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
}