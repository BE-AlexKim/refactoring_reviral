package kr.reviral.website.reviral.domain.enums

/**
 *packageName    : kr.reviral.website.reviral.domain.model
 * fileName       : Registration
 * author         : joy58
 * date           : 2025-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-19        joy58       최초 생성
 */
enum class Registration {
    GOOGLE, APPLE, KAKAO, NAVER, FACEBOOK, ETC;

    companion object {
        fun from(value: String): Registration {
            try {
                return valueOf(value)
            }catch (ex : IllegalArgumentException) {
                throw IllegalArgumentException("지원하지 않는 역할입니다.")
            }
        }
    }
}