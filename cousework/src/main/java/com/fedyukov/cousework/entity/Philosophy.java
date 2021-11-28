package com.fedyukov.cousework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "philosophy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Philosophy {

    @Id
    @Column(name = "scorebooknumber")
    private Integer scorebookNumber;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "subject")
    private String subject;

    public Integer getScorebookNumber() {
        return scorebookNumber;
    }

    public void setScorebookNumber(Integer scorebookNumber) {
        this.scorebookNumber = scorebookNumber;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
