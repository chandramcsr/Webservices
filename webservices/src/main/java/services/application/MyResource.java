package services.application;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import services.application.model.Message;
import services.application.model.MyResourceBean;
import services.application.service.MessageServices;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	MessageServices service=new MessageServices();
	
    //================================GET=====================================
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId) {
    	
    	return service.getMessage(messageId);
    }
    
    //=============================POST========================================
    
    @POST
    
    public Message addMessage(Message message) {
    	
    	return service.addMessage(message);
    }
    
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId,Message message) {
    	
    	message.setId(messageId);
    	return service.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long messageId) {
    	
    	service.deleteMessage(messageId);
    }
    
    //================(@QueryParam Pagination & Filtering========================
    	
    @GET
    public List<Message> getAllMessages(@BeanParam MyResourceBean bean) {
           
    	if(bean.getYear() >0) {
    		
    		return service.getAllMessgaesForYear(bean.getYear());
    	}
    	
    	if(bean.getStart() >=0 && bean.getEnd() >=0) {
    		return service.getAllMessagesInRange(bean.getStart(), bean.getEnd());
    	}
    	return service.getAllMessgaes();
    } 
    
}
