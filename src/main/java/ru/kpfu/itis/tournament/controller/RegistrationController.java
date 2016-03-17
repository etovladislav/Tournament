package ru.kpfu.itis.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tournament.form.RegistrationForm;
import ru.kpfu.itis.tournament.service.UserService;

/**
 * Created by etovladislav on 10.03.16.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greeting")
    public String getGreetingPage() {
        return "greeting";
    }

    @RequestMapping(value = "/")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "/api/users/createUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody RegistrationForm registrationForm) {
        userService.registration(registrationForm);
    }

    @RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Boolean authenticate(@RequestBody String username) {
        System.out.println("asdasdasdasdasd");
        return Boolean.TRUE;
    }
}
