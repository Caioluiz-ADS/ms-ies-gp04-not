package com.equipe4.iesservice.ies.dto;

import java.util.UUID;

public record IesResponseDto(UUID id, String nome, String telefone, String rua, String numero, String cidade, String estado) {
}
