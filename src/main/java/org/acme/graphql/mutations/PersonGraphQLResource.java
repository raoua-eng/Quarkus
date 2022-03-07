package org.acme.graphql.mutations;

import java.time.LocalDate;
import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.acme.graphql.input.CreatePersonUseCaseInput;
import org.acme.graphql.resources.Person;
import org.acme.service.CreatePersonUseCaseBO;
import org.acme.utils.MutationRequestHandler;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import io.smallrye.graphql.api.Context;
import com.fasterxml.jackson.databind.ObjectMapper;

@GraphQLApi
public class PersonGraphQLResource{
    @Inject
    ObjectMapper objectMapper;

    @Query
    @Description("find person")
    public Person findPerson(Long id) {
        /*
         * do something
         * */
        return new Person("name","civility","dateOfBirth","email"); 
    }
    
    @Mutation
    @Description("create person")
    public String createPerson(Context context,@Valid @Name("person") CreatePersonUseCaseInput input) throws Exception {
        /*
         * do something
         * */
        CreatePersonUseCaseBO personBO=new CreatePersonUseCaseBO("Raoua",null, "test@test", "M");
        CreatePersonUseCaseBO objectUpdated = MutationRequestHandler.getObject(context, "person", objectMapper, personBO);
       System.out.println(objectUpdated.toString());
        return "successful creation";
    }
}