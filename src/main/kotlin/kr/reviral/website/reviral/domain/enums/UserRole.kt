package kr.reviral.website.reviral.domain.enums

/**
 *packageName    : kr.reviral.website.reviral.domain.model
 * fileName       : UserRole
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
enum class UserRole {
    PARTNER, ADMIN, SUPER_ADMIN, USER;

    companion object {
        fun from(role: String): UserRole =
            try {
                valueOf(role.uppercase())
            }catch ( e: IllegalArgumentException) {
                throw IllegalArgumentException("지원하지 않는 역할입니다.")
            }
    }

}