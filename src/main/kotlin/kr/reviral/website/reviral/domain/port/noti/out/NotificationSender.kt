package kr.reviral.website.reviral.domain.port.noti.out

import kr.reviral.website.reviral.domain.enums.NotificationMethod
import kr.reviral.website.reviral.domain.model.NotificationMessage

/**
 *packageName    : kr.reviral.website.reviral.domain.port.auth.out
 * fileName       : NotificationSender
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
interface NotificationSender {

    fun send(message: NotificationMessage)

    fun support(method: NotificationMethod): Boolean

}