package kr.reviral.website.reviral.domain.enums

import org.thymeleaf.context.Context
import kotlin.random.Random

/**
 *packageName    : kr.reviral.website.reviral.domain.enums
 * fileName       : EmailType
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
enum class EmailTemplate(
    private val templateName: String
) {
    VERIFICATION("verification"), WELCOME("welcome");

    fun templateName() = templateName

    companion object {
        fun getContext(template: EmailTemplate): Context {
            try {
                val context = Context()
                val values = when (template) {
                    VERIFICATION -> {
                        hashMapOf("code" to Random.nextInt(10000,100000), "title" to "제목")
                    }
                    WELCOME -> {
                        hashMapOf("message" to "")
                    }
                }
                values.forEach { (key, value) ->
                    context.setVariable(key,value)
                }
                return context
            }catch (ex: IllegalArgumentException) {
                throw IllegalArgumentException("Email type Format Error")
            }
        }
    }
}