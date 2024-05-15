package net.cts.hms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	
	@Column(nullable=false, unique=true)
	private String lastName;
	
	@Column(nullable=false, unique=true)
//	private String username;
	
//	@Column(nullable=false, unique=true)
	private String emailId;
	
	@Column(nullable=false)
	private String password;
	
	private String role;
	
//	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinTable(name="users_roles",joinColumns= @JoinColumn(name="user_id",referencedColumnName="id"),
//	inverseJoinColumns =@JoinColumn(name="role_id", referencedColumnName ="id"))
//	
//	private Set<Role>roles;
	

}
