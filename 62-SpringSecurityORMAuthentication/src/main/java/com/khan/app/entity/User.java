package com.khan.app.entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_tbl")
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="uid")
	private Integer userId;
	@Column(name ="uname")
	private String userName;
	@Column(name ="uemail")
	private String userEmail;
	@Column(name ="upwd")
	private String userPassword;
	
	@Column(name ="urole")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="roles_tbl",
	joinColumns = @JoinColumn(name="uid"))
	private Set<String> userRoles;
}
