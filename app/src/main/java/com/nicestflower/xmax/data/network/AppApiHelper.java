package com.nicestflower.xmax.data.network;

import com.nicestflower.xmax.data.network.model.AccountResponse;
import com.nicestflower.xmax.data.network.model.ApiHeader;
import com.nicestflower.xmax.data.network.model.AuthenticationResponse;
import com.nicestflower.xmax.data.network.model.LoginRequest;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader mApiHeader) {
        this.mApiHeader = mApiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<AuthenticationResponse> authenticate(LoginRequest.AuthenticationRequest request) {
        return Rx2AndroidNetworking
                .post(ApiEndPoint.ENDPOINT_AUTHENTICATION)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(AuthenticationResponse.class);
    }

    @Override
    public Single<AccountResponse> getAccountInformation() {
        return Rx2AndroidNetworking
                .get(ApiEndPoint.ENDPOINT_ACCOUNT_INFORMATION)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(AccountResponse.class);
    }

}
