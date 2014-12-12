package pl.ivmx.examples.cxf.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
/**
 * @author bczaplicki@ivmx.pl, IVMX 2014.
 */
@Path("/carservice/")
@Produces("text/xml")
public interface CarServiceI {

    @POST
    @Path("/addcars/")
    Response addCars(CarCollection cars) throws Exception;

    @POST
    @Path("/addcar/")
    Integer addCar(Car car) throws Exception;

    @GET
    @Path("/getcars/")
    CarCollection getCars() throws Exception;

    @GET
    @Path("/getcar/{carId}/")
    Car getCar(@PathParam("carId") Integer carId) throws Exception;

}
