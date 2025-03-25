package kr.reviral.website.reviral.adapter.out.persistence.noti

import kr.reviral.website.reviral.config.exception.ReviralException
import kr.reviral.website.reviral.domain.enums.EmailTemplate
import kr.reviral.website.reviral.domain.enums.NotificationMethod
import kr.reviral.website.reviral.domain.model.NotificationMessage
import kr.reviral.website.reviral.domain.port.noti.out.NotificationSender
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.noti
 * fileName       : MailNotificationSender
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Component
class MailNotificationSender(
    private val javaMailSender: JavaMailSender,
    private val templateEngine: SpringTemplateEngine
): NotificationSender {

    override fun send(message: NotificationMessage) {
        require(message.emailTemplate != null ) {
            throw ReviralException("Email type not null ")
        }

        val mimeMessage = javaMailSender.createMimeMessage()
        val messageHelper = MimeMessageHelper(mimeMessage, true, Charsets.UTF_8.name())
        messageHelper.setSubject(message.subject)
        messageHelper.setTo(message.to)

        val context = EmailTemplate.getContext(message.emailTemplate)

        messageHelper.setText(templateEngine.process(message.emailTemplate.templateName(), context))
        javaMailSender.send(mimeMessage)
    }

    override fun support(method: NotificationMethod): Boolean = method == NotificationMethod.Email
}