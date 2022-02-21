package org.acme.graphql.input;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonUseCaseInput {
    @NotBlank(message="'${validatedValue}' cannot be null")
    private String name;
    @Past(message="Date must be in past. found '${validatedValue}'")
    @JsonbDateFormat(value = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @Email(message="email should be valid")
    private String email;
    @Max(value = 5, message = "{ '${validatedValue}' must be at least {value} characters long. Length found : '${validatedValue.length()}'}")
    private String civility;
 
}