package com.example.webdevhw.services;
import com.example.webdevhw.models.EssayQuestion;
import com.example.webdevhw.models.FillInTheBlankQuestion;
import com.example.webdevhw.models.Module;
import com.example.webdevhw.repositories.EssayQuestionRepository;
import com.example.webdevhw.repositories.ExamRepository;
import com.example.webdevhw.models.Exam;
import com.example.webdevhw.models.Lesson;
import com.example.webdevhw.models.MultipleChoiceQuestion;
import com.example.webdevhw.models.Question;
import com.example.webdevhw.models.TrueFalseQuestion;
import com.example.webdevhw.models.Widget;
import com.example.webdevhw.repositories.ExamRepository;
import com.example.webdevhw.repositories.FillInTheBlankQuestionRepository;
import com.example.webdevhw.repositories.LessonRepository;
import com.example.webdevhw.repositories.MultipleChoiceQuestionRepository;
import com.example.webdevhw.repositories.TrueFalseRepository;
import com.example.webdevhw.repositories.WidgetRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ExamService {
  @Autowired
  ExamRepository examRepository;
  @Autowired
  TrueFalseRepository trueFalseRepository;
  @Autowired
  FillInTheBlankQuestionRepository fillInTheBlankQuestionRepository;
  @Autowired
  MultipleChoiceQuestionRepository mutiRepo;
  @Autowired
  EssayQuestionRepository essayRepo;
  @Autowired
  LessonRepository lessonRepo;

  @GetMapping("/api/multi/{questionId}")
  public MultipleChoiceQuestion findMultiQuestionById(@PathVariable("questionId") int questionId) {
    Optional<MultipleChoiceQuestion> optional = mutiRepo.findById(questionId);
    if(optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  @GetMapping("/api/truefalse/{questionId}")
  public TrueFalseQuestion findTrueFalseQuestionById(@PathVariable("questionId") int questionId) {
    Optional<TrueFalseQuestion> optional = trueFalseRepository.findById(questionId);
    if(optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  @GetMapping("/api/fill/{questionId}")
  public FillInTheBlankQuestion findFillInTheBlankQuestionById(@PathVariable("questionId") int questionId) {
    Optional<FillInTheBlankQuestion> optional = fillInTheBlankQuestionRepository.findById(questionId);
    if(optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  @GetMapping("/api/essay/{questionId}")
  public EssayQuestion findEssayQuestionById(@PathVariable("questionId") int questionId) {
    Optional<EssayQuestion> optional = essayRepo.findById(questionId);
    if(optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  @GetMapping("/api/exam/{examId}/question")
  public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
    Optional<Exam> optionalExam = examRepository.findById(examId);
    if(optionalExam.isPresent()) {
      Exam exam = optionalExam.get();
      List<Question> questions = exam.getQuestions();
      int count = questions.size();
      return questions;
    }
    return null;
  }


//  @PostMapping("/api/Lesson/{lessonId}/exam")
//  public Lesson createExam(
//          @PathVariable("lessonId") int lessonId,
//          @RequestBody Exam newExam) {
//    Optional<Lesson> data = lessonRepo.findById(lessonId);
//
//    if(data.isPresent()) {
//      Lesson lesson = data.get();
//      newExam.setLesson(lesson);
//      return examRepository.save(newExam);
//    }
//    return null;
//  }





//  @PostMapping("/api/exam/{examId}/truefalse")
//  public TrueFalseQuestion createTrueFalseQuestion(
//          @PathVariable("examId") int examId,
//          @RequestBody TrueFalseQuestion newQ) {
//    Optional<Exam> data = examRepository.findById(examId);
//
//    if(data.isPresent()) {
//      Exam exam = data.get();
//      List<Question> questions = exam.getQuestions();
//      newLesson.setModule(module);
//      return examRepository.save(newLesson);
//    }
//    return null;
//  }
}
