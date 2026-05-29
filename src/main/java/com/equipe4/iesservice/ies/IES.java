package com.equipe4.iesservice.ies;

import com.equipe4.iesservice.ies.endereco.EnderecoIes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_ies")
@Getter
@Setter
@NoArgsConstructor
public class IES {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    @Embedded
    private EnderecoIes endereco;

    private String telefone;

    public IES(String nome, EnderecoIes endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
