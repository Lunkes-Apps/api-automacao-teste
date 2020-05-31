package com.lnks.siteautomacaoapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.lnks.siteautomacaoapi.entities.Produto;

public interface ProdutoService {
	
	/**
	 * 
	 * Função para buscar produtos por nome
	 * 
	 * @param nome
	 * @return Produto
	 */
	
	Optional<Produto> buscarPorNome(String nome);

	/**
	 * 
	 * Função para salvar um produto
	 * 
	 * @param produto
	 * @return
	 */
	
	Optional<Produto> salvarProduto(Produto produto);
	
	/**
	 * 
	 * Busca todos os produtos
	 * 
	 * @return Page<Produto>
	 */
	Page<Produto> buscarProdutos(PageRequest pageRequest);
}
