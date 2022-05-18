package org.acme.graphql.mutations;


import javax.inject.Inject;
import javax.validation.Valid;

import org.acme.graphql.input.CreateOrderUseCaseInput;
import org.acme.graphql.input.CreatePersonUseCaseInput;
import org.acme.graphql.resources.Person;
import org.acme.utils.LocaleChangeInterceptor;
import org.acme.utils.security.Secured;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import io.quarkus.security.Authenticated;
import io.smallrye.graphql.api.Context;
import com.fasterxml.jackson.databind.ObjectMapper;

@GraphQLApi
//@LocaleChangeInterceptor
@Authenticated
public class PersonGraphQLResource{
    @Inject
    ObjectMapper objectMapper;
    @Inject
    Context context;

    @Secured
    @Query
    @Description("find person")
    public Person findPerson(Long id) {
        System.out.println("Query Context : "+ context);
        /*
         * do something
         * */
        return new Person("name","civility","dateOfBirth","email"); 
    }
    
    @Mutation
    @Description("create person")
    public String createPerson(@Valid @Name("person") CreatePersonUseCaseInput input) throws Exception {
        System.out.println("Mutation Context : "+ context);
        /*
         * do something
         * */
        //CreatePersonUseCaseBO personBO=new CreatePersonUseCaseBO("Raoua",null, "test@test", "M");
       // CreatePersonUseCaseBO objectUpdated = MutationRequestHandler.getObject(context, "person", objectMapper, personBO);
      // System.out.println(objectUpdated.toString());
        return "successful creation";
    }

    @Mutation
    @Description("create order")
    public String createOrder(@Valid @Name("order") CreateOrderUseCaseInput input) throws Exception {
        System.out.println("Mutation Context : "+ context);
        /*
         * do something
         * */
        return "successful creation";
    }
}