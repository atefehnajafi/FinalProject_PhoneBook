package ir.maktabSharif.Controller;

import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ir.maktabSharif.Dao.EventLogDao;
import ir.maktabSharif.Model.EventLog;


@Path("eventLog")
public class EventLogRestful {
	EventLog eventLog=new EventLog();
	EventLogDao eventLogDao=new EventLogDao();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(EventLog _eventLog)
	{
		boolean checkCreate=eventLogDao.insert(_eventLog);
		if(checkCreate == true) 
			return Response.status(200).entity("EventLog Register").build();
		else
			return Response.status(400).entity("Failed").build();
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EventLog> readAll()
	{
		ArrayList<EventLog> _eventLogs=new ArrayList<>();
		_eventLogs=eventLogDao.selectAll();
		
		return _eventLogs;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EventLog read(@PathParam("id") int eventLogId)
	{
		EventLog _eventLog=new EventLog();
		_eventLog=eventLogDao.select(eventLogId);
		
		return _eventLog;
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int _eventLogId , EventLog _eventLog)
	{
		eventLogDao.update(_eventLog, _eventLogId);
		return Response.status(200).entity("update successful").build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int _eventLogId)
	{
		eventLogDao.delete(_eventLogId);
		return Response.status(200).entity("Delete successful").build();
	}
}









