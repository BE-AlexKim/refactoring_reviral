package kr.reviral.website.reviral.adapter.`in`.auth

import kr.reviral.website.reviral.domain.port.auth.`in`.LoginUseCase
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
@RequestMapping("/auth")
class AuthController(
    private val loginUseCase: LoginUseCase
) {
}