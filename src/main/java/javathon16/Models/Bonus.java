package javathon16.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bonus {

    @Id
    @GeneratedValue
    private Long id;

    private int value;

    private Long companyId;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    private Long clientId;

    private Bonus(){}

    public Bonus(int value){
        this.value = value;
    }

}
