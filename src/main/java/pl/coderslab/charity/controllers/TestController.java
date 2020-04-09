package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/test")
public class TestController {
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;

    public TestController(InstitutionService institutionService, CategoryService categoryService, DonationService donationService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService;
    }

    @GetMapping
    public String addDonation(Model model){
        model.addAttribute("institutions",institutionService.allInstitution());
        model.addAttribute("categories",categoryService.allCategory());
        model.addAttribute("donation", new DonationDto());
        return "test";
    }

    @PostMapping
    @ResponseBody
    public String processAddDonation(@Valid @ModelAttribute("donation") DonationDto donationDto, BindingResult result){
        if(result.hasErrors()){
            return "hasErrors:"+result.toString();
        }
        donationService.saveDonation(donationDto);
        return "donationDto: "+donationDto.toString();
    }
}
