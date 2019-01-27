package javathon16.Controllers;

import javathon16.Models.Client;
import javathon16.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){

        this.clientRepository = clientRepository;

        clientRepository.save(new Client(893135745l, "Semen"));
    }

    @GetMapping("/api/client/getbyid")
    public Client getClientById(@RequestParam(value = "id") int id){
        return clientRepository.findById(id).get();
    }

    @PostMapping("/api/client/add")

    public String addClient(@RequestParam (value = "name") String name,
                            @RequestParam( value = "phoneNumber") long phoneNumber){
        if (Long.toString(phoneNumber).matches("[0-9*#+() -]{10}")){
            clientRepository.save(new Client(phoneNumber, name));
            return "Succsess";
        }
        return "Fail";
    }

    @GetMapping("/api/client/deletebyid")
    public void deleteClient(@RequestParam(value = "id") int id){

        clientRepository.deleteById(id);

    }


}
