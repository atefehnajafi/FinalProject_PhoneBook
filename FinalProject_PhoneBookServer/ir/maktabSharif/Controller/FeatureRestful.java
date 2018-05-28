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

import ir.maktabSharif.Dao.FeatureDao;
import ir.maktabSharif.Model.EventLog;
import ir.maktabSharif.Model.Feature;

@Path("feature")
public class FeatureRestful {

	Feature feature=new Feature();
	FeatureDao featureDao=new FeatureDao();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Feature _feature)
	{
		boolean checkCreate=featureDao.insert(_feature);
		if(checkCreate == true)
			return Response.status(200).entity("Feature Register").build();
		else
			return Response.status(400).entity("Failed").build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Feature> readAll()
	{
		ArrayList<Feature> _features=new ArrayList<>();
		_features=featureDao.selectAll();
		
		return _features;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Feature read(@PathParam("id") int _featureId)
	{
		Feature _feature=new Feature();
		_feature=featureDao.select(_featureId);
		
		return _feature;
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int _featureId , Feature _feature)
	{
		featureDao.update(_feature, _featureId);
		return Response.status(200).entity("update successful").build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int _featureId )
	{
		featureDao.delete(_featureId);
		return Response.status(200).entity("Delete successful").build();
	}
	
}
