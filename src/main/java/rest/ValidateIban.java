package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import iban.Iban;
import iban.IbanCheck;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by andrius on 23/03/2017.
 */
@Path("/validate")
public class ValidateIban {

    @GET
    @Path("{iban}")
    @Produces(MediaType.APPLICATION_JSON)
    public String validate(@PathParam("iban") String ibanStr) {

        return new IbanCheck().validateIban(ibanStr).build().toString();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String validateList(@QueryParam("iban") final List<String> list) {

        return new IbanCheck().validateList(list.toArray(new String[list.size()]));

    }

}
