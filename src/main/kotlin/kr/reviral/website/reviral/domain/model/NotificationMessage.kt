package kr.reviral.website.reviral.domain.model

import kr.reviral.website.reviral.domain.enums.EmailTemplate

/**
 *packageName    : kr.reviral.website.reviral.domain.enums
 * fileName       : NotificationMessage
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
data class NotificationMessage(
    val to: String,
    val from: String,
    val subject: String,
    val content: String,
    val emailTemplate: EmailTemplate? = null
)
