package kr.reviral.website.reviral.application.usecase.noti

import kr.reviral.website.reviral.domain.enums.NotificationMethod
import kr.reviral.website.reviral.domain.model.NotificationMessage

/**
 *packageName    : kr.reviral.website.reviral.application.usecase.noti
 * fileName       : NotificationService
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
interface NotificationUseCase {

    fun sendNotification(notificationMessage: NotificationMessage, method: NotificationMethod)

}