package com.equipe4.iesservice.ies;

import com.equipe4.iesservice.ies.dto.CriarIesDto;
import com.equipe4.iesservice.ies.dto.IesResponseDto;
import com.equipe4.iesservice.ies.endereco.EnderecoIes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IesService {

    private IesRepository iesRepository;

    public IesService(IesRepository iesRepository) {
        this.iesRepository = iesRepository;
    }

    public UUID criarIes(CriarIesDto dto) {
        var end = dto.endereco();
        EnderecoIes endereco = new EnderecoIes(end.rua(), end.numero(),
                end.complemento(), end.bairro(), end.cidade(), end.estado());
        IES ies = new IES(dto.nome(), endereco, dto.telefone());

        iesRepository.save(ies);

        return ies.getId();
    }

    public List<IesResponseDto> findAllIes() {
        return iesRepository.findAllIes();
    }
}
