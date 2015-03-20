package pl.ivmx.examples.cxf.jaxrs.contractfirst.web;

import org.apache.log4j.Logger;
import pl.ivmx.examples.cxf.common.ejbtool.JndiUtils;
import pl.ivmx.examples.cxf.service.CarService;
import pl.ivmx.examples.cxf.service.ejb.CarServiceEJB_I;
import pl.ivmx.examples.cxf.service.schema.Car;
import pl.ivmx.examples.cxf.service.schema.CarCollection;


import javax.ws.rs.core.Response;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
public class CarServiceImp implements CarService {

    private final Logger log = Logger.getLogger(CarServiceImp.class);

    protected CarServiceEJB_I carServiceEjb = JndiUtils.getLocalEJB("java:global//carServiceFirstRestEjb");

    @Override
    public int addCar(Car car) {
        invokeMethodLog("addCar");

        if (car == null) {
            throw new RuntimeException("parameter car can't be empty");
        }

        int response = -1;
        try {
            response = carServiceEjb.addCar(car);
        } catch (Exception e) {
            throw new RuntimeException("ejb error", e);
        }

        return response;
    }

    @Override
    public Response addCars(CarCollection carcollection) {
        invokeMethodLog("addCars");
        if (carcollection == null || carcollection.getCars().isEmpty()) {
            throw new RuntimeException("parameter carcollection can't be empty");
        }

        try {
            carServiceEjb.addCars(carcollection);

            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            throw new RuntimeException("ejb error", e);
        }
    }

    @Override
    public Car getCar(int carId) {
        invokeMethodLog("getCar");
        if (carId == 0) {
            throw new RuntimeException("carId can't be 0");
        }

        Car car = new Car();

        try {
            car = carServiceEjb.getCar(carId);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException("ejb error", e);
        }
        return car;
    }

    @Override
    public CarCollection getCars() {
        invokeMethodLog("getCars");
        CarCollection carCollection = null;
        try {
            carCollection = carServiceEjb.getCars();
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException("ejb error", e);
        }
        return carCollection;
    }

    private void invokeMethodLog(String methodName) {
        log.info("invoke jax-rs method:  " + methodName);
    }

}
