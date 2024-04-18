package com.infodev.cvgenerator.user.userLogin;

import com.infodev.cvgenerator.configuration.CustomMessageSource;
import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.dto.APIResponse;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserLoginController extends BaseController {
    private final UserLoginService userLoginService;
    private final CustomMessageSource customMessageSource;

    public UserLoginController(UserLoginService userLoginService, CustomMessageSource customMessageSource) {
        this.userLoginService = userLoginService;
        this.customMessageSource = customMessageSource;
    }

    @GetMapping()
    public ResponseEntity<APIResponse> find(){
        List<UserLoginDto> dtoList = userLoginService.getUsers();
        return ResponseEntity.ok(getApiResponse(dtoList,"User List" + customMessageSource.get("crud.get"), true));
    }
}
