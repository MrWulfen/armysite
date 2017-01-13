package org.rizomm.verin.armycreator.Service;

import org.rizomm.verin.armycreator.DAO.IFigurineEJB;
import org.rizomm.verin.armycreator.Model.CFigurine;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class FigurineController implements Serializable {

    private static final long serialVersionUID = 1L;

    private CFigurine figurine  = new CFigurine();

    private String searchStr;

    private List<CFigurine> searchFigurines = new ArrayList<CFigurine>();

    @EJB
    IFigurineEJB figurineEJB;

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public List<CFigurine> getSearchFigurines() {
        return searchFigurines;
    }

    public void setSearchFigurines(List<CFigurine> searchFigurines) {
        this.searchFigurines = searchFigurines;
    }

    public CFigurine getFigurine() {
        return figurine;
    }

    public void setFigurine(CFigurine Figurine) {
        figurine = Figurine;
    }


    public CFigurine doGetFigurineById(String id){
        Long Id = Long.parseLong(id);
        return figurineEJB.findFigurineById(Id);
    }

    public List<CFigurine> doGetAllFigurine(){
        return figurineEJB.getAllFigurines();
    }

    public String doGetFigurinesByName(){
        searchFigurines = figurineEJB.findFigurineByName(searchStr);
        return "FigurineList";
    }

    public String doAddFigurine(){
        figurineEJB.createFigurine(figurine);
        return "Home";
    }
}
