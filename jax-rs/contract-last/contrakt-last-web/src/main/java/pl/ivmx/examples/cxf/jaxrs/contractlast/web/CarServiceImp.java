package pl.ivmx.examples.cxf.jaxrs.contractlast.web;

import org.apache.log4j.Logger;

import pl.ivmx.examples.cxf.ejb.CarServiceEJB_I;
import pl.ivmx.examples.cxf.service.Car;
import pl.ivmx.examples.cxf.service.CarCollection;
import pl.ivmx.examples.cxf.service.CarServiceI;

import javax.ws.rs.core.Response;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
public class CarServiceImp implements CarServiceI {

    private final Logger log = Logger.getLogger(CarServiceImp.class);

    protected CarServiceEJB_I carServiceEjb = JndiUtils.getLocalEJB("java:global//carServiceLastJaxRsEjb");

    @Override
    public Response addCars(CarCollection cars) throws Exception {
        invokeMethodLog("addCars");
        if (cars == null) {
            throw new Exception("id can't be null");
        }

        try {
            carServiceEjb.addCars(cars);

            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            Exception exception = new Exception("ejb error", e);
            throw exception;
        }
    }

    @Override
    public Integer addCar(Car car) throws Exception {
        invokeMethodLog("addCar");
        Integer carId = null;
        try {
            carId = carServiceEjb.addCar(car);
        } catch (Exception e) {
            log.error(e);
            Exception exception = new Exception("ejb error", e);
            throw exception;
        }
        return carId;
    }

    @Override
    public CarCollection getCars() throws Exception {
        invokeMethodLog("getCars");
        CarCollection collection = new CarCollection();

        try {
            collection = carServiceEjb.getCars();
        } catch (Exception e) {
            log.error(e);
            Exception exception = new Exception("ejb error", e);
            throw exception;
        }

        return collection;
    }

    @Override
    public Car getCar(Integer carId) throws Exception {
        invokeMethodLog("getCar");
        if (carId == null) {
            throw new Exception("id can't be null");
        }

        Car car = new Car();

        try {
            car = carServiceEjb.getCar(carId);
        } catch (Exception e) {
            log.error(e);
            Exception exception = new Exception("ejb error", e);
            throw exception;
        }
        return car;
    }

    private void invokeMethodLog(String methodName) {
        log.info("invoke jax-rs method:  " + methodName);
    }

}
