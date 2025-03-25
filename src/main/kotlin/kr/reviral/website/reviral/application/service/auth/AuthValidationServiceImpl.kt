package kr.reviral.website.reviral.application.service.auth

import kr.reviral.website.reviral.domain.port.auth.`in`.AuthValidationService
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.auth
 * fileName       : PasswordValidationService
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Service
class AuthValidationServiceImpl: AuthValidationService {

    override fun isValidationByPhoneNumber(phoneNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isValidationByPassword(password: String): Boolean {
        TODO("Not yet implemented")
    }
}