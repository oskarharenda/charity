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
@RequestMapping("donation")
public class DonationController {
    final private InstitutionService institutionService;
    final private CategoryService categoryService;
    final private DonationService donationService;

    public DonationController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService, DonationService donationService1) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService1;
    }


    @GetMapping
    public String addDonation(Model model){
        model.addAttribute("institutions",institutionService.allInstitution());
        model.addAttribute("categories",categoryService.allCategory());
        model.addAttribute("donation", new DonationDto());
        return "form";
    }

    @PostMapping
    public String processAddDonation(@Valid @ModelAttribute("donation") DonationDto donationDto, BindingResult result){
        if(result.hasErrors()){
            return "hasErrors:"+result.toString();
        }
        donationService.saveDonation(donationDto);
        return "formConfirmation";
    }
}
