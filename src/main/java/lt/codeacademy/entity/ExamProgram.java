package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "examPrograms")

public class ExamProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String examName;
    private String userId;
    private String newQuestion;
    private String editQuestion;
    private String statistics;

    @OneToMany(mappedBy = "examProgram", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //cascade - kad galetume istrinti exam
    private Set<Question> questions;

    public ExamProgram(String examName, String userId, String newQuestion, String editQuestion, String statistics) {
        this.examName = examName;
        this.userId = userId;
        this.newQuestion = newQuestion;
        this.editQuestion = editQuestion;
        this.statistics = statistics;
    }
}

