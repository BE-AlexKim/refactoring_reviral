package kr.reviral.website.reviral.adapter.out.persistence.noti

import kr.reviral.website.reviral.domain.enums.NotificationMethod
import kr.reviral.website.reviral.domain.model.NotificationMessage
import kr.reviral.website.reviral.domain.port.noti.out.NotificationSender
import org.springframework.stereotype.Component

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.noti
 * fileName       : KakaoNotificationSender
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Component
class KakaoNotificationSender: NotificationSender {

    override fun send(message: NotificationMessage) {
        TODO("Not yet implemented")
    }

    override fun support(method: NotificationMethod): Boolean = method == NotificationMethod.Kakao

}