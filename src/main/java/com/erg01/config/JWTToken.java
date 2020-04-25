package com.erg01.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_token"
})
public class JWTToken {

    @JsonProperty("id_token")
    private String idToken;

    public JWTToken() {
        super();
    }

    JWTToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    String getIdToken() {
        return idToken;
    }

    @JsonProperty("id_token")
    void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    @Override
    public String toString() {
        return "JWTToken{" +
                "idToken='" + idToken + '\'' +
                '}';
    }
}
