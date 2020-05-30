package com.lnks.siteautomacaoapi.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CadastroUsuarioDto {

    private Long id;

    @NotEmpty(message = "nome não pode ser vazio")
    @Length(min = 3, max = 200, message = "Nome não pode conter entre 3 a 200 letras")
    private String nome;
    
    @NotEmpty(message = "email não pode ser vazio")
    @Length(min = 5, max = 200, message = "Email não pode conter entre 5 a 200 letras")
    @Email(message="email inválido")
    private String email;

    @NotEmpty(message = "senha não pode ser vazia")
    private String senha;
    private String telefone;
    private String endereco;

}