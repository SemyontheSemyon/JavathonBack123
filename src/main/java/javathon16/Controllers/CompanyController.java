package javathon16.Controllers;

import javathon16.Models.Company;
import javathon16.Repositories.CompanyRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {
    CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        companyRepository.save(new Company("coffy", 5));
    }

    @GetMapping("/api/company/getbyid")
    public Company getCompanyById ( @RequestParam(value = "id" )int id){
        return companyRepository.findById(id).get();
    }

    @PostMapping("/api/company/add")
    public void addcompany(@RequestParam (value = "name") String name,
                             @RequestParam (value ="maxBonus" ) int maxBonus) {
        companyRepository.save(new Company(name, maxBonus));
    }

    @GetMapping("/api/company/get")
    public List<Company> getCompanies(){
        return (List)companyRepository.findAll();
    }

    @GetMapping("/api/company/getbyname")
    public Company getCompanyByName( @RequestParam(value = "name") String name) {return companyRepository.findByName(name);}

    @PostMapping("/api/company/removebyid")
    public void removeCompanyById( @RequestParam(value = "id" ) int id){
        companyRepository.delete(getCompanyById(id));
    }

    @PostMapping("/api/company/removebyname")
    public void removeCompanyById( @RequestParam(value = "name" ) String name){
        companyRepository.delete(getCompanyByName(name));
    }
}
