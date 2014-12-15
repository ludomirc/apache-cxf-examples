package pl.ivmx.examples.cxf.contractlast.model.shemas;

import javax.xml.bind.annotation.*;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@XmlType(name = "Car", propOrder = {
        "id",
        "type",
        "brand",
        "name"
})
public class Car {


    private Integer id;

    private Type type;

    private String brand;

    private String name;

    public Integer getId() {
        return id;
    }

    @XmlElement(required = true)
    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    @XmlElement(required = true)
    public void setType(Type type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    @XmlElement(required = true)
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    @XmlElement(required = true)
    public void setName(String name) {
        this.name = name;
    }
}
