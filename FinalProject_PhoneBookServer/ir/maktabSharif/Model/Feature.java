package ir.maktabSharif.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="featuretable")
public class Feature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="featureId")
	private int featureId;
	
	
	@Column(name="featureDescription")
	private String featureDescription;
	
	
	public Feature() {
		
	}
	
	
	public Feature(String featureDescription) {
		this.featureDescription=featureDescription;
	}


	public int getFeatureId() {
		return featureId;
	}


	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}


	public String getFeatureDescription() {
		return featureDescription;
	}


	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}
	
	
	
	
	
}
