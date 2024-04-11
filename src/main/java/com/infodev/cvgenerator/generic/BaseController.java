package com.infodev.cvgenerator.generic;

import com.infodev.cvgenerator.user.dto.APIResponse;

public class BaseController {
    public APIResponse getApiResponse(Object data, String message, boolean success){
        return APIResponse.builder().data(data).message(message).success(success).build();
    }
}
