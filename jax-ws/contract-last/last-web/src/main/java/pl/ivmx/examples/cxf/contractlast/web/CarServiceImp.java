package pl.ivmx.examples.cxf.contractlast.web;

import org.apache.log4j.Logger;
import pl.ivmx.examples.cxf.contractlast.model.CarService_I;
import pl.ivmx.examples.cxf.contractlast.model.shemas.Car;
import pl.ivmx.examples.cxf.contractlast.model.shemas.CarCollection;
import pl.ivmx.examples.cxf.contractlast.model.shemas.FaultInfo;
import pl.ivmx.examples.cxf.contractlast.model.shemas.GenException;
import pl.ivmx.examples.cxf.ejb.carservice.CarServiceEJB_I;

import javax.jws.WebService;
/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@WebService(
        targetNamespace = "http://service.cxf.examples.ivmx.pl/",
        serviceName = "CarService",
        portName = "CarServicePort"
)
public class CarServiceImp implements CarService_I {
    private final Logger log = Logger.getLogger(CarServiceImp.class);

    CarServiceEJB_I carServiceEjb = JndiUtils.getLocalEJB("java:global//carServiceEjb!pl.ivmx.examples.cxf.ejb.carservice.CarServiceEJB_I");

    @Override
    public void addCars(CarCollection cars) throws GenException {
        invokeMethodLog("addCars");
        if (cars == null) {
            throw new GenException("cars can't be null", getFaultInfo("cars"));
        }
    }

    @Override
    public Integer addCar(Car car) throws GenException {
        invokeMethodLog("addCarr");
        if (car == null) {
            throw new GenException("car can't be null", getFaultInfo("car"));
        }

        Integer carId = null;
        try {
            carId = carServiceEjb.addCar(car);
        } catch (Exception e) {
            log.error(e);
            GenException exception = new GenException("ejb error", e);
            throw exception;
        }
        return carId;
    }

    @Override
    public CarCollection getCars() throws GenException {
        invokeMethodLog("getCars");
        CarCollection collection = new CarCollection();

        try {
            collection = carServiceEjb.getCars();
        } catch (Exception e) {
            log.error(e);
            GenException exception = new GenException("ejb error", e);
            throw exception;
        }

        return collection;
    }

    @Override
    public Car getCar(Integer id) throws GenException {
        invokeMethodLog("getCar");
        if (id == null) {
            throw new GenException("id can't be null", getFaultInfo("id"));
        }

        Car car = new Car();

        try {
            car = carServiceEjb.getCar(id);
        } catch (Exception e) {
            log.error(e);
            GenException exception = new GenException("ejb error", e);
            throw exception;
        }

        return car;
    }

    private void invokeMethodLog(String methodName) {
        log.info("invoke webservice method:  " + methodName);
    }

    private FaultInfo getFaultInfo(String inputParameter) {
        FaultInfo faultInfo = new FaultInfo();
        faultInfo.setMessage("Input parameter" + inputParameter + "can't be null");
        return faultInfo;
    }
}
