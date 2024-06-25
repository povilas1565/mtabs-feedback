package com.agas.feedback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@JsonIgnore
    private Long Id;

    @NotNull
    private String name;

    @NotNull
    @Min(7)
    private String tel;


    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }

}
