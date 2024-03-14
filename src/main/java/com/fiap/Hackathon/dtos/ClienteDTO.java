package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private String paisOrigem;

    @JsonProperty
    @CPF
    @NotBlank(message = "CPF do Cliente é um campo obrigatório e não pode estar em branco")
    private String cpf;

    @JsonProperty
    private String passaporte;

    @JsonProperty
    @NotBlank(message = "Nome do Cliente é um campo obrigatório e não pode estar em branco")
    private String nomeCompleto;

    @JsonProperty
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonProperty
    private String enderecoPaisOrigem;

    @JsonProperty
    private String telefone;

    @JsonProperty
    @Email
    private String email;
}
