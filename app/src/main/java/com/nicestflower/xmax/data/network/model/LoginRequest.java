package com.nicestflower.xmax.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class LoginRequest {

    private LoginRequest() {
        // do not create this class
    }

    public static class AuthenticationRequest {
        @Expose
        @SerializedName("username")
        private String username;

        @Expose
        @SerializedName("password")
        private String password;

        @Expose
        @SerializedName("rememberMe")
        private boolean rememberMe;

        public AuthenticationRequest(String username, String password, boolean rememberMe) {
            this.username = username;
            this.password = password;
            this.rememberMe = rememberMe;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isRememberMe() {
            return rememberMe;
        }

        public void setRememberMe(boolean rememberMe) {
            this.rememberMe = rememberMe;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            AuthenticationRequest that = (AuthenticationRequest) o;

            return new EqualsBuilder()
                    .append(rememberMe, that.rememberMe)
                    .append(username, that.username)
                    .append(password, that.password)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(username)
                    .append(password)
                    .append(rememberMe)
                    .toHashCode();
        }
    }

}
