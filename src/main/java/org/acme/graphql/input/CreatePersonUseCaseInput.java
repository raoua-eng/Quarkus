package org.acme.graphql.input;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import org.acme.utils.CaseMode;
import org.acme.utils.CheckDateCoherence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@CheckDateCoherence(dateOne = "dateOfBirth", dateTwo = "dateOfParticipation", caseMode = CaseMode.BEFORE)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    private LocalDate dateOfParticipation;
}