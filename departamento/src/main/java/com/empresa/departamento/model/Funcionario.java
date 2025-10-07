package com.empresa.departamento.model;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String email;
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
