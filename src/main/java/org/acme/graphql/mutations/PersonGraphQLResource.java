package org.acme.graphql.mutations;

import javax.validation.Valid;

import org.acme.graphql.input.CreatePersonUseCaseInput;
import org.acme.graphql.resources.Person;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class PersonGraphQLResource{

    @Query
    @Description("find person")
    public Person findPerson(Long id) {
        /*
         * do something
         * */
        Person p = new Person();
        p.setName("name");
        p.setCivility("civility");
        p.setDateOfBirth("dateOfBirth");
        p.setEmail("email");
        return p;
    }
    @Mutation
    @Description("create person")
    public String createPerson(@Valid @Name("person") CreatePersonUseCaseInput input) {
        /*
         * do something
         * */
        return "successful creation";
    }
}