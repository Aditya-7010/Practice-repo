
package com.cognizant.ormlearn.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qt_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion",
            fetch = FetchType.EAGER)
    private Set<AttemptOption> selectedOptions;

    public AttemptQuestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<AttemptOption> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(
            Set<AttemptOption> selectedOptions) {

        this.selectedOptions = selectedOptions;
    }

    @Override
    public String toString() {
        return "AttemptQuestion [id=" + id + "]";
    }
}
