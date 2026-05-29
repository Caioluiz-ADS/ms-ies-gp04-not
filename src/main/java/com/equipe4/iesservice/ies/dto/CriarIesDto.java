package com.equipe4.iesservice.ies.dto;

import com.equipe4.iesservice.ies.endereco.EnderecoIesDto;

public record CriarIesDto(String nome, EnderecoIesDto endereco, String telefone) {
}
