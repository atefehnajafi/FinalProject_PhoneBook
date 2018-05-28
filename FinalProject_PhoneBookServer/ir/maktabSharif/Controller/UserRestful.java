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

import org.apache.log4j.Logger;

import ir.maktabSharif.Dao.EventLogDao;
import ir.maktabSharif.Dao.UserDao;
import ir.maktabSharif.Dto.UserDto;
import ir.maktabSharif.Model.EventLog;
import ir.maktabSharif.Model.User;

@Path("user")
public class UserRestful {
	User user = new User();
	UserDao userDao = new UserDao();
	
	
	
	private final static Logger logger=Logger.getLogger(UserRestful.class);
	EventLog _eventLog=new EventLog();
	EventLogDao _eventLogDao=new EventLogDao();
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User _user) {
		boolean checkCreate = userDao.insert(_user);
		if (checkCreate == true)
			return Response.status(200).entity("User Register").build();
		else
			return Response.status(400).entity("Fail").build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		User _userLogin = userDao.getUserByUserPass(user);
		
		if (_userLogin != null)
			return Response.status(200).entity("{ OK : true, message : \"user login\"}").build();
		else
		{
			return Response.status(400).entity("{ Error : false, message : \"login Failed\"}").build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> readAll() {
		ArrayList<User> _users = new ArrayList<>();
		_users = userDao.selectAll();

		return _users;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User read(@PathParam("id") int userId) {
		User _user = new User();
		_user = userDao.select(userId);

		return _user;
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int userId, User _user) {
		userDao.update(_user, userId);
		return Response.status(200).entity("update successful").build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int userId) {
		userDao.delete(userId);
		return Response.status(200).entity("Delete successful").build();
	}

}
