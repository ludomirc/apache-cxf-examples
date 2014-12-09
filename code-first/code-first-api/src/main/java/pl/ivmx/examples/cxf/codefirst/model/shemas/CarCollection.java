package pl.ivmx.examples.cxf.codefirst.model.shemas;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@XmlRootElement
public class CarCollection implements Serializable{

    private Collection<Car> cars;

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }
}
