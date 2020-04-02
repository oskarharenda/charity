package pl.coderslab.charity.dto;
import lombok.Data;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DonationDto {
    private Integer quantity;

    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private Category category;
    private Institution institution;
}
