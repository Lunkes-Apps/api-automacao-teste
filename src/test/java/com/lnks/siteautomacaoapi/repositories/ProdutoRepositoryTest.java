package com.lnks.siteautomacaoapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.lnks.siteautomacaoapi.entities.Produto;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private static final String PRODUTO_NOME = "Produto teste";
	private static final String PRODUTO_DESCRICAO = "Produto para teste unitário do site em desenvolvimento";

	@BeforeEach
	public void setUp() {
		Produto produto = produtoRepository.save(Produto.builder()
				.nomeProduto(PRODUTO_NOME)
				.descricao(PRODUTO_DESCRICAO)
				.build());
		log.info("Testando salvar produto {}", produto.toString());
	}
	
	@Test
	public void testBuscarPorNome() {
		Produto produto = produtoRepository.findByNomeProduto(PRODUTO_NOME);
		log.info("Testando com o produto {}",produto.toString());
		assertEquals(PRODUTO_NOME, produto.getNomeProduto());
	}
	
	
}
