package com.lnks.siteautomacaoapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnks.siteautomacaoapi.dtos.CadastroProdutoDto;
import com.lnks.siteautomacaoapi.dtos.CadastroUsuarioDto;
import com.lnks.siteautomacaoapi.entities.Produto;
import com.lnks.siteautomacaoapi.response.Response;
import com.lnks.siteautomacaoapi.services.ProdutoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/cadastrar-produto")
@CrossOrigin(origins = "*")
public class CadastroProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Response<CadastroProdutoDto>> cadastrar(
			@Valid @RequestBody CadastroProdutoDto cadastroProduto,
			BindingResult result){
	    Response<CadastroProdutoDto> response = new Response<CadastroProdutoDto>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		log.info("Salvando produto {}", cadastroProduto.toString());
		produtoService.salvarProduto(
				Produto.builder().nomeProduto(cadastroProduto.getNomeProduto())
				.descricao(cadastroProduto.getDescricao())
				.build());
				
		return ResponseEntity.ok(response);		
	}

}
