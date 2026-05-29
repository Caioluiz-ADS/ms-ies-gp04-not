package com.equipe4.iesservice.ies;

import com.equipe4.iesservice.ies.dto.IesResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IesRepository extends JpaRepository<IES, UUID> {

    @Query("""
            select new com.equipe4.iesservice.ies.dto.IesResponseDto(i.id, i.nome, i.telefone, i.endereco.rua, i.endereco.numero, i.endereco.cidade, i.endereco.estado)
            from IES i
            """)
    List<IesResponseDto> findAllIes();
}
