package javathon16.Controllers;

import javathon16.Models.Client;
import javathon16.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping("/api/client/getbyid")
    public Client getClientById(@RequestParam(value = "id") int id){
        return clientRepository.findById(id).get();
    }

    @PostMapping("/api/client/add")
    public void addclient(@RequestParam(value = "name") String name,
                            @RequestParam(value = "phoneNumber") long phoneNumber){
        clientRepository.save(new Client(phoneNumber, name));
    }

    @GetMapping("/api/client/deletebyid")
    public void deleteClient(@RequestParam(value = "id") int id){

        clientRepository.deleteById(id);
    }

    @GetMapping("api/client/get")
    public List<Client> getClients(){
        return (List)clientRepository.findAll();
    }

    @PostMapping("/api/client/deletebyphone")
    public void deleteClient(@RequestParam(value = "id") Long phone){

        clientRepository.delete(clientRepository.findByPhoneNumber(phone));
    }



}
