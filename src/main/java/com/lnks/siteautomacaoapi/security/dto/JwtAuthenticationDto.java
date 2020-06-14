package com.lnks.siteautomacaoapi.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtAuthenticationDto {
	
	@NotEmpty(message = "Email não pode ser vazio.")
	@Email(message = "Email inválido.")
	private String email;
	@NotEmpty(message = "Senha não pode ser vazia.")
	private String senha;
	

}
