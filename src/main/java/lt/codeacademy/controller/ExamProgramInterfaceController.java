package lt.codeacademy.controller;

import lt.codeacademy.entity.Question;
import lt.codeacademy.entity.ExamProgram;
import lt.codeacademy.service.QuestionService;
import lt.codeacademy.service.ExamProgramService;

import java.util.List;
import java.util.Scanner;

public class ExamProgramInterfaceController {
    private final Scanner scanner;              //3.
    private final ExamProgramService examProgramService;
    private final QuestionService questionService;

    public ExamProgramInterfaceController() {
        scanner = new Scanner(System.in);
        examProgramService = new ExamProgramService();
        questionService = new QuestionService();
    }

    public void startApplication() {    //2.rodysim meniu kol nepaspaus 5
        String action;
        do {
            showMenu();
            action = scanner.nextLine();
            selectAction(action);
        } while (!action.equals("6"));
    }

    private void showMenu() {       //1.
        System.out.println("""
                1. Create exam program
                2. Create questions
                3. Update exam
                4. Take an exam
                5. View exam statistics
                6. Exit
                """);
    }

    private void selectAction(String action) {      //4.1
        switch (action) {
            case "1" -> createExamProgram();
            case "2" -> createQuestions();
            case "3" -> System.out.println ("updateQuestions()");
            case "4" -> System.out.println ("takeExam()");
            case "5" -> System.out.println ("viewExamStatistics()");
            case "6" -> System.out.println("System turning of");
            default -> System.out.println("action does not exist");
        }
    }

    private void createQuestions() {                 //5.
        System.out.println("Insert question");
        String question = scanner.nextLine();
        System.out.println("Insert answer A");
        String answerA = scanner.nextLine();
        System.out.println("Insert answer B");
        String answerB = scanner.nextLine();
        System.out.println("Insert answer C");
        String answerC = scanner.nextLine();
        System.out.println("Insert correct answer");
        String correctAnswer = scanner.nextLine();

        Question question1 = new Question(question, answerA, answerB, answerC, correctAnswer);
        questionService.createQuestion(question1); //iskviecia servisa, kuris sako sukurk user
        // (User service class - servisas turi repository -
        // objekta, is to objekto kvieciame createUser)
    }

    private void createExamProgram() {
        List<ExamProgram> exams = examProgramService.getExamProgram();
        for (ExamProgram examProgram : exams) {
            System.out.printf("%s. %s %s\n", examProgram.getId(), examProgram.getExamName(), examProgram.getUserId(),
                                             examProgram.getNewQuestion(), examProgram.getEditQuestion(), examProgram.getStatistics());
        }

        System.out.println("Select examProgram");            //priskirti klausima Egzaminui
        ExamProgram examProgram = getExamProgram(exams);

        System.out.println("Insert exam Name");
        String examName = scanner.nextLine();
        System.out.println("Insert userId");
        String userId = scanner.nextLine();
        System.out.println("Insert newQuestion");
        String newQuestion = scanner.nextLine();
        System.out.println("Edit Question");
        String editQuestion = scanner.nextLine();
        System.out.println("Look statistics");
        String statistics = scanner.nextLine();

        ExamProgram exam = new ExamProgram (examName, userId, newQuestion, editQuestion, statistics);
        examProgramService.createExamProgram(exam);

        //iskviecia servisa, kuris sako sukurk user
        // (User service class - servisas turi repository -
        // objekta, is to objekto kvieciame createUser)
    }


    private ExamProgram getExamProgram(List<ExamProgram> examPrograms) {
        ExamProgram examProgram;
        do {
            Long examProgramId = getCorrectNumber();
            examProgram = examPrograms.stream().filter(e -> e.getId().equals(examProgramId)).findFirst().orElse(null);
            if (examProgram == null) {
                System.out.println("Exam does not exist, please insert existing exam id");
            }

        } while (examProgram != null);

        return examProgram;
    }

    private Long getCorrectNumber() {
        while (true) {
            try {
                return Long.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Incorect number, please try again");

            }
        }
    }
}