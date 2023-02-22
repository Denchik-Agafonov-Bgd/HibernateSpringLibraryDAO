package ru.agafonov.spring.library.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+", message = "Некорректное имя")
    @Column(name="fio")
    private String fio;

    @Min(value = 1900, message = "Дата рождения должна быть позже 1900 года")
    @Max(value = 2022, message = "Дата рождения должна быть раньше 2023 года")
    @Column(name = "birthday")
    private int birthday;

    @Column(name="email")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Email
    private String email;

    public Person(){}

    public Person(String fio, int birthday, String email) {
        this.fio = fio;
        this.birthday = birthday;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
