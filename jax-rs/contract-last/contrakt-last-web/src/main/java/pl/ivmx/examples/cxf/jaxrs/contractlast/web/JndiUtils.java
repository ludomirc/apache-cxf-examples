package pl.ivmx.examples.cxf.jaxrs.contractlast.web;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
public class JndiUtils {

    private static final Logger log = Logger.getLogger(JndiUtils.class);
    /**
     * Gets local EJB from JNDI.
     *
     * @param jndiName JNDI constant name to look up for EJB
     * @param <T> generic object
     * @return local EJB object loaded from JNDI
     */
    public static <T> T getLocalEJB(String jndiName) {
        try {
            InitialContext context = new InitialContext();
            return (T) context.lookup(jndiName);
        } catch (NamingException e) {
            log.error("Naming exception occurred while trying to load EJB from JNDI with JNDI name: " + jndiName, e);
            throw new RuntimeException("Naming exception occurred while trying to load EJB from JNDI with JNDI name: " + jndiName, e);
        }
    }
}