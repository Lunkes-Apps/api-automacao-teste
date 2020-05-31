package com.lnks.siteautomacaoapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7112831706105470669L;
	
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	private @Column(name = "nome_produto", nullable = false) String nomeProduto;
	private @Column(name = "descricao", nullable = false) String descricao;
		

}
