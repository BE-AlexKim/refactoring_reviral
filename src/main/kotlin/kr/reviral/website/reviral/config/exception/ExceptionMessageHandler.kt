package kr.reviral.website.reviral.config.exception

import org.springframework.http.HttpStatus

/**
 *packageName    : kr.reviral.website.reviral.config.exception
 * fileName       : GlobalExeptionMessageHandler
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
interface ExceptionMessageHandler {

    fun getCode(): String

    fun getError(): String

    fun getHttpStatus(): HttpStatus

    fun getMessage(): String

    fun defaultException(): RuntimeException

    fun setException(cause: Throwable): RuntimeException

    fun setTimestamp(): String

}