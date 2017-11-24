package utng.jsf.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import utng.jsf.entities.SecurityRole;
import utng.jsf.repositories.SecurityRoleRepository;

@ManagedBean
public class SecurityRoleBean {
	
	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;
	
	private List<SecurityRole> securityRole = null;
	
	public List<SecurityRole> getSecurityRole(){
		if(this.securityRole == null) {
			SecurityRoleRepository repository = new SecurityRoleRepository(entityManager);
			this.securityRole = repository.getSecurityRoles();
		}
		return this.securityRole;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
