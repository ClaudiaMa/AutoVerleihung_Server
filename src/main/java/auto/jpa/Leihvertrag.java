package auto.jpa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Leihvertrag implements Serializable {
    
    @Id
    @GeneratedValue(generator = "leihvertrag_id")
    @TableGenerator(name = "leihvertrag_id", initialValue = 0, allocationSize = 50)
    private long id = 0L;
    
    @ManyToOne
    private Kunde kunde = null;
    
    @ManyToOne
    private Fahrzeug fahrzeug = null;
    
    @NotNull
    @Size(min = 1)
    private long kundenid = 0;
    
    @NotNull
    @Size(min = 1)
    private long fahrzeugid = 0;
    
    @Temporal(TemporalType.DATE)
    private Date beginndatum = new Date();
    
    @Temporal(TemporalType.DATE)
    private Date enddatum = new Date();
     
    
    
    public Leihvertrag(){
        
    }
    public Leihvertrag(long id, long kundenid, long fahrzeugid, Date beginndatum, Date enddatum){
       this.id = id;
       this.kundenid = kundenid;
       this.fahrzeugid = fahrzeugid;
       this.beginndatum = beginndatum;
       this.enddatum = enddatum;
    }

    public Leihvertrag(Kunde kunde, Fahrzeug fahrzeug, Date beginndatum, Date enddatum){
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.beginndatum = beginndatum;
        this.enddatum = enddatum;
        
    }
//<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public Kunde getKunde() {
        return kunde;
    }
    
    public long getKundenid() {
        return kundenid;
    }
    
    public long getFahrzeugid() {
        return fahrzeugid;
    }
    
    public Date getBeginndatum() {
        return beginndatum;
    }
    
    public Date getEnddatum() {
        return enddatum;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    
    public void setKundenid(long kundenid) {
        this.kundenid = kundenid;
    }
    
    public void setFahrzeugid(long fahrzeugid) {
        this.fahrzeugid = fahrzeugid;
    }
    
    public void setBeginndatum(Date beginndatum) {
        this.beginndatum = beginndatum;
    }
    
    public void setEnddatum(Date enddatum) {
        this.enddatum = enddatum;
    }
//</editor-fold>
    
    
}
