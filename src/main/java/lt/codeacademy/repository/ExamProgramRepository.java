package lt.codeacademy.repository;

import lt.codeacademy.entity.ExamProgram;

import java.util.List;

public class ExamProgramRepository extends AbstractRepository {
    public void createExamProgram(ExamProgram examProgram) {
        modifyEntity(session -> session.persist(examProgram));
    }

    public void updateExamProgram(ExamProgram examProgram) {
        modifyEntity(session -> session.update(examProgram));
    }

    public List<ExamProgram> getExamPrograms() {
        return getValue(session -> session.createQuery("FROM examProgram", ExamProgram.class).list());
    }
}
