package com.lnks.siteautomacaoapi.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import com.lnks.siteautomacaoapi.dtos.CadastroUsuarioDto;
import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.response.Response;
import com.lnks.siteautomacaoapi.services.ProfileService;
import com.lnks.siteautomacaoapi.utils.PasswordUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/cadastrar-usuario")
@CrossOrigin(origins = "*")
public class CadastroUsuarioController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<Response<CadastroUsuarioDto>> cadastrar(
            @Valid @RequestBody CadastroUsuarioDto cadastroUsuarioDto, BindingResult result)
            throws NoSuchAlgorithmException {
        log.info("Cadastrando Usuario:{}", cadastroUsuarioDto.toString());
        Response<CadastroUsuarioDto> response = new Response<CadastroUsuarioDto>();
        validarUsuario(cadastroUsuarioDto, result);
     
        if(result.hasErrors()){
            log.error("Erro na validação do cadastro do usuario: {}", result.getAllErrors());
            result.getAllErrors().forEach(erro -> {
            	if(response == null) {
            		log.info("erro esta null");
            	}else {
            		log.info("erro nao esta null");
            	}
            	response.getErrors().add(erro.getDefaultMessage());
            	log.info(erro.getDefaultMessage());
            });
            log.info("Erros adicionados {}", response.getErrors());
            return ResponseEntity.badRequest().body(response);
        }
        
        Profile novoProfile = Profile.builder()
            .nome(cadastroUsuarioDto.getNome())
            .email(cadastroUsuarioDto.getEmail())
            .password(PasswordUtils.gerarBCrypt(cadastroUsuarioDto.getSenha()))
            .build();

        log.info("salvando...");
        this.profileService.salvarProfile(novoProfile);
        log.info("profile foi salvo...");
        response.setData(cadastroUsuarioDto);
        return ResponseEntity.ok(response);
    }

    private void validarUsuario(CadastroUsuarioDto cadastroUsuarioDto, BindingResult result) {
        log.info("Verificando email {}", cadastroUsuarioDto.getEmail());
        this.profileService.buscarPorEmail(cadastroUsuarioDto.getEmail())
                .ifPresent(perfil -> result.addError(new ObjectError("email", "email já cadastrado")));    
    }
}