package io.github.rothschil.provider;

import graphql.schema.idl.TypeRuntimeWiring;
import io.github.rothschil.datafetcher.UserDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class UserProvider {
    @Autowired
    private UserDataFetcher userDataFetcher;

    public final String schema_path = "static/schema/schema-user.graphql";


    public TypeRuntimeWiring.Builder buildQueryRuntimeWiring() {
        TypeRuntimeWiring.Builder builder = newTypeWiring("Query")
                .dataFetcher("save", userDataFetcher.save())
                .dataFetcher("login", userDataFetcher.login())
                .dataFetcher("userById", userDataFetcher.userById())
                .dataFetcher("userByGender", userDataFetcher.userByGender());
        return builder;
    }

}
