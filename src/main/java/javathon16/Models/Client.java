package javathon16.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int clientId;

    private Long phoneNumber;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bonus> bonuses;

    private Client(){}

    public Client(Long phoneNumber, String name){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.bonuses = new HashSet<>();
    }

    public int getId() {
        return clientId;
    }

    public void setId(int id) {
        this.clientId = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBonus(Bonus bonus){
        this.bonuses.add(bonus);
    }

    public Set<Bonus> getBonuses() {
        return bonuses;
    }
}
