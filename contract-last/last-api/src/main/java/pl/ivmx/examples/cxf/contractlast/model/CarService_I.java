package pl.ivmx.examples.cxf.contractlast.model;

import pl.ivmx.examples.cxf.contractlast.model.shemas.Car;
import pl.ivmx.examples.cxf.contractlast.model.shemas.CarCollection;
import pl.ivmx.examples.cxf.contractlast.model.shemas.GenException;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@WebService(
        targetNamespace = "http://service.cxf.examples.ivmx.pl/",
        serviceName = "CarService",
        portName = "CarServicePort"
)
public interface CarService_I {

    @WebResult(name = "document")
    void addCars(@WebParam(name = "cars")CarCollection collection) throws GenException;

    @WebResult(name = "document")
    Integer addCar(@WebParam(name = "car") Car car) throws GenException;

    @WebResult(name = "document")
    CarCollection getCars() throws GenException;

    @WebResult(name = "document")
    Car getCar(@WebParam(name = "carId") Integer carId) throws GenException;

}
