package pl.ivmx.examples.cxf.ejb.carservice;

import pl.ivmx.examples.cxf.contractlast.model.shemas.Car;
import pl.ivmx.examples.cxf.contractlast.model.shemas.CarCollection;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
public interface CarServiceEJB_I {

    void addCars(CarCollection collection) throws Exception;

    Integer addCar(Car car) throws Exception;

    CarCollection getCars() throws Exception;

    Car getCar(Integer carId) throws Exception;

}
