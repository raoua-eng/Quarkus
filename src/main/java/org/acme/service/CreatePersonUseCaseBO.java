package org.acme.service;

import java.time.LocalDate;

public class CreatePersonUseCaseBO{
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String civility;
    
    public CreatePersonUseCaseBO(String name, LocalDate dateOfBirth, String email, String civility) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.civility = civility;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCivility() {
        return civility;
    }
    public void setCivility(String civility) {
        this.civility = civility;
    }
    @Override
    public String toString() {
        return "CreatePersonUseCaseBO [civility=" + civility + ", dateOfBirth=" + dateOfBirth + ", email=" + email
                + ", name=" + name + "]";
    }
    
}