package org.rizomm.verin.armycreator.DAO;

import org.rizomm.verin.armycreator.Model.CFigurine;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;


@Named
@Stateless
@Remote
public class FigurineEJB implements IFigurineEJB,Serializable {

    @PersistenceContext(unitName = "DAOLama")
    private EntityManager em;

    public List<CFigurine> getAllFigurines(){
        TypedQuery<CFigurine> q= em.createNamedQuery(CFigurine.FIND_ALL, CFigurine.class);
        em.joinTransaction();
        return q.getResultList();
    }

    public CFigurine createFigurine(CFigurine Figurine){
        em.persist(Figurine);
        return Figurine;
    }

    public void deleteFigurine(CFigurine Figurine){
        em.remove(em.merge(Figurine));
    }


    public CFigurine updateFigurine(CFigurine Figurine){
       return em.merge(Figurine);
    }


    public CFigurine findFigurineById(Long id){
        return em.find(CFigurine.class, id);
    }

    public List<CFigurine> findFigurineByName(String name){
        TypedQuery<CFigurine> q= em.createNamedQuery(CFigurine.FIND_BYNAME, CFigurine.class);
        q.setParameter(0, name);
        em.joinTransaction();
        return q.getResultList();
    }
}
