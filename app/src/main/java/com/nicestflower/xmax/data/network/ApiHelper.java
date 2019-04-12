package com.nicestflower.xmax.data.network;

import com.nicestflower.xmax.data.network.model.AccountResponse;
import com.nicestflower.xmax.data.network.model.ApiHeader;
import com.nicestflower.xmax.data.network.model.AuthenticationResponse;
import com.nicestflower.xmax.data.network.model.LoginRequest;

import io.reactivex.Single;

/**
 * An interface for API calls.
 */
public interface ApiHelper {

    /**
     * Get the API header.
     *
     * @return the {@link ApiHeader}
     */
    ApiHeader getApiHeader();

    /**
     * Authenticate using the authentication request.
     *
     * @param request the authentication request
     * @return the response
     */
    Single<AuthenticationResponse> authenticate(LoginRequest.AuthenticationRequest request);

    /**
     * Get the account information using the authentication token that's added to the header.
     *
     * @return the account response
     */
    Single<AccountResponse> getAccountInformation();

}
