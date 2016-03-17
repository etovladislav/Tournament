package ru.kpfu.itis.tournament.form;

import org.hibernate.validator.constraints.Email;

/**
 * Created by etovladislav on 10.03.16.
 */
public class RegistrationForm {

    private String name;

    private String email;

    private String password;

    public RegistrationForm() {
    }

    public RegistrationForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
