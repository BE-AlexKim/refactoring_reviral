package kr.reviral.website.reviral

import kr.reviral.website.reviral.application.service.noti.NotificationUseCaseImpl
import kr.reviral.website.reviral.application.usecase.noti.NotificationUseCase
import kr.reviral.website.reviral.config.exception.ReviralException
import kr.reviral.website.reviral.domain.enums.EmailTemplate
import kr.reviral.website.reviral.domain.enums.NotificationMethod
import kr.reviral.website.reviral.domain.model.NotificationMessage
import kr.reviral.website.reviral.domain.port.noti.out.NotificationSender
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

/**
 *packageName    : kr.reviral.website.reviral
 * fileName       : NotificationTest
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@SpringBootTest
class NotificationTest {

    private val notificationSender: NotificationSender = mock()

    private val notificationUseCase = NotificationUseCaseImpl(listOf(notificationSender))

    @Test
    fun `메일 전송 성공 테스트`() {
        val notificationMessage = NotificationMessage("joy585@naver.com","blissart@kakao.com","hello","hello", EmailTemplate.VERIFICATION)
        val method = NotificationMethod.Email

        `when`(notificationSender.support(method)).thenReturn(true)

        notificationUseCase.sendNotification(notificationMessage, method)

        verify(notificationSender).send(notificationMessage)
    }

    @Test
    fun `메일 전송 실패 테스트`() {
        val notificationMessage = NotificationMessage("joy585@naver.com","blissart@kakao.com","hello","hello", EmailTemplate.VERIFICATION)
        val method = NotificationMethod.Email

        // 어떤 sender도 해당 method를 지원하지 않도록 설정
        `when`(notificationSender.support(method)).thenReturn(false)

        // when & then: ReviralException이 발생하는지 확인
        val exception = assertThrows<ReviralException> {
            notificationUseCase.sendNotification(notificationMessage, method)
        }
        assertEquals("No Sender available for method: $method", exception.message)
    }

}