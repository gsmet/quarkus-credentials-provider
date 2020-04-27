package org.acme.getting.started;

import io.quarkus.arc.Unremovable;
import io.quarkus.vault.CredentialsProvider;

import javax.enterprise.context.ApplicationScoped;
import java.util.Properties;

@ApplicationScoped
@Unremovable
public class MyCredentialsProvider implements CredentialsProvider {

    @Override
    public Properties getCredentials(String credentialsProviderName) {
        System.out.println("");
        System.out.println("####################################");
        System.out.println("# My credential provider is called!");
        System.out.println("####################################");
        System.out.println("");

        Properties properties = new Properties();

        properties.put(USER_PROPERTY_NAME, "hibernate_orm_test");
        properties.put(PASSWORD_PROPERTY_NAME, "hibernate_orm_test");

        return properties;
    }

}
