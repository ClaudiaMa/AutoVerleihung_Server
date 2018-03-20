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

@Entity
public class Kunde implements Serializable {
    
    @Id
    @GeneratedValue(generator = "kunde_id")
    @TableGenerator(name = "kunde_id", initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
    @OneToMany
    private List<Leihvertrag> leihverträge = new ArrayList();
    
    @NotNull
    @Size(min = 1)
    private String vorname = "";
    
    @NotNull
    @Size(min = 1)
    private String nachname = "";
    
    @NotNull
    @Size(min = 1)
    private String strasse = "";
   
    @NotNull
    @Size(min = 1)
    private String hausnummer = "";
    
    @NotNull
    @Size(min = 1)
    private String plz = "";
    
    @NotNull
    @Size(min = 1)
    private String ort = "";
    
    @NotNull
    @Size(min = 1)
    private String land = "";
    
    public Kunde(){
        
    }
    public Kunde(long id, String vorname, String nachname, String strasse, String hausnummer, String plz, String ort, String land){
       this.id = id;
       this.vorname = vorname;
       this.nachname = nachname;
       this.strasse = strasse;
       this.hausnummer = hausnummer;
       this.plz = plz;
       this.ort = ort;
       this.land = land;
    }

//<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public List<Leihvertrag> getLeihverträge() {
        return leihverträge;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public String getNachname() {
        return nachname;
    }
    
    public String getStrasse() {
        return strasse;
    }
    
    public String getHausnummer() {
        return hausnummer;
    }
    
    public String getPlz() {
        return plz;
    }
    
    public String getOrt() {
        return ort;
    }
    
    public String getLand() {
        return land;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setLeihverträge(List<Leihvertrag> leihverträge) {
        this.leihverträge = leihverträge;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }
    
    public void setPlz(String plz) {
        this.plz = plz;
    }
    
    public void setOrt(String ort) {
        this.ort = ort;
    }
    
    public void setLand(String land) {
        this.land = land;
    }
//</editor-fold>

    
    
    
    
}
