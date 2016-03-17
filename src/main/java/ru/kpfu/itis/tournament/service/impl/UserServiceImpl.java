package ru.kpfu.itis.tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.tournament.form.RegistrationForm;
import ru.kpfu.itis.tournament.form.RegistrationFormToUser;
import ru.kpfu.itis.tournament.model.User;
import ru.kpfu.itis.tournament.repository.UserRepository;
import ru.kpfu.itis.tournament.service.UserService;

/**
 * Created by etovladislav on 10.03.16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean registration(RegistrationForm registrationForm) {
       User user = RegistrationFormToUser.registrationFormToUser(registrationForm);
        userRepository.save(user);
        return true;
    }
}
