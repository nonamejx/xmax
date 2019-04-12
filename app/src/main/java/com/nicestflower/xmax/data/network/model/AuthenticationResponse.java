package com.nicestflower.xmax.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AuthenticationResponse {

    @Expose
    @SerializedName("id_token")
    private String idToken;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AuthenticationResponse that = (AuthenticationResponse) o;

        return new EqualsBuilder()
                .append(idToken, that.idToken)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(idToken)
                .toHashCode();
    }
}
