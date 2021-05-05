package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import io.smallrye.jwt.build.Jwt;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.example.web.CreatePostCommand;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestProfile(MockOidcServerProfile.class)
@Disabled("Custom private/pub key dose not work")
public class BearerTokenAuthorizationTest {

    @Test
    public void testBearerToken() {
        //@formatter:off
        given()
            .auth().oauth2(getAccessToken("alice", Set.of("user")))
            .body(new CreatePostCommand("test title", "test content"))
            .contentType(ContentType.JSON)
        .when()
            .post("/posts")
        .then()
            .statusCode(201);
            // the test endpoint returns the name extracted from the injected SecurityIdentity Principal
            //.body("userName", equalTo("alice"));
        //@formatter:on

    }

    // OidcWiremockTestResource internally use a fixed pub/private key pairs, does not support custom keys generated by developers.
    // This is terrible for developers.
    private String getAccessToken(String userName, Set<String> groups) {
        return Jwt.preferredUserName(userName)
                //.claim("scope", "write:posts")
                .groups(groups)
                .issuer("https://server.example.com")
                .audience("https://server.example.com")
                .jws()
                .keyId("1")
                .sign();
    }
}