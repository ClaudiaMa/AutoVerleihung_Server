package auto.soap;

import auto.ejb.FahrzeugBean;
import auto.ejb.KundenBean;
import auto.ejb.LeihvertragBean;
import auto.jpa.Fahrzeug;
import auto.jpa.Kunde;
import auto.jpa.Leihvertrag;
import auto_server.exceptions.NotAvailableException;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "Autoverleih")
public class AutoverleihSoapWebservice {

    @EJB
    KundenBean kundenbean;

    @EJB
    LeihvertragBean leihvertragbean;

    @EJB
    FahrzeugBean fahrzeugbean;

    @WebMethod
    @WebResult(name = "kunde")
    public Kunde createNewKunde(@WebParam(name = "kunde") Kunde kunde) {
        return kundenbean.saveNew(kunde);
    }

    @WebMethod
    @WebResult(name = "fahrzeug")
    public Fahrzeug createNewFahrzeug(@WebParam(name = "fahrzeug") Fahrzeug fahrzeug) {
        return fahrzeugbean.saveNew(fahrzeug);
    }

    @WebMethod
    @WebResult(name = "leihvertrag")
    public Leihvertrag createNewLeihvertrag(@WebParam(name = "kunde") Kunde kunde,
            @WebParam(name = "fahrzeug") Fahrzeug fahrzeug,
            @WebParam(name = "beginnzeit") Date beginnzeit,
            @WebParam(name = "endzeit") Date endzeit) throws NotAvailableException {
        return leihvertragbean.ausleihen(kunde, fahrzeug, beginnzeit, endzeit);
    }

    @WebMethod
    @WebResult(name = "fahrzeug")
    public List<Fahrzeug> fahrzeugAuflisten() {
        return fahrzeugbean.findAll();
    }

    @WebMethod
    @WebResult(name = "leihvertrag")
    public List<Leihvertrag> leihvertragAuflisten(@WebParam(name = "kunde") Kunde kunde) {
        return leihvertragbean.findByKundenId(kunde);
    }

    // zusatz Methode??
    @WebMethod
    @WebResult(name = "fahrzeug")
    public Fahrzeug findFahrzeugById(@WebParam(name = "fahrzeugID") Long id) {
        return fahrzeugbean.findById(id);
    }

    @WebMethod
    @WebResult(name = "kunde")
    public Kunde findKundeById(@WebParam(name = "kundenID") Long id) {
        return kundenbean.findById(id);
    }

    @WebMethod
    @WebResult(name = "leihvertrag")
    public List<Leihvertrag> findAllLeihvertraege() {
        return leihvertragbean.findAll();
    }
}