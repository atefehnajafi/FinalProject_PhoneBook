package ir.maktabSharif.Dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ir.maktabSharif.Controller.UserRestful;
import ir.maktabSharif.Dto.UserDto;
import ir.maktabSharif.Model.EventLog;
import ir.maktabSharif.Model.User;

public class UserDao {

	final Session session = HibernateUtil.getHibernateSession();

	private final static Logger logger = Logger.getLogger(UserRestful.class);
	EventLog _eventLog = new EventLog();
	EventLogDao _eventLogDao = new EventLogDao();

	public boolean insert(User user) {
		try {
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUserByUserPass(User user) {

		logger.info(user);

		Transaction transaction = null;
		User _user = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"from User where username='" + user.getUsername() + "' and password='" + user.getPassword() + "' ");
			_user = (User) query.uniqueResult();
			logger.error(_user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return _user;
	}

	public User select(int userId) {
		Transaction transaction = session.beginTransaction();
		User selectUser = session.get(User.class, userId);
		transaction.commit();
		session.close();

		return selectUser;
	}

	public ArrayList<User> selectAll() {
		Transaction transaction = session.beginTransaction();
		ArrayList<User> userList = (ArrayList<User>) session.createQuery("from User").list();
		transaction.commit();
		session.close();

		return userList;
	}

	public void update(User user, int userId) {
		Transaction transaction = session.beginTransaction();
		User _findUser = session.get(User.class, userId);
		_findUser.setUsername(user.getUsername());
		_findUser.setPassword(user.getPassword());
		_findUser.setRole(user.getRole());

		session.update(_findUser);
		transaction.commit();
		session.close();
	}

	public void delete(int userId) {
		Transaction transaction = session.beginTransaction();
		User _findUserForDelete = session.get(User.class, userId);
		session.delete(_findUserForDelete);

		transaction.commit();
		session.close();
	}

}
