package lt.codeacademy.repository;

import lt.codeacademy.entity.Exam;

public class ExamRepository extends AbstractRepository {
    public void createExam(Exam exam) {
        modifyEntity(session -> session.persist(exam));

    }
}
