package com.lnks.siteautomacaoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lnks.siteautomacaoapi.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Transactional(readOnly = true)
	Produto findByNomeProduto(String nomeProduto);
	
}
