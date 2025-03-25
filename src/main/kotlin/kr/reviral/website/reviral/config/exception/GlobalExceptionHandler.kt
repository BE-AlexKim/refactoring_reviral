package kr.reviral.website.reviral.config.exception

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 *packageName    : kr.reviral.website.reviral.config.exception
 * fileName       : GlobalExceptionHandler
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ReviralException::class)
    fun handlerReviralException(ex: ReviralException): ResponseEntity<Map<String, Any>> {

        logger.error { "Error Message : ${ex.getErrorCode().getMessage()}" }
        logger.error { "Error Code : ${ex.getErrorCode().getCode()}" }

        return ResponseEntity.status(ex.getErrorCode().getHttpStatus())
            .body(
                mapOf(
                    "status" to ex.getErrorCode().getHttpStatus().value(),
                    "code" to ex.getErrorCode().getCode(),
                    "message" to ex.getErrorCode().getMessage()
                )
            )
    }

}