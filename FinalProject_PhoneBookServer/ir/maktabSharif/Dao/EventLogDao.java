package ir.maktabSharif.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ir.maktabSharif.Model.EventLog;
import ir.maktabSharif.Model.Role;

public class EventLogDao {
	
  final Session session=HibernateUtil.getHibernateSession();
  
  public boolean insert(EventLog eventlog)
	{
		try {
			Transaction _transaction=session.beginTransaction();
			session.save(eventlog);
			_transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public EventLog select(int logId)
	{
		Transaction _transaction=session.beginTransaction();
		EventLog selectEventLog=session.get(EventLog.class, logId);
		_transaction.commit();
		session.close();
		
		return selectEventLog;
	}

	
	public ArrayList<EventLog> selectAll()
	{
		Transaction _transaction=session.beginTransaction();
		ArrayList<EventLog> eventLogList=(ArrayList<EventLog>) session.createQuery("from EventLog").list();
		_transaction.commit();
		session.close();
		
		return eventLogList;
	}
	
	
	public void update(EventLog eventLog,int eventLogId)
	{
		Transaction _transaction=session.beginTransaction();
		EventLog _findEventLog=session.get(EventLog.class, eventLogId);
		
		_findEventLog.setLogType(eventLog.getLogType());
		_findEventLog.setEventDescription(eventLog.getEventDescription());
		
	
		
		session.update(_findEventLog);
		_transaction.commit();
		session.close();
	}
	
	
	public void delete(int eventLogId)
	{
		Transaction _transaction=session.beginTransaction();
		EventLog _findEventLogForDelete=session.get(EventLog.class, eventLogId);
		session.delete(_findEventLogForDelete);
		
		_transaction.commit();
		session.close();
	}
	
	
}
