package com.cvaldiviape.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.cvaldiviape.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_usuario") 
public class TbUser extends BaseEntity {
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "tb_users_roles", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"), 
									    inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"))
	private Set<TbRole> roles = new HashSet<>();

}