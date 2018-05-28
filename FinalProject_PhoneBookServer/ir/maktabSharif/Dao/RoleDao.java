package ir.maktabSharif.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ir.maktabSharif.Model.Role;
import ir.maktabSharif.Model.User;

public class RoleDao {
	
 final Session session=HibernateUtil.getHibernateSession();
	
	public boolean insert(Role role)
	{
		try {
			
			Transaction transaction=session.beginTransaction();
			session.save(role);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Role select(int roleId)
	{
		Transaction transaction=session.beginTransaction();
		Role selectRole=session.get(Role.class, roleId);
		transaction.commit();
		session.close();
		
		return selectRole;
	}

	
	public ArrayList<Role> selectAll()
	{
		Transaction transaction=session.beginTransaction();
		ArrayList<Role> roleList=(ArrayList<Role>) session.createQuery("from Role").list();
		transaction.commit();
		session.close();
		
		return roleList;
	}
	
	
	public void update(Role role,int roleId)
	{
		Transaction transaction=session.beginTransaction();
		Role _findrole=session.get(Role.class, roleId);
		_findrole.setFeatureList(role.getFeatureList());
		_findrole.setRoleName(role.getRoleName());
	
		session.update(_findrole);
		transaction.commit();
		session.close();
	}
	
	
	public void delete(int roleId)
	{
		Transaction transaction=session.beginTransaction();
		Role _findRoleForDelete=session.get(Role.class, roleId);
		session.delete(_findRoleForDelete);
		
		transaction.commit();
		session.close();
	}
}
