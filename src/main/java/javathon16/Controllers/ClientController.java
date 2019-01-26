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
    }

    @GetMapping("/api/client/getbyid")
    public Client getClientById(@RequestParam(value = "id") Long id){
        return clientRepository.findById(id).get();
    }

    @PostMapping("/api/client/addclient")
    public String addclient(@RequestParam(value = "name") String name,
                            @RequestParam(value = "phoneNumber") String phoneNumber){
        clientRepository.save(new Client(999, "qwe"));
        System.out.println(clientRepository.findById(new Long(1)));
        return "qqq";
    }




}
