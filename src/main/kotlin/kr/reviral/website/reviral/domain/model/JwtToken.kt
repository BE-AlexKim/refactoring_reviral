package kr.reviral.website.reviral.domain.model

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth.dto
 * fileName       : JwtToken
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
data class JwtToken(
    val accessToken: String,
    val refreshToken: String
)
