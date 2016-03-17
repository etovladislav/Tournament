package ru.kpfu.itis.tournament.service;

import ru.kpfu.itis.tournament.form.RegistrationForm;

/**
 * Created by etovladislav on 10.03.16.
 */
public interface UserService {

    boolean registration(RegistrationForm registrationForm);
}
