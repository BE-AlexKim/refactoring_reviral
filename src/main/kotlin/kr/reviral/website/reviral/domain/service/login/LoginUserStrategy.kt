package kr.reviral.website.reviral.domain.service.login

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginDTO
import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginToUser
import kr.reviral.website.reviral.adapter.out.persistence.user.UserPersistenceAdapter
import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.`in`.LoginStrategy

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : AuthService
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */

class LoginUserStrategy(
    private val userPersistenceAdapter: UserPersistenceAdapter,
): LoginStrategy {

    override fun login(request: RequestLoginDTO): JwtToken {
        if ( request is RequestLoginToUser ) {
            TODO("로그인 로직 처리")
        }else {
            TODO("Exception 처리")
        }
    }

    override fun logout(userId: Long) {
        TODO("Not yet implemented")
    }

    override fun support(request: RequestLoginDTO): Boolean = request is RequestLoginToUser

}