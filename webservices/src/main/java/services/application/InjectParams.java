package services.application;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectParams")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectParams {

	@GET
	@Path("/param")
	public String getParamsUsingAnnotaions(@MatrixParam("name")  String matrixParam,
										   @HeaderParam("header") String headerParam,
										   @CookieParam("cookie") String cookieParam) {
		return "Matrix Param: " + matrixParam+ " Header Param" + headerParam+ "Cookie Param" + cookieParam;
	}
	
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo) {
		
		String path=uriInfo.getAbsolutePath().toString();
		return path;
	}
}
