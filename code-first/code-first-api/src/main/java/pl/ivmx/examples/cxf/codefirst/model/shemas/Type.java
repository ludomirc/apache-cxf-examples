package pl.ivmx.examples.cxf.codefirst.model.shemas;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@XmlRootElement
public class Type implements Serializable {


    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
