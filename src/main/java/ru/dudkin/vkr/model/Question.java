
package ru.dudkin.vkr.model;

import javax.persistence.*;


@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question", columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(name = "answer_1")
    private String ans1;

    @Column(name = "answer_1_bool")
    private Boolean ansBool1;

    @Column(name = "answer_2")
    private String ans2;

    @Column(name = "answer_2_bool")
    private Boolean ansBool2;

    @Column(name = "answer_3")
    private String ans3;

    @Column(name = "answer_3_bool")
    private Boolean ansBool3;

    @Column(name = "answer_4")
    private String ans4;

    @Column(name = "answer_4_bool")
    private Boolean ansBool4;

    public Question() {
    }

    public Question(String question, String ans1, Boolean ansBool1, String ans2, Boolean ansBool2,
                    String ans3, Boolean ansBool3, String ans4, Boolean ansBool4) {
        this.question = question;
        this.ans1 = ans1;
        this.ansBool1 = ansBool1;
        this.ans2 = ans2;
        this.ansBool2 = ansBool2;
        this.ans3 = ans3;
        this.ansBool3 = ansBool3;
        this.ans4 = ans4;
        this.ansBool4 = ansBool4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public Boolean getAnsBool1() {
        return ansBool1;
    }

    public void setAnsBool1(Boolean ansBool1) {
        this.ansBool1 = ansBool1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public Boolean getAnsBool2() {
        return ansBool2;
    }

    public void setAnsBool2(Boolean ansBool2) {
        this.ansBool2 = ansBool2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public Boolean getAnsBool3() {
        return ansBool3;
    }

    public void setAnsBool3(Boolean ansBool3) {
        this.ansBool3 = ansBool3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public Boolean getAnsBool4() {
        return ansBool4;
    }

    public void setAnsBool4(Boolean ansBool4) {
        this.ansBool4 = ansBool4;
    }
}

