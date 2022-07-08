package lt.codeacademy.service;

import lt.codeacademy.entity.Question;
import lt.codeacademy.repository.QuestionRepository;


public class QuestionService {
        private final QuestionRepository repository;

        public QuestionService() {
            repository = new QuestionRepository();
        }

        public void createQuestion(Question question){
            repository.createQuestion(question);
        }
    }

