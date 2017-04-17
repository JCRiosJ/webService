package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("RestService")
public class RestWS {

    @Context
    private UriInfo context;

    public RestWS() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //TODO return proper representation object
        return ".";
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putXml(String content) {
        String txt = new String(".");
    }
    
    @GET
    @Path("/contertirDivisa/moneda={moneda}&cantidad={cantidad}")
    @Produces(MediaType.TEXT_PLAIN)
    public String convertirDivisa(@PathParam("moneda")String moneda, @PathParam("cantidad") String cantidad){
        Double valor = new Double(cantidad == null || cantidad.isEmpty() ? "0.0" : cantidad);
        System.out.println(cantidad);
        switch(moneda)
        {
            case "euro":
                valor = valor * 0.050;
                break;
            case "dolar":
                valor = valor * 0.053;
                break;
            default:
                break;
        }
        return valor.toString();
    }
}
