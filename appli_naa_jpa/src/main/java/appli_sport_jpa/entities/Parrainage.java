package appli_sport_jpa.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "parrainage")
public class Parrainage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client parrain;

    @ManyToOne
    private ClientTemporaire etreClient;

    private Date dateParrainage;

    public Parrainage(Long id, Client parrain, ClientTemporaire etreParrainer, Date dateParrainage) {
        this.id = id;
        this.parrain = parrain;
        this.etreClient = etreParrainer;
        this.dateParrainage = dateParrainage;
    }

    public Parrainage(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getparrain() {
        return parrain;
    }

    public void setparrain(Client parrain) {
        this.parrain = parrain;
    }

    public ClientTemporaire getEtreClient() {
        return etreClient;
    }

    public void setEtreClient(ClientTemporaire etreClient) {
        this.etreClient = etreClient;
    }

    public Date getDateParrainage() {
        return dateParrainage;
    }

    public void setDateParrainage(Date dateParrainage) {
        this.dateParrainage = dateParrainage;
    }
}
