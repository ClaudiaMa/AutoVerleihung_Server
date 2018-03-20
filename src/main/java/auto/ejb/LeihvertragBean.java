package auto.ejb;

import auto.jpa.Fahrzeug;
import auto.jpa.Kunde;
import auto.jpa.Leihvertrag;
import auto_server.exceptions.NotAvailableException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, Long> {
    
    public LeihvertragBean() {
        super(Leihvertrag.class);
    }
    
   public List<Leihvertrag> findByKundenId(Kunde kunde) {

        return em.createQuery("SELECT l FROM Leihvertrag l"
                + "    WHERE l.kunde.id = :kundenid"
                + "     ORDER BY l.beginndatum")
                .setParameter("kundenid", kunde.getId())
                .getResultList();
    }

public Leihvertrag ausleihen(Kunde kunde, Fahrzeug fahrzeug, Date beginndatum, Date enddatum) throws NotAvailableException {

        List<Leihvertrag> prüfen = em.createQuery("SELECT l FROM Leihvertrag l"
                + "  WHERE l.fahrzeugid = :fahrzeugid "
                + "  AND ((l.beginndatum >= :beginndatum AND l.beginndatum <= :enddatum)"
                + "  OR   (l.enddatum >= :beginndatum AND l.enddatum <= :enddatum)"
                + "  OR   (l.beginndatum <= :beginndatum AND l.enddatum >= :enddatum))")
                .setParameter("beginndatum", beginndatum)
                .setParameter("enddatum", enddatum)
                .setParameter("fahrzeugid", fahrzeug.getId())
                .getResultList();

        if (prüfen.isEmpty()) {
            Leihvertrag leihvertrag = new Leihvertrag(kunde, fahrzeug, beginndatum, enddatum);
            return this.saveNew(leihvertrag);

        } else {
            throw new NotAvailableException("Auto ist bereits gebucht!");
        }
    }
}
