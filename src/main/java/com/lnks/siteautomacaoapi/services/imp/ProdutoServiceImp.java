package com.lnks.siteautomacaoapi.services.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lnks.siteautomacaoapi.entities.Produto;
import com.lnks.siteautomacaoapi.repositories.ProdutoRepository;
import com.lnks.siteautomacaoapi.services.ProdutoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProdutoServiceImp implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public Optional<Produto> buscarPorNome(String nomeProduto) {
		log.info("Buscando produto por nome {}", nomeProduto);		
		return Optional.ofNullable(produtoRepository.findByNomeProduto(nomeProduto));
	}

	@Override
	public Optional<Produto> salvarProduto(Produto produto) {
		log.info("Buscando produto por nome {}", produto.toString());		
		return Optional.ofNullable(produtoRepository.save(produto));
	}

	@Override
	public Page<Produto> buscarProdutos(PageRequest pageRequest) {
		log.info("Buscando todos os produtos");	
		return produtoRepository.findAll(pageRequest);
	}

}
