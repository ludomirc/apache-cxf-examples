import pl.ivmx.examples.cxf.first.client.model.*;

import javax.xml.namespace.QName;
import java.net.URL;

/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
public class TestClient {
    private static final QName SERVICE_NAME = new QName("http://service.cxf.examples.ivmx.pl/", "CarService");


    public static void main(String args[]) throws Exception {
        URL wsdlURL = new URL("http://localhost:8080/services/car_service");


        CarService ss = new CarService(wsdlURL);
        CarServiceI port = ss.getCarServicePort();

        /** another method invoke service
         *  CarServiceService ss = new CarServiceService();
         *  CarService port = ss.getCarServicePort();
         *
         *  String endpointURL = "http://localhost:8080/services/car_service";
         *  BindingProvider bp = (BindingProvider) port;
         *  bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
         */

        {
            System.out.println("Invoking getCar...");
            Integer _getCar_carId = 1;
            try {
                pl.ivmx.examples.cxf.first.client.model.Car _getCar__return = port.getCar(_getCar_carId);
                System.out.println("getCar.result=" + _getCar__return);

            } catch (GenException e) {
                System.out.println("Expected exception: GenException has occurred.");
                System.out.println(e.toString());
            }
        }
        {
            System.out.println("Invoking getCars...");
            try {
                pl.ivmx.examples.cxf.first.client.model.CarCollection _getCars__return = port.getCars();
                System.out.println("getCars.result=" + _getCars__return);

            } catch (GenException e) {
                System.out.println("Expected exception: GenException has occurred.");
                System.out.println(e.toString());
            }
        }
        {
            System.out.println("Invoking addCar...");
            Car _addCar_car = getCar();

            try {
                Integer _addCar__return = port.addCar(_addCar_car);
                System.out.println("addCar.result=" + _addCar__return);

            } catch (GenException e) {
                System.out.println("Expected exception: GenException has occurred.");
                System.out.println(e.toString());
            }
        }
        {
            System.out.println("Invoking addCars...");
            pl.ivmx.examples.cxf.first.client.model.CarCollection _addCars_cars = new CarCollection();
            _addCars_cars.getCars().add(getCar());
            try {
                port.addCars(_addCars_cars);

            } catch (GenException e) {
                System.out.println("Expected exception: GenException has occurred.");
                System.out.println(e.toString());
            }
        }

        System.exit(0);
    }

    private static Car getCar() {
        Car _addCar_car = new Car();
        _addCar_car.setId(1);
        _addCar_car.setBrand("VW");
        _addCar_car.setName("Passat");

        Type type = new Type();
        type.setId(1);
        type.setName("sedan");
        _addCar_car.setType(type);
        return _addCar_car;
    }

}
