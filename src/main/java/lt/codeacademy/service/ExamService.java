package lt.codeacademy.service;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.repository.ExamRepository;


public class ExamService {
        private final ExamRepository repository;

        public ExamService() {
            repository = new ExamRepository();
        }

        public void createExam(Exam exam){
            repository.createExam(exam);
        }
    }

