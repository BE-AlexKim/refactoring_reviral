package kr.reviral.website.reviral.domain.port.auth.out

import kr.reviral.website.reviral.domain.model.JwtToken
import org.springframework.security.core.Authentication

/**
 *packageName    : kr.reviral.website.reviral.domain.port.auth.out
 * fileName       : JwtProvider
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */

interface JwtProvider {

    fun getToken(): JwtToken

    fun getAuthentication(): Authentication

    fun validation()

}