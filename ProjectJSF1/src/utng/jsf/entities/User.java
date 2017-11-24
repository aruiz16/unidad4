package utng.jsf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="tblUser")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM user u"),
	@NamedQuery(name="User.findAll", query="SELECT COUNT(u) FROM user u")
})
public class User implements Serializable{
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=70)
	private String name;
	
	@Column(length=10,nullable=false)
	private String login;
	
	@Column(length=30,nullable=false)
	private String password;
	
	@Column(nullable=false)
	private int age;
	
	@OneToOne @JoinColumn(name="role_id")
	private SecurityRole role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SecurityRole getRole() {
		return role;
	}

	public void setRole(SecurityRole role) {
		this.role = role;
	}
	
	
}
