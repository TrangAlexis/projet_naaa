package ajc.formation.soprasteria.appliSport.entities;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "amis")
@IdClass(AmiAmisId.class)
public class AmiAmis {
    @Id
    @ManyToOne
    @JoinColumn(name="premierAmi_amis_id", foreignKey = @ForeignKey(name="premierAmi_amis_id_fk"))
    @JsonView(JsonViews.AmiAmis.class)
    private Client premierAmi;
    @Id
    @ManyToOne
    @JoinColumn(name="deuxiemeAmi_amis_id", foreignKey = @ForeignKey(name="deuxiemeAmi_amis_id_fk"))
    @JsonView(JsonViews.AmiAmis.class)
    private Client deuxiemeAmi;

    public AmiAmis() {
    }

    public AmiAmis(Client premierAmi, Client deuxiemeAmi) {
        this.premierAmi = premierAmi;
        this.deuxiemeAmi = deuxiemeAmi;
    }

    public Client getPremierAmi() {
        return premierAmi;
    }

    public void setPremierAmi(Client premierAmi) {
        this.premierAmi = premierAmi;
    }

    public Client getDeuxiemeAmi() {
        return deuxiemeAmi;
    }

    public void setDeuxiemeAmi(Client deuxiemeAmi) {
        this.deuxiemeAmi = deuxiemeAmi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmiAmis amiAmis = (AmiAmis) o;
        return Objects.equals(premierAmi, amiAmis.premierAmi) && Objects.equals(deuxiemeAmi, amiAmis.deuxiemeAmi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premierAmi, deuxiemeAmi);
    }
}
