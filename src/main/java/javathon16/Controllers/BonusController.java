package javathon16.Controllers;

import javathon16.Models.Client;
import javathon16.Models.Company;
import javathon16.Repositories.BonusRepository;
import javathon16.Repositories.ClientRepository;
import javathon16.Models.Bonus;
import javathon16.Repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class BonusController {
    BonusRepository bonusRepository;
    CompanyRepository companyRepository;
    ClientRepository clientRepository;

    @Autowired
    public BonusController(BonusRepository bonusRepository,
                           CompanyRepository companyRepository,
                           ClientRepository clientRepository){

        this.bonusRepository = bonusRepository;
        this.companyRepository = companyRepository;
        this.clientRepository = clientRepository;


    }

    @GetMapping("/api/bonus/findbonus")
    public List<Bonus> getBonusByClientIdAndCompanyName(@RequestParam(value = "id1") int clientId,
                                                        @RequestParam(value = "id2") int companyId)
    {
        return bonusRepository.findAllByClientIdAndCompanyId(clientId, companyId);
    }

    @PostMapping("/api/bonus/add")
    public void addBonus(@RequestParam(value = "clientPhoneNumber") Long phoneNumber,
                         @RequestParam(value = "companyName") String name) {
        Company company = companyRepository.findByName(name);
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        bonusRepository.save(new Bonus(company.getId(), client.getId()));
    }

    @PostMapping("/api/bonus/increase")
    public void increaseBonus(@RequestParam(value = "clientPhoneNumber") Long phoneNumber,
                         @RequestParam(value = "companyName") String name) {
        Company company = companyRepository.findByName(name);
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        Bonus tmp = bonusRepository.findAllByClientIdAndCompanyId(company.getId(), client.getId()).get(0);
        tmp.setValue(tmp.getCompanyId() + 1);
    }
    @PostMapping("/api/bonus/resetBonuses")
    public String resetBonuses(@RequestParam(value = "clientPhoneNumber") Long phoneNumber,
                             @RequestParam(value = "companyName") String name){
        Company company = companyRepository.findByName(name);
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        Bonus tmp = bonusRepository.findAllByClientIdAndCompanyId(company.getId(), client.getId()).get(0);
        tmp.setValue(0);
        return "На вашем счете 0 бонусов";
    }

}
