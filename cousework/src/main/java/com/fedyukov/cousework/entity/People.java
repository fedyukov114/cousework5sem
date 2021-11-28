package com.fedyukov.cousework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "people")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class People {

    @Column(name = "fullname")
    private String fullName;

    @Id
    @Column(name = "scorebooknumber")
    @SequenceGenerator(name = "peopleIdSeq", sequenceName = "people_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peopleIdSeq")
    private Integer scorebookNumber;

    @Column(name = "groupnumber")
    private String groupNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getScorebookNumber() {
        return scorebookNumber;
    }

    public void setScorebookNumber(Integer scorebookNumber) {
        this.scorebookNumber = scorebookNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}
