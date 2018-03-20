package auto.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Claudia
 */
@Entity
public class Fahrzeug implements Serializable {
    
    @Id
    @GeneratedValue(generator = "fahrzeug_id")
    @TableGenerator(name = "fahrzeug_id", initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
    @OneToMany
    private List<Leihvertrag> leihverträge = new ArrayList();
    
    @NotNull
    @Size(min = 1)
    private String hersteller = "";
    
    @NotNull
    @Size(min = 1)
    private String modell = "";
    
    @NotNull
    @Size(min = 1)
    private String baujahr = "";
   
    
    public Fahrzeug(){
        
    }
    public Fahrzeug(long id, String hersteller, String modell, String baujahr){
       this.id = id;
       this.hersteller = hersteller;
       this.modell = modell;
       this.baujahr = baujahr;
    }

//<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public List<Leihvertrag> getLeihverträge() {
        return leihverträge;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    public String getModell() {
        return modell;
    }
    
    public String getBaujahr() {
        return baujahr;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setLeihverträge(List<Leihvertrag> leihverträge) {
        this.leihverträge = leihverträge;
    }
    
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    public void setModell(String modell) {
        this.modell = modell;
    }
    
    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }
//</editor-fold>
    
    
}
