package com.interview.technical.mavha.controller;

import com.interview.technical.mavha.dto.PersonRequest;
import com.interview.technical.mavha.dto.PersonResponse;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("person")
@Api("Person")
@Produces(MediaType.APPLICATION_JSON)
public interface PersonController extends BaseController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<PersonResponse> readAllPersons();

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    PersonResponse createPerson(@NotNull @PathParam("id") Long id,
                                @NotNull @Valid PersonRequest personRequest);

}
