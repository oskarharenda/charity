package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repositories.DonationRepository;

@Service
public class DonationService {
    public final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
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
        Donation donation = new Donation();
        donation.setInstitution(donationDto.getInstitution());
        donation.setCategory(donationDto.getCategory());
        donation.setCity(donationDto.getCity());
        donation.setPickUpComment(donationDto.getPickUpComment());
        donation.setQuantity(donationDto.getQuantity());
        donation.setStreet(donationDto.getStreet());
        donation.setZipCode(donationDto.getZipCode());
        donationRepository.save(donation);
    }
}
