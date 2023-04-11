package appli_sport_jpa.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "client_temporaire")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "client_temporaire_id")),
        @AttributeOverride(name = "nom", column = @Column(name = "client_temporaire_nom", nullable = false)),
        @AttributeOverride(name = "prenom", column = @Column(name = "client_temporaire_prenom", nullable = false)),
        @AttributeOverride(name = "email", column = @Column(name = "client_temporaire_email")),
        @AttributeOverride(name = "login", column = @Column(name = "client_temporaire_login", nullable = false)),
        @AttributeOverride(name = "mdp", column = @Column(name = "client_temporaire_mdp", nullable = false)),
        @AttributeOverride(name = "dateNaissance", column = @Column(name = "client_temporaire_dateNaissance"))
})
public class ClientTemporaire  extends Personne{
    @ManyToOne
    private Client creePar;

    private Date dateCreation;

    public ClientTemporaire() {
    }

    public ClientTemporaire(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces, LocalDate dateNaissance, Client creePar,Date dateCreation) {
        super(nom, prenom, email, login, mdp, pointsDeSucces, dateNaissance);
        this.creePar = creePar;
        this.dateCreation = dateCreation;
    }

    public Client getCreePar() {
        return creePar;
    }

    public void setCreePar(Client creePar) {
        this.creePar = creePar;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
