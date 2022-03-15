package org.acme.graphql.input;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonUseCaseInput {
    @NotBlank(message="{graphql.validation.NotBlank.message}")
    private String name;
    @Past(message="{graphql.validation.Past.message}")
    @JsonbDateFormat(value = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @Email(message="{graphql.validation.Email.message}")
    private String email;
    @Max(value = 5, message = "{graphql.validation.Max.message}")
    private String civility;
 
}