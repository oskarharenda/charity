package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;


@Controller
public class HomeController {
    final private InstitutionService institutionService;
    final private DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions",institutionService.allInstitution());
        model.addAttribute("donationsQuantity",donationService.allQuantity());
        model.addAttribute("donationCount",donationService.countDonation());
        return "index";
    }
}
