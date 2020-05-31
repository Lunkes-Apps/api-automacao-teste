package com.lnks.siteautomacaoapi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import com.lnks.siteautomacaoapi.entities.Produto;
import com.lnks.siteautomacaoapi.repositories.ProdutoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTest {
	
	@MockBean
	private ProdutoRepository produtoRepository; 
	
	@Autowired
	private ProdutoService produtoService;
	
	private static final String NOME_PRODUTO = "Produto do mercado - marca X";

	@BeforeEach
	public void setUp() {
		BDDMockito.given(this.produtoRepository.findByNomeProduto(Mockito.anyString()))
		.willReturn(new Produto());
		BDDMockito.given(this.produtoRepository.save(Mockito.any(Produto.class)))
		.willReturn(new Produto());
		BDDMockito.given(this.produtoRepository.findAll(Mockito.any(PageRequest.class)))
		.willReturn(new PageImpl<Produto>(new ArrayList<Produto>()));
	}
	
	@Test
	public void testBuscarProdutoPorNome() {
		Optional<Produto> produto = produtoService.buscarPorNome(NOME_PRODUTO);
		assertTrue(produto.isPresent());
	}
	
	@Test
	public void testSalvarProduto() {
		Optional<Produto> produto = produtoService.salvarProduto(new Produto());
		assertTrue(produto.isPresent());
	}
	
	@Test
	public void testBuscarProdutos() {
		Page<Produto> produtos = produtoService.buscarProdutos(PageRequest.of(0, 10)); 
		assertNotNull(produtos);
	}
	
}
