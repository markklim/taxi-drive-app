package com.markklim.taxi.drive.app.api.controller

import com.markklim.taxi.drive.app.dao.entity.Ride
import com.markklim.taxi.drive.app.service.ClientManagementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Controller
@Path('api')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ClientManagementController {

    @Autowired
    @Delegate
    ClientManagementService clientManagementService

    @GET
    @Path('client/check/{id}')
    checkUserById(@PathParam('id') String id) {
        checkClient(id)
    }

    @POST
    @Path('ride/evaluate')
    getPrice(Ride ride) {
        try {
            [status: "OK",
             price: calculatePrice(ride)]
        } catch (IllegalArgumentException e) {
            [status: "ERROR",
             message: e.message]
        }
    }

    @POST
    @Path('ride/new')
    addNewRide(Ride ride) {
        clientManagementService.addNewRide(ride)
    }

    @GET
    @Path('ride/active')
    getActiveRides() {
        clientManagementService.getActiveRides()
    }
}
