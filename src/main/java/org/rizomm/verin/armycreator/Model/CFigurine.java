package org.rizomm.verin.armycreator.Model;



import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static org.rizomm.verin.armycreator.Model.CFigurine.FIND_ALL;
import static org.rizomm.verin.armycreator.Model.CFigurine.FIND_BYNAME;


@Entity
@Table
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query="SELECT f FROM CFigurine f"),
        @NamedQuery(name=FIND_BYNAME, query="SELECT f FROM CFigurine f WHERE f.Name LIKE :name")
    }
)

@XmlRootElement
public class CFigurine implements Serializable {

    public static final String FIND_ALL = "Figurine.findAllFigurine";
    public static final String FIND_BYNAME = "Figurine.findFigurineByName";

    /*********Attributes****************/

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    private String Name;

    private String Description;

    @Min(value =0)
    private Integer Points;

    @Min(value=0)
    private Integer Move;

    @Min(value=1)
    private Integer Save;

    @Min(value=1)
    private Integer PV;

    @Min(value=1)
    @Max(value=10)
    private Integer Bravery;

    /*********Get/Set****************/

    public Long getId() {
        return Id;
    }

    public void setId(Long id){Id = id;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getPoints() {
        return Points;
    }

    public void setPoints(Integer points) {
        Points = points;
    }

    public Integer getMove() {
        return Move;
    }

    public void setMove(Integer move) {
        Move = move;
    }

    public Integer getSave() {
        return Save;
    }

    public void setSave(Integer save) {
        Save = save;
    }

    public Integer getPV() {
        return PV;
    }

    public void setPV(Integer PV) {
        this.PV = PV;
    }

    public Integer getBravery() {
        return Bravery;
    }

    public void setBravery(Integer bravery) {
        Bravery = bravery;
    }




}
