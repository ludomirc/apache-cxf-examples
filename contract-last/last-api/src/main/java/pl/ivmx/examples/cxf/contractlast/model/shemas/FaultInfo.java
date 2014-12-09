package pl.ivmx.examples.cxf.contractlast.model.shemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultInfo", propOrder = {"message"})
public class FaultInfo {

    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}



