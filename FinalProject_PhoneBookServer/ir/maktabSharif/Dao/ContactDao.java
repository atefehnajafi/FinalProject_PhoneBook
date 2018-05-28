package ir.maktabSharif.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ir.maktabSharif.Model.Contact;


public class ContactDao {
	
	final Session session = HibernateUtil.getHibernateSession();
	
	public boolean insert(Contact contact)
	{final Session session = HibernateUtil.getHibernateSession();
		try {
			
			Transaction _transaction = session.beginTransaction();
			session.save(contact);
			_transaction.commit();
			 session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Contact select(int contactId)
	{
		Transaction _transaction = session.beginTransaction();
		Contact selectContact=session.get(Contact.class, contactId);
		_transaction.commit();
		session.close();
		
		return selectContact;
	}

	
	public ArrayList<Contact> selectAll()
	{
		Transaction _transaction = session.beginTransaction();
		ArrayList<Contact> contactList=(ArrayList<Contact>) session.createQuery("from Contact").list();
		_transaction.commit();
		session.close();
		
		return contactList;
	}
	
	
	public void update(Contact contact,int contactId)
	{
		Transaction _transaction = session.beginTransaction();
		Contact _findContact=session.get(Contact.class, contactId);
		_findContact.setName(contact.getName());
		_findContact.setFamily(contact.getFamily());
		_findContact.setEmail(contact.getEmail());
		_findContact.setMobile(contact.getMobile());
		_findContact.setPhone(contact.getPhone());
	
		
		session.update(_findContact);
		_transaction.commit();
		session.close();
	}
	
	
	public void delete(int contactId)
	{
		Transaction _transaction = session.beginTransaction();
		Contact _findContactForDelete=session.get(Contact.class, contactId);
		session.delete(_findContactForDelete);
		
		_transaction.commit();
		session.close();
	}


}
