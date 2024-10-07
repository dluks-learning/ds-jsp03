package dev.dluks.jsp03.dtos;

import dev.dluks.jsp03.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientDTO(

        Long id,

        @NotBlank(message = "Nome é obrigatório")
        String name,

        String cpf,

        Double income,

        @PastOrPresent(message = "A data de nascimento não pode ser futura")
        LocalDate birthDate,

        Integer children
) {

    public ClientDTO(Client entity) {
        this(entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getIncome(),
                entity.getBirthDate(),
                entity.getChildren());
    }

}
