package kr.reviral.website.reviral.config.noti

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver
import java.util.*

/**
 *packageName    : kr.reviral.website.reviral.config.notification
 * fileName       : EmailConfigurer
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Configuration
@PropertySource("classpath:application.yml")
class EmailConfigurer(
    @Value("\${spring.mail.username}")
    private val username: String,
    @Value("\${spring.mail.password}")
    private val password: String,
    @Value("\${spring.mail.host}")
    private val host: String,
    @Value("\${spring.mail.port}")
    private val port: Int
) {

    @Bean
    fun mailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = host
        mailSender.username = username
        mailSender.password = password
        mailSender.port = port
        mailSender.javaMailProperties = getMailProperties()
        mailSender.defaultEncoding = "UTF-8"
        return mailSender
    }

    private fun getMailProperties(): Properties {
        val properties = Properties()
        properties.setProperty("mail.transport.protocol", "smtp")
        properties.setProperty("mail.smtp.auth", "true")
        properties.setProperty("mail.smtp.starttls.enable", "true")
        properties.setProperty("mail.debug", "true")
        properties.setProperty("mail.smtp.ssl.trust","smtp.gmail.com")
        properties.setProperty("mail.smtp.ssl.enable","true")
        return properties
    }

    @Bean
    fun templateEngine(): SpringTemplateEngine? {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(thymeleafTemplateResolver())
        return templateEngine
    }

    @Bean
    fun thymeleafTemplateResolver(): SpringResourceTemplateResolver? {
        val templateResolver = SpringResourceTemplateResolver()
        templateResolver.prefix = "classpath:/templates/"
        templateResolver.suffix = ".html"
        templateResolver.setTemplateMode("HTML")
        templateResolver.characterEncoding = "UTF-8"
        return templateResolver
    }

}