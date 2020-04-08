package com.yesilay.stocktrace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.yesilay.stocktrace.service.UserService;
import com.yesilay.stocktrace.model.Users;
import com.yesilay.stocktrace.web.dto.UserRegistrationDto;

import javax.validation.Valid;

@Controller
@RequestMapping("/newuser")
public class UserRegistrationController {


    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "newuser";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        Users existing = userService.findByEmail(userDto.getUserEmail());

        if (existing != null) {
            result.rejectValue("userEmail", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return "newuser";
        }

        userService.save(userDto);

        return "redirect:/newuser?success";
    }
}