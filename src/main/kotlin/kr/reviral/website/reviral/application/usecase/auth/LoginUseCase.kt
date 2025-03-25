package kr.reviral.website.reviral.application.usecase.auth

import kr.reviral.website.reviral.adapter.`in`.auth.dto.request.RequestLoginDTO
import kr.reviral.website.reviral.domain.model.JwtToken

/**
 *packageName    : kr.reviral.website.reviral.application.usecase.auth
 * fileName       : LoginUseCase
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
interface LoginUseCase {

    fun login(request: RequestLoginDTO): JwtToken

    fun logout(userId: Long)

}