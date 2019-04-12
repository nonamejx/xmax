package com.nicestflower.xmax.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;

    @Inject
    public ApiHeader(ProtectedApiHeader mProtectedApiHeader) {
        this.mProtectedApiHeader = mProtectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public static final class ProtectedApiHeader {
        @Expose
        @SerializedName("Authorization")
        private String authorizationToken;

        public ProtectedApiHeader(String authorizationToken) {
            this.authorizationToken = authorizationToken;
        }

        public String getAuthorizationToken() {
            return authorizationToken;
        }

        public void setAuthorizationToken(String authorizationToken) {
            this.authorizationToken = authorizationToken;
        }
    }

}
