package kr.reviral.website.reviral.adapter.`in`.auth

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginToAdmin
import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginToUser
import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginToSuperAdmin
import kr.reviral.website.reviral.application.auth.*
import kr.reviral.website.reviral.domain.model.JwtToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth
 * fileName       : AuthController
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val loginUserService: LoginUserService,
    private val loginAdminService: LoginAdminService,
    private val loginSuperAdminService: LoginSuperAdminService,
    private val authValidationService: AuthValidationService,
    private val jwtTokenService: JwtTokenService
) {

    /**
     *  역할별 로그인의 요구 사항이 사용자에 따라 달라질 수 있기 때문에 해당 로직은 sealed interface를 통해서 부모 객체를 만들어서 타입의 안정성을 확보하였습니다.
     *  그리고 로그인의 요구에 따라 다른 데이터 들어올 수 있도록 데이터의 유연성과 타입의 안정성을 확보하기 위해서 별도의 엔드포인트로 구성하였습니다.
     */
    @PostMapping("/user/login")
    fun loginByUser(
        @RequestBody request: RequestLoginToUser
    ): JwtToken {
        return loginUserService.login(request)
    }

    @PostMapping("/admin/login")
    fun loginByAdmin(
        @RequestBody request: RequestLoginToAdmin
    ): JwtToken {
        return loginAdminService.login(request)
    }

    @PostMapping("/super-admin/login")
    fun loginBySuperAdmin(
        @RequestBody request: RequestLoginToSuperAdmin
    ): JwtToken {
        return loginSuperAdminService.login(request)
    }

    @PostMapping("/logout")
    fun logout(
        @RequestBody userId: Long
    ) {
        TODO("Not yet implemented")
    }

    @PostMapping("/reissue")
    fun reissue(
        @RequestBody refreshToken: String
    ): JwtToken {
        return jwtTokenService.reissueByRefreshToken(refreshToken)
    }

    @PostMapping("/email/authorize/validate")
    fun validationByEmail(
        @RequestBody phoneNumber: String
    ): Boolean {
        return authValidationService.isValidationByPhoneNumber(phoneNumber)
    }

    @PostMapping("/email/authorize/send")
    fun sendAuthorizeCodeToEmail() {
        authValidationService
    }

}