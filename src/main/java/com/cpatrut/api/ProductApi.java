package com.cpatrut.api;

import com.cpatrut.dto.ProductTO;
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

@Path(ProductApi.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Business", description = "Business Services API")
public interface ProductApi {
    String PATH = BusinessApi.PATH + "/services";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Uni<Response> save(@NotNull @Valid @RequestBody ProductTO service);
}
