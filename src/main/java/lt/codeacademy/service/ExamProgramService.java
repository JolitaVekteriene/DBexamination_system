package lt.codeacademy.service;

import lt.codeacademy.entity.ExamProgram;
import lt.codeacademy.repository.ExamProgramRepository;

import java.util.List;

public class ExamProgramService {
    private final ExamProgramRepository repository;

    private final ExamProgramRepository repository() {
        return null;
    }

    public ExamProgramService() {
        repository = new ExamProgramRepository();
    }

    public void createExamProgram (ExamProgram examProgram) {
        repository.createExamProgram(examProgram);
    }

    public List<ExamProgram> getExamProgram() {
        return repository.getExamPrograms();

    }

    public void updateExamProgram(ExamProgram examProgram) {
        repository.updateExamProgram(examProgram);
    }

}

