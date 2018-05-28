package ir.maktabSharif.Controller;

import java.lang.annotation.Repeatable;
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

import ir.maktabSharif.Dao.RoleDao;
import ir.maktabSharif.Model.EventLog;
import ir.maktabSharif.Model.Role;


@Path("role")
public class RoleRestful {

	Role role = new Role();
	RoleDao roleDao = new RoleDao();

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Role _role) {
		boolean checkCreate = roleDao.insert(_role);
		if (checkCreate == true)
			return Response.status(200).entity("Role Register").build();
		else
			return Response.status(400).entity("Failed").build();
	}
	
	
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Role> readAll()
	{
		ArrayList<Role> _roles=new ArrayList<>();
		_roles=roleDao.selectAll();
		
		return _roles;
	}
	
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role read(@PathParam("id") int roleId)
	{
		Role _role=new Role();
		_role=roleDao.select(roleId);
		
		return _role;
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int _roleId , Role _role)
	{
		roleDao.update(_role, _roleId);
		return Response.status(200).entity("update successful").build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int _roleId)
	{
		roleDao.delete(_roleId);
		return Response.status(200).entity("Delete successful").build();
	}
	
}
