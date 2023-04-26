package ajc.formation.soprasteria.appliSport.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class AmiAmisId implements Serializable {

    private String premierAmi;
    private String deuxiemeAmi;

        public AmiAmisId() {
        }

    public AmiAmisId(String premierAmi, String deuxiemeAmi) {
        this.premierAmi = premierAmi;
        this.deuxiemeAmi = deuxiemeAmi;
    }

    public String getPremierAmi() {
        return premierAmi;
    }

    public void setPremierAmi(String premierAmi) {
        this.premierAmi = premierAmi;
    }

    public String getDeuxiemeAmi() {
        return deuxiemeAmi;
    }

    public void setDeuxiemeAmi(String deuxiemeAmi) {
        this.deuxiemeAmi = deuxiemeAmi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmiAmisId amiAmisId = (AmiAmisId) o;
        return Objects.equals(premierAmi, amiAmisId.premierAmi) && Objects.equals(deuxiemeAmi, amiAmisId.deuxiemeAmi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premierAmi, deuxiemeAmi);
    }
}
