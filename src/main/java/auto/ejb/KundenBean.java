package auto.ejb;

import auto.jpa.Kunde;
import javax.ejb.Stateless;

@Stateless
public class KundenBean extends EntityBean<Kunde, Long> {
    
    public KundenBean() {
        super(Kunde.class);
    } 
    
}
