package kr.reviral.website.reviral.adapter.`in`.user

import kr.reviral.website.reviral.domain.port.user.`in`.UserUseCase
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.user
 * fileName       : UserController
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@RestController
class UserController(
    private val userUseCase: UserUseCase
) {

}