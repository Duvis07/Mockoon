package com.sofka;

import com.sofka.dto.PaymentRequest;
import com.sofka.dto.ResponseData;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/payment")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Controller {

    private final PaymentServiceClient paymentServiceClient;

    @Inject
    public Controller(@RestClient PaymentServiceClient paymentServiceClient) {
        this.paymentServiceClient = paymentServiceClient;
    }


    @POST
    public Response processPayment(PaymentRequest request) {
        try {
            ResponseData responseData = paymentServiceClient.makePayment(request);

            return Response.ok(responseData).build();

        } catch (WebApplicationException e) {
            String errorResponseBody = e.getResponse().readEntity(String.class);

            return Response.status(e.getResponse().getStatus())
                    .entity(errorResponseBody)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error inesperado: " + e.getMessage())
                    .build();
        }
    }
}
