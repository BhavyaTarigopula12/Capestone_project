package com.ey.mapper;

import com.ey.dto.response.LoginResponse;
import com.ey.dto.response.UserInfo;

public  class AuthMapper {

    private AuthMapper() {}

    public static LoginResponse toResponse(
            String accessToken,
            UserInfo user,
            long expiresIn
    ) {
        return new LoginResponse(
                accessToken,
                expiresIn,
                user
        );
    }
}
