package kr.reviral.website.reviral.domain.service.login

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginDTO
import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginToSuperAdmin
import kr.reviral.website.reviral.domain.model.JwtToken
import kr.reviral.website.reviral.domain.port.auth.`in`.LoginStrategy

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : SuperAdminLoginService
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */

class LoginSuperAdminStrategy: LoginStrategy {

    override fun login(request: RequestLoginDTO): JwtToken {
        TODO("Not yet implemented")
    }

    override fun logout(userId: Long) {
        TODO("Not yet implemented")
    }

    override fun support(request: RequestLoginDTO): Boolean = request is RequestLoginToSuperAdmin
}