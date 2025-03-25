package kr.reviral.website.reviral.application.service.noti

import kr.reviral.website.reviral.application.usecase.noti.NotificationUseCase
import kr.reviral.website.reviral.config.exception.ReviralException
import kr.reviral.website.reviral.config.exception.message.DefaultErrorMessage
import kr.reviral.website.reviral.domain.enums.NotificationMethod
import kr.reviral.website.reviral.domain.model.NotificationMessage
import kr.reviral.website.reviral.domain.port.noti.out.NotificationSender
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.service.noti
 * fileName       : NotificationUseCaseImpl
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Service
class NotificationUseCaseImpl(
    private val notificationSenders: List<NotificationSender>
): NotificationUseCase{

    @Throws(ReviralException::class)
    override fun sendNotification(notificationMessage: NotificationMessage, method: NotificationMethod) {
        val sender = notificationSenders.find { it.support(method) }
            ?: throw ReviralException("No Sender available for method: $method")
        sender.send(notificationMessage)
    }
}