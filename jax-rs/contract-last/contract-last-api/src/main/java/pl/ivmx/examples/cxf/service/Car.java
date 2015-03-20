package pl.ivmx.examples.cxf.service;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Car",
        propOrder = {
                "id",
                "type",
                "brand",
                "name"
        },
        namespace = "http://service.cxf.examples.ivmx.pl/"
)
@XmlRootElement(
        name = "car",
        namespace = "http://service.cxf.examples.ivmx.pl/"
)
public class Car {

    protected int id;
    @XmlElement(
            required = true,
            namespace = "http://service.cxf.examples.ivmx.pl/"
    )
    protected Type type;
    @XmlElement(required = true)
    protected String brand;
    @XmlElement(required = true)
    protected String name;

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link pl.ivmx.examples.cxf.service.Type }
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link pl.ivmx.examples.cxf.service.Type }
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the brand property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

}
