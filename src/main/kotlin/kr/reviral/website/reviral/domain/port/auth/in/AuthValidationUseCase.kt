package kr.reviral.website.reviral.domain.port.auth.`in`

/**
 *packageName    : kr.reviral.website.reviral.domain.port.auth.`in`
 * fileName       : AuthValidationUseCase
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
interface AuthValidationUseCase {

    fun isValidationByPhoneNumber(phoneNumber: String): Boolean

    fun isValidationByPassword(password: String): Boolean

}