package pl.ivmx.examples.cxf.ejb.carservice;

import org.apache.log4j.Logger;
import pl.ivmx.examples.cxf.service.Car;
import pl.ivmx.examples.cxf.service.CarCollection;
import pl.ivmx.examples.cxf.service.ObjectFactory;
import pl.ivmx.examples.cxf.service.Type;


import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@Stateless(name = "carServiceFirstEjb", mappedName = "carServiceFirstEjb")
@Local(CarServiceEJB_I.class)
public class CarServiceImp implements CarServiceEJB_I {
    private final Logger log = Logger.getLogger(CarServiceImp.class);
    ObjectFactory oFactory = new ObjectFactory();

    @Override
    public void addCars(CarCollection collection) throws Exception {
        invokeMethodLog("addCars");
    }

    @Override
    public Integer addCar(Car car) throws Exception {
        invokeMethodLog("addCar");
        return 1;
    }

    @Override
    public CarCollection getCars() throws Exception {
        invokeMethodLog("getCars");

        List<Car> carList = new LinkedList<Car>();

        carList.add(getTestCar());
        carList.add(getTestCar());

        CarCollection carCollection = oFactory.createCarCollection();
        carCollection.getCars().addAll(carList);

        return carCollection;
    }

    @Override
    public Car getCar(Integer carId) throws Exception {
        invokeMethodLog("getCar");
        return getTestCar();
    }

    private Car getTestCar() {

        Car car = oFactory.createCar();
        car.setId(new Integer(1));
        car.setName("CAR 1");
        car.setBrand("HONDA");

        Type type = oFactory.createType();
        type.setId(1);
        type.setName("Sedan");

        car.setType(type);

        return car;
    }

    private void invokeMethodLog(String methodName) {
        log.info("invoke ejb service method:  " + methodName);
    }
}
