package ir.maktabSharif.Dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ir.maktabSharif.Model.EventLog;
import ir.maktabSharif.Model.Feature;

public class FeatureDao {

	  final Session session=HibernateUtil.getHibernateSession();
	
	public boolean insert(Feature feature)
	{
		try {
			Transaction _transaction=session.beginTransaction();
			session.save(feature);
			_transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Feature select(int featureId)
	{
		Transaction _transaction=session.beginTransaction();
		Feature selectFeature=session.get(Feature.class, featureId);
		_transaction.commit();
		session.close();
		
		return selectFeature;
	}

	
	public ArrayList<Feature> selectAll()
	{
		Transaction _transaction=session.beginTransaction();
		ArrayList<Feature> featureList=(ArrayList<Feature>) session.createQuery("from Feature").list();
		_transaction.commit();
		session.close();
		
		return featureList;
	}
	
	
	public void update(Feature feature,int featureId)
	{
		Transaction _transaction=session.beginTransaction();
		Feature _findFeature=session.get(Feature.class, featureId);
		
		_findFeature.setFeatureDescription(feature.getFeatureDescription());
		
		session.update(_findFeature);
		_transaction.commit();
		session.close();
	}
	
	
	public void delete(int featureId)
	{
		Transaction _transaction=session.beginTransaction();
		Feature _findfeatureForDelete=session.get(Feature.class, featureId);
		session.delete(_findfeatureForDelete);
		
		_transaction.commit();
		session.close();
	}
	
}
