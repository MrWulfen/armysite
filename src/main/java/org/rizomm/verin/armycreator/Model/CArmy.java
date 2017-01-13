package org.rizomm.verin.armycreator.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.rizomm.verin.armycreator.Model.CArmy.FIND_ALL;
import static org.rizomm.verin.armycreator.Model.CArmy.FIND_BYMAIL;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name=FIND_ALL, query="SELECT a FROM CArmy a"),
        @NamedQuery(name=FIND_BYMAIL, query="SELECT a FROM CArmy a WHERE a.Mail = :mail")
    }
)
public class CArmy implements Serializable {
    public static final String FIND_ALL = "Army.findAllArmy";
    public static final String FIND_BYMAIL = "Army.findArmiesByMail";

    /*********Attributes****************/

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    private String Name;

    private String Mail;

    private Integer State;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CArmyLine> ArmyLine;

    /*********Get/Set****************/

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public List<CArmyLine> getArmyLine() {
        return ArmyLine;
    }

    public void setArmyLine(List<CArmyLine> armyLine) {
        ArmyLine = armyLine;
    }

    public CArmy(){
        ArmyLine = new ArrayList<>();
    }

    public void addArmyLine(CFigurine Figurine, Integer Nb){
        Boolean found = false;
        for(CArmyLine armyLine:ArmyLine ){
            if(armyLine.getFigurine().getId() == Figurine.getId()){
                found = true;
                armyLine.setNb(armyLine.getNb()+Nb);
            }
        }
        if(!found){
            if(Nb > 0) {
                CArmyLine armyLine = new CArmyLine();
                armyLine.setArmy(this);
                armyLine.setFigurine(Figurine);
                armyLine.setNb(Nb);
            }
        }
    }

    public void deleteArmyLine(CFigurine Figurine){
        for(CArmyLine armyLine:ArmyLine ){
            if(armyLine.getFigurine().getId() == Figurine.getId()){
                ArmyLine.remove(armyLine);
                return;
            }
        }
    }
}
