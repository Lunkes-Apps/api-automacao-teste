package com.lnks.siteautomacaoapi.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroProdutoDto {

	 @NotEmpty(message = "nome do produto não pode ser vazio")
	 @Length(min = 3, max = 200, message = "Nome do produto deve conter entre 3 a 200 letras")
	 private String nomeProduto;
	 
	 @NotEmpty(message = "descrição do produto não pode ser vazio")
	 @Length(min = 3, max = 200, message = "Descrição do produto deve conter entre 3 a 200 letras")
	 private String descricao;	    
	
}
