package lt.codeacademy;

import lt.codeacademy.controller.ExamProgramInterfaceController;

public class AplicationMain {
    public static void main(String[] args) {
        ExamProgramInterfaceController controller = new ExamProgramInterfaceController();
        controller.startApplication();
    }
}
