package org.rizomm.verin.armycreator.Service;

import org.rizomm.verin.armycreator.DAO.IArmyEJB;
import org.rizomm.verin.armycreator.Model.CArmy;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ArmyController implements Serializable{
    private static final long serialVersionUID = 2L;

    private CArmy army = new CArmy();

    @EJB
    IArmyEJB armyEJB;

    public CArmy getArmy() {
        return army;
    }

    public void setArmy(CArmy army) {
        this.army = army;
    }

    public CArmy doGetArmyById(Long Id){
        return armyEJB.findArmyById(Id);
    }

    public List<CArmy> doGetArmyByMail(String Mail){
        return armyEJB.getAllArmiesByMail(Mail);
    }

    public CArmy doAddNewArmy(){
        if(army.getId() == null){
            return armyEJB.createArmy(army);
        }else{
            return army;
        }

    }
}
