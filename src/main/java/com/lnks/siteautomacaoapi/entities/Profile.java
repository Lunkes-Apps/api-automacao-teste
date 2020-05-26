package com.lnks.siteautomacaoapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "perfil")
@Data
public class Profile implements Serializable {

	private static final long serialVersionUID = 3827663714334497998L;

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	private @Column(name = "nome", nullable = false) String nome;
	private @Column(name = "email", nullable = false) String email;
	private @Column(name = "password", nullable = false) String password;

}
