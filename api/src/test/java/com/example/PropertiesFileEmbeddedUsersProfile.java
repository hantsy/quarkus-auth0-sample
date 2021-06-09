package com.example;

import io.quarkus.oidc.OidcConfigurationMetadata;
import io.quarkus.test.junit.QuarkusTestProfile;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.mockito.Mockito;
import io.quarkus.test.Mock;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import java.util.Map;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class PropertiesFileEmbeddedUsersProfile implements QuarkusTestProfile {
    @Override
    public String getConfigProfile() {
        return "embedded-users";
    }

    @Dependent
    static class AudienceValidatorProducer {

        @Produces
        @Mock
        public JsonWebToken mockJsonWebToken(){
            JsonWebToken token = Mockito.mock(JsonWebToken.class);
            when(token.getAudience()).thenReturn(Set.of("test"));
            return token;
        }

        @Produces
        @Mock
        public OidcConfigurationMetadata mockOidcConfigurationMetadata(){
            OidcConfigurationMetadata metadata = Mockito.mock(OidcConfigurationMetadata.class);
            when(metadata.get(anyString())).thenReturn("test");
            return metadata;
        }
    }
}
