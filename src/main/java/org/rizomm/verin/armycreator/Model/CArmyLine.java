package org.rizomm.verin.armycreator.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table
public class CArmyLine {

    @GeneratedValue
    @javax.persistence.Id
    private Long Id;

    @ManyToOne
    private CArmy Army;

    @ManyToOne
    private CFigurine Figurine;

    @Min(0)
    private Integer Nb;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public CArmy getArmy() {
        return Army;
    }

    public void setArmy(CArmy army) {
        Army = army;
    }

    public CFigurine getFigurine() {
        return Figurine;
    }

    public void setFigurine(CFigurine figurine) {
        Figurine = figurine;
    }

    public Integer getNb() {
        return Nb;
    }

    public void setNb(Integer nb) {
        Nb = nb;
    }
}
