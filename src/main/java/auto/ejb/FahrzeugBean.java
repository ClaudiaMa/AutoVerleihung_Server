package auto.ejb;

import auto.jpa.Fahrzeug;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class FahrzeugBean extends EntityBean<Fahrzeug, Long>{
    public FahrzeugBean() {
        super(Fahrzeug.class);
    }
    
    
    public List<Fahrzeug> findAllFahrzeuge(){
        return em.createQuery("SELECT f FROM Fahrzeug f"
                            + "ORDER BY f.id")
                            .getResultList();
    }
    
    
}
