package com.equipe4.iesservice.ies;

import com.equipe4.iesservice.ies.dto.CriarIesDto;
import com.equipe4.iesservice.ies.dto.IesResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ies")
public class IesController {

    private IesService iesService;

    public IesController(IesService iesService) {
        this.iesService = iesService;
    }

    @PostMapping("/criar-ies")
    public ResponseEntity<UUID> criarIes(@RequestBody CriarIesDto dto) {
        var id = iesService.criarIes(dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<IesResponseDto>> findAllIes() {
        return ResponseEntity.ok(iesService.findAllIes());
    }
}
