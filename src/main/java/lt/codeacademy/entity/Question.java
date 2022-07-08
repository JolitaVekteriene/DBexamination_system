package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "questions")

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String correctAnswer;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "examProgram_id")
    private ExamProgram examProgram;
//konstruktorius

    public Question(String question, String answerA, String answerB, String answerC, String correctAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.correctAnswer = correctAnswer;
    }
}

