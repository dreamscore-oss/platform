package com.swagger.client.codegen.rest.invoker.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-03-07T23:33:26.979688+01:00[Europe/Zurich]")
public class OAuth implements Authentication {
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void applyToParams(MultiValueMap<String, String> queryParams, HttpHeaders headerParams) {
        if (accessToken != null) {
            headerParams.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        }
    }
}
