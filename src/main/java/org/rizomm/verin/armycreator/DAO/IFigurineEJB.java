package org.rizomm.verin.armycreator.DAO;

import org.rizomm.verin.armycreator.Model.CFigurine;

import java.util.List;

/**
 * Created by Wolf on 02/01/2017.
 */
public interface IFigurineEJB {
    List<CFigurine> getAllFigurines();

    CFigurine createFigurine(CFigurine Figurine);
    void deleteFigurine(CFigurine Figurine);
    CFigurine updateFigurine(CFigurine Figurine);

    CFigurine findFigurineById(Long id);
    List<CFigurine> findFigurineByName(String name);
}
