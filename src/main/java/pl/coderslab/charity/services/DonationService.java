package pl.coderslab.charity.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.repositories.UserRepository;

@Service
public class DonationService {
    public final DonationRepository donationRepository;
    public final InstitutionRepository institutionRepository;
    public final CategoryRepository categoryRepository;
    public final UserRepository userRepository;

    public DonationService(DonationRepository donationRepository, InstitutionRepository institutionRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public int allQuantity(){
        int sum = 0;
        for(Donation donation: donationRepository.findAll()){
            sum+=donation.getQuantity();
        }
        return sum;
    }
    public int countDonation(){
        return donationRepository.findAll().size();
    }
    public void saveDonation(DonationDto donationDto){
        Donation donation = toDonation(donationDto);
        donationRepository.save(donation);
    }

    private Donation toDonation(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setInstitution(institutionRepository.getOne(donationDto.getInstitutionId()));
        donation.setCategories(categoryRepository.findAllById(donationDto.getCategoryId()));
        donation.setCity(donationDto.getCity());
        donation.setPickUpComment(donationDto.getPickUpComment());
        donation.setQuantity(donationDto.getQuantity());
        donation.setStreet(donationDto.getStreet());
        donation.setZipCode(donationDto.getZipCode());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        donation.setUser(user);
        return donation;
    }
}
