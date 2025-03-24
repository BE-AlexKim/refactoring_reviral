package kr.reviral.website.reviral.adapter.out.persistence.oauth.dto

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto.response
 * fileName       : ResponseOAuthUserInfo
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
sealed interface ResponseOAuthUserInfo {

    fun getUsername(): String?

    fun getIdentity(): String?

    fun getEmail(): String?

    fun getProvider(): String?

    fun getThumbnail(): String?

}