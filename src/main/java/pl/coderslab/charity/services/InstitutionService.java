package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

   public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<InstitutionDto> allInstitution(){
        List<Institution> all = institutionRepository.findAll();
        List<InstitutionDto> institutionDto = new ArrayList<>();
        for(Institution institution : all){
            InstitutionDto instDto = new InstitutionDto();
            instDto.setName(institution.getName());
            instDto.setDescription(institution.getDescription());
            institutionDto.add(instDto);
        }
        return institutionDto;
    }
}
