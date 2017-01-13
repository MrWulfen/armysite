package org.rizomm.verin.armycreator.DAO;

import org.rizomm.verin.armycreator.Model.CArmy;

import java.util.List;

/**
 * Created by Wolf on 11/01/2017.
 */
public interface IArmyEJB {
    List<CArmy> getAllArmies();
    List<CArmy> getAllArmiesByMail(String Mail);
    CArmy findArmyById(Long id);
    CArmy createArmy(CArmy Army);
    void deleteArmy(CArmy Army);
    CArmy updateArmy(CArmy Army);

}
