package ru.kpfu.itis.tournament.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.tournament.model.User;

/**
 * Created by etovladislav on 10.03.16.
 */
public class RegistrationFormToUser {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User registrationFormToUser(RegistrationForm registrationForm) {
        User user = new User();
        user.setName(registrationForm.getName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(encoder.encode(registrationForm.getPassword()));
        return user;
    }
}
