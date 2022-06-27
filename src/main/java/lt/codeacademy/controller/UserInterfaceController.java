package lt.codeacademy.controller;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.User;
import lt.codeacademy.service.ExamService;
import lt.codeacademy.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserInterfaceController {
    private final Scanner scanner;              //3.
    private final UserService userService;
    private final ExamService examService;

    public UserInterfaceController() {
        scanner = new Scanner(System.in);
        userService = new UserService();
        examService = new ExamService();
    }

    public void startApplication() {    //2.rodysim meniu kol nepaspaus 9
        String action;
        do {
            showMenu();
            action = scanner.nextLine();
            selectAction(action);
        } while (!action.equals("9"));
    }

    private void showMenu() {       //1.
        System.out.println("""
                1. Create user
                2. Create exam
                9. Exit
                """);
    }

    private void selectAction(String action) {      //4.
        switch (action) {
            case "1" -> createUser();
            case "2" -> createExam();
            case "9" -> System.out.println("System turning of");
            default -> System.out.println("action does not exist");
        }
    }

    private void createUser() {                 //5.
        System.out.println("Insert name");
        String name = scanner.nextLine();
        System.out.println("Insert surname");
        String surname = scanner.nextLine();
        System.out.println("Insert phone");
        String phone = scanner.nextLine();
        System.out.println("Insert email");
        String email = scanner.nextLine();

        User user = new User(name, surname, phone, email);
        userService.createUser(user); //iskviecia servisa, kuris sako sukurk user
        // (User service class - servisas turi repository -
        // objekta, is to objekto kvieciame createUser)

    }

    public void createExam() {
        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.printf("%s. %s %s\n", user.getId(), user.getName(), user.getSurname());
        }

        System.out.println("Select user");
        User user = getUser(users);
        /////////

    }

   /* Exam exam=new Exam();
        exam.setUser(user);

        examService.createExam(exam);*/

    private User getUser(List<User> users) {
        User user;
        do {
            Long userId = getCorrectNumber();
            user = users.stream().filter(e -> e.getId().equals(userId)).findFirst().orElse(null);
            if (user == null) {
                System.out.println("User does not exist, please insert existing user id");
            }

        } while (user != null);

        return user;
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