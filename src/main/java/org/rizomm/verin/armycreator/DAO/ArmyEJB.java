package org.rizomm.verin.armycreator.DAO;

import org.rizomm.verin.armycreator.Model.CArmy;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Stateful
@Remote
public class ArmyEJB implements IArmyEJB, Serializable{

    @PersistenceContext(unitName = "DAOLama")
    private EntityManager em;

    @Override
    public List<CArmy> getAllArmies() {
        TypedQuery<CArmy> q = em.createNamedQuery(CArmy.FIND_ALL, CArmy.class);
        em.joinTransaction();
        return q.getResultList();
    }

    @Override
    public List<CArmy> getAllArmiesByMail(String Mail) {
        TypedQuery<CArmy> q = em.createNamedQuery(CArmy.FIND_BYMAIL, CArmy.class);
        q.setParameter(0, Mail);
        em.joinTransaction();
        return q.getResultList();
    }

    @Override
    public CArmy findArmyById(Long id) {
        return em.find(CArmy.class, id);
    }

    @Override
    public CArmy createArmy(CArmy Army) {
        em.persist(Army);
        return Army;
    }

    @Override
    public void deleteArmy(CArmy Army) {
        em.remove(em.merge(Army));
    }

    @Override
    public CArmy updateArmy(CArmy Army) {
        return em.merge(Army);
    }
}
