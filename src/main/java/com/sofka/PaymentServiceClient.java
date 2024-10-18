package com.sofka;


import com.sofka.dto.PaymentRequest;
import com.sofka.dto.ResponseData;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:3000/payment")
@Consumes(MediaType.APPLICATION_JSON)
public interface PaymentServiceClient {

    @POST
    ResponseData makePayment(PaymentRequest request);
}
