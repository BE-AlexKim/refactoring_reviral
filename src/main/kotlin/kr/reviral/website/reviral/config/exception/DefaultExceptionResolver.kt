package kr.reviral.website.reviral.config.exception

import kr.reviral.website.reviral.config.exception.error.DefaultError
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 *packageName    : kr.reviral.website.reviral.config.exception
 * fileName       : DefaultExceptionResolver
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
open class DefaultExceptionResolver: RuntimeException {

    private var exceptionMessageInitializer: ExceptionMessageHandler

    private object DefaultErrorCodeHolder {
        val DEFAULT_ERROR_CODE = object : ExceptionMessageHandler {

            override fun getCode(): String {
                return DefaultError.DEFAULT.getCode()
            }

            override fun getError(): String {
                return DefaultError.DEFAULT.getError()
            }

            override fun getHttpStatus(): HttpStatus {
                return DefaultError.DEFAULT.getHttpStatus()
            }

            override fun getMessage(): String {
                return DefaultError.DEFAULT.getMessage()
            }

            override fun defaultException(): RuntimeException {
                return DefaultExceptionResolver(DefaultError.DEFAULT)
            }

            override fun setException(cause: Throwable): RuntimeException {
                return DefaultExceptionResolver(DefaultError.DEFAULT, cause)
            }

            override fun setTimestamp(): String {
                return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            }
        }
    }

    constructor(message: String) : super(message) {
        exceptionMessageInitializer = getDefaultErrorCode()
    }

    constructor(message: String, cause: Throwable) : super(message, cause) {
        exceptionMessageInitializer = getDefaultErrorCode()
    }

    constructor(exceptionCode: ExceptionMessageHandler) : super(exceptionCode.getMessage()) {
        this.exceptionMessageInitializer = exceptionCode
    }

    constructor(exceptionCode: ExceptionMessageHandler, cause: Throwable) : super(exceptionCode.getMessage(), cause) {
        this.exceptionMessageInitializer = exceptionCode
    }

    open fun getErrorCode(): ExceptionMessageHandler {
        return exceptionMessageInitializer
    }

    private fun getDefaultErrorCode(): ExceptionMessageHandler {
        return DefaultErrorCodeHolder.DEFAULT_ERROR_CODE
    }

}