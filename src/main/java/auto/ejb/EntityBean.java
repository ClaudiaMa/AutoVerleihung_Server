/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package auto.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstrakte Basisklasse für EJBs, die einfach nur Standardmethoden zum Lesen
 * und Schreiben eines Entity-Typs bietet.
 *
 * @param <Entity> Basisklasse der Entität
 * @param <EntityId> Datentyp oder Klasse für die Schlüsselwerte
 */
public abstract class EntityBean<Entity, EntityId> {

    @PersistenceContext
    EntityManager em;

    private final Class<Entity> entityClass;
    
    public EntityBean(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    //
    // Vorhandene Datensätze finden
    //
    public Entity findById(EntityId id) {
        return em.find(entityClass, id);
    }

    public List<Entity> findAll() {
        String select = "SELECT s FROM $C s".replace("$C", this.entityClass.getName());
        return em.createQuery(select).getResultList();
    }

    //
    // Datensätze speichern, ändern, löschen
    //
    public Entity saveNew(Entity entity) {
        em.persist(entity);
        return em.merge(entity);
    }

    public Entity update(Entity entity) {
        return em.merge(entity);
    }

    public void delete(Entity entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }
}
