package com.cpatrut.api;

import com.cpatrut.dto.BusinessTO;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(BusinessApi.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Business", description = "Business API")
public interface BusinessApi {
    String PATH = "businesses";

    @POST
    Uni<Response> save(@NotNull @Valid @RequestBody BusinessTO businessSave);
}
