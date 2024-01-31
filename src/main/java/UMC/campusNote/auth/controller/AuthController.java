package UMC.campusNote.auth.controller;

import UMC.campusNote.auth.dto.JoinReqDto;
import UMC.campusNote.auth.dto.JoinResDto;
import UMC.campusNote.auth.dto.LoginReqDto;
import UMC.campusNote.auth.dto.LoginResDto;
import UMC.campusNote.auth.service.AuthService;
import UMC.campusNote.auth.service.AuthServiceImpl;
import UMC.campusNote.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ApiResponse<JoinResDto> join(@RequestBody @Valid JoinReqDto joinReqDto){

        JoinResDto res = authService.join(joinReqDto);

        return ApiResponse.onSuccess(res);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResDto> login(@RequestBody @Valid LoginReqDto loginReqDto){
        log.info("login 호출");
        return ApiResponse.onSuccess(authService.login(loginReqDto));
    }

}
