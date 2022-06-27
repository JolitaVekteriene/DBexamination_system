package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "exams")

public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String question;
    private String answer;
    private String rightAnswer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private User user;
//konstruktorius
    public Exam(String name, String question, String answer, String rightAnswer) {
        this.name = name;
        this.question = question;
        this.answer = answer;
        this.rightAnswer = rightAnswer;
    }
}

