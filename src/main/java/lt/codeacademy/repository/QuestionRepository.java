package lt.codeacademy.repository;

import lt.codeacademy.entity.Question;

public class QuestionRepository extends AbstractRepository {
    public void createQuestion(Question question) {
        modifyEntity(session -> session.persist(question));

    }
}
