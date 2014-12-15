package pl.ivmx.examples.cxf.ejb.carservice;

import org.apache.log4j.Logger;

import pl.ivmx.examples.cxf.contractlast.model.shemas.Car;
import pl.ivmx.examples.cxf.contractlast.model.shemas.CarCollection;
import pl.ivmx.examples.cxf.contractlast.model.shemas.Type;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@Stateless(name = "carServiceEjb", mappedName = "carServiceEjb")
@Local(CarServiceEJB_I.class)
public class CarServiceImp implements CarServiceEJB_I {
    private final Logger log = Logger.getLogger(CarServiceImp.class);

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

        CarCollection carCollection = new CarCollection();
        carCollection.setCars(carList);

        return carCollection;
    }

    @Override
    public Car getCar(Integer carId) throws Exception {
        invokeMethodLog("getCar");
        return getTestCar();
    }

    private Car getTestCar() {
        Car car = new Car();
        car.setId(new Integer(1));
        car.setName("CAR 1");
        car.setBrand("HONDA");

        Type type = new Type();

        type.setId(1);
        type.setName("Sedan");
        car.setType(type);

        return car;
    }

    private void invokeMethodLog(String methodName) {
        log.info("invoke ejb service method:  " + methodName);
    }
}
