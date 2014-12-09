package pl.ivmx.examples.cxf.codefirst.model.shemas;

import javax.xml.ws.WebFault;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@WebFault(name = "GenException")
public class GenException extends Exception {

    private FaultInfo genException;

    public GenException() {
        super();
    }

    public GenException(String message) {
        super(message);
    }

    public GenException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenException(String message, FaultInfo genException) {
        super(message);
        this.genException = genException;
    }

    public GenException(String message, FaultInfo genException, Throwable cause) {
        super(message, cause);
        this.genException = genException;
    }

    public FaultInfo getFaultInfo() {
        return this.genException;
    }
}
