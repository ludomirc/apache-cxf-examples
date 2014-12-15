
package pl.ivmx.examples.cxf.service;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Car complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Car">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://service.cxf.examples.ivmx.pl/}Type"/>
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Car", propOrder = {
    "id",
    "type",
    "brand",
    "name"
})
@XmlRootElement(name = "car")
public class Car {

    protected int id;
    @XmlElement(required = true)
    protected Type type;
    @XmlElement(required = true)
    protected String brand;
    @XmlElement(required = true)
    protected String name;

    /**
     * Gets the value of the id property.
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link pl.ivmx.examples.cxf.service.Type }
     *
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link pl.ivmx.examples.cxf.service.Type }
     *
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the brand property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

}
