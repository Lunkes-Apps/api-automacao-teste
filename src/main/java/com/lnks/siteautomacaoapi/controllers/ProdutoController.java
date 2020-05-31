package com.lnks.siteautomacaoapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lnks.siteautomacaoapi.dtos.ProdutoDto;
import com.lnks.siteautomacaoapi.entities.Produto;
import com.lnks.siteautomacaoapi.response.Response;
import com.lnks.siteautomacaoapi.services.ProdutoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/produtos")
@Slf4j
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@GetMapping(value="")
	public ResponseEntity<Response<Page<ProdutoDto>>> listarProdutos(
			@RequestParam(value= "pag", defaultValue= "0") int pag,
			@RequestParam(value= "ord", defaultValue= "id") String ord,
			@RequestParam(value= "dir", defaultValue= "DESC") String dir){
		
		Response<Page<ProdutoDto>> response = new Response<Page<ProdutoDto>>();
		
		PageRequest pageRequest = PageRequest.of(pag, this.qtdPorPagina, Direction.valueOf(dir), ord);  
		Page<Produto> produtos = this.produtoService.buscarProdutos(pageRequest); 
		Page<ProdutoDto> produtosDto = produtos.map(produto -> this.converterParaProdutoDto(produto));
		
		response.setData(produtosDto);
		return ResponseEntity.ok(response);
	}
	
	private ProdutoDto converterParaProdutoDto(Produto produto) {
		return ProdutoDto.builder()
		.nomeProduto(produto.getNomeProduto())
		.descricao(produto.getDescricao()).build();
	}
	

}
