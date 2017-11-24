package utng.jsf.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import utng.jsf.entities.SecurityRole;

public class SecurityRoleRepository {
	private EntityManager entityManager;

	public SecurityRoleRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public SecurityRole search(Long id) {
		return entityManager.find(SecurityRole.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<SecurityRole> getSecurityRoles(){
		return entityManager.createNamedQuery("SecurityRole.findAll").getResultList();
	}
}
