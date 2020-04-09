package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.services.UserService;


import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {


    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model){
        model.addAttribute("data",new UserDto());
        return "registration";
    }

    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute("data") UserDto userDto, BindingResult result){
        if (result.hasErrors()){
            return "registration";
        }

        userService.userRegister(userDto);

        return "redirect:/login";
    }

}
