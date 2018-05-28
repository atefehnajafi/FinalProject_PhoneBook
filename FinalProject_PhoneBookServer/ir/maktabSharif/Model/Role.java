package ir.maktabSharif.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roletable")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
	private int roleId;
	
	@Column(name="roleName")
	private String roleName;
	
	
	@ManyToMany
	@JoinColumn(name="featureId")
	private Set<Feature> featureList=new HashSet<Feature>();

	
	public Role() {
		
	}
	
	public Role(String roleName,Set<Feature> featureList) {
		this.featureList=featureList;
		this.roleName=roleName;
	}

	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<Feature> getFeatureList() {
		return featureList;
	}


	public void setFeatureList(Set<Feature> featureList) {
		this.featureList = featureList;
	}
	
	
	

}
