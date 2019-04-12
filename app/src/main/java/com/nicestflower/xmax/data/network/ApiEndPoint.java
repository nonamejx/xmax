package com.nicestflower.xmax.data.network;


import com.nicestflower.xmax.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_AUTHENTICATION = BuildConfig.BASE_URL
            + "/api/authenticate";
    public static final String ENDPOINT_ACCOUNT_INFORMATION = BuildConfig.BASE_URL
            + "/api/account";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
