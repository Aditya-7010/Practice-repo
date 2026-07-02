
package com.cognizant.ormlearn.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_attempted_date")
    private Date attemptedDate;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt",
            fetch = FetchType.EAGER)
    private Set<AttemptQuestion> questions;

    public Attempt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(Date attemptedDate) {
        this.attemptedDate = attemptedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AttemptQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<AttemptQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Attempt [id=" + id +
                ", attemptedDate=" + attemptedDate + "]";
    }
}
