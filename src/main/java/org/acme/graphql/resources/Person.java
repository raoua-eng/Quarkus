package org.acme.graphql.resources;


import org.eclipse.microprofile.graphql.Name;

@Name("Person")
public class Person {
    private String name;
    private String dateOfBirth;
    private String email;
    private String civility;

    public Person(String name, String dateOfBirth, String email, String civility) {
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
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
    
}
