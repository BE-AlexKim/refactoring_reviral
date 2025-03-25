package kr.reviral.website.reviral.config.exception.error

import kr.reviral.website.reviral.config.exception.ExceptionMessageHandler
import kr.reviral.website.reviral.config.exception.ReviralException
import kr.reviral.website.reviral.config.exception.message.DefaultErrorMessage
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 *packageName    : kr.reviral.website.reviral.config.exception.error
 * fileName       : DefaultError
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
enum class DefaultError(
    private val status: HttpStatus,
    private val code: String,
    private val message: String
): ExceptionMessageHandler {

    DEFAULT( HttpStatus.INTERNAL_SERVER_ERROR,"ME0001", DefaultErrorMessage.DEFAULT),
    HEADER_TOKEN_NOT_EXIST(HttpStatus.BAD_REQUEST, "BE0001", DefaultErrorMessage.HEADER_TOKEN_NOT_EXIST),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "BE0002", DefaultErrorMessage.INVALID_TOKEN),
    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "BE0003", DefaultErrorMessage.EXPIRED_ACCESS_TOKEN),
    EXPIRED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "BE0004", DefaultErrorMessage.EXPIRED_REFRESH_TOKEN),
    AUTH_METHOD_UNSUPPORTED(HttpStatus.UNAUTHORIZED, "BE0005", DefaultErrorMessage.AUTH_METHOD_UNSUPPORTED ),
    AUTH_IS_NOT_EMPTY(HttpStatus.NOT_ACCEPTABLE, "BE0006", DefaultErrorMessage.AUTH_IS_NOT_EMPTY),
    TOKEN_ERROR(HttpStatus.UNAUTHORIZED, "BE0007", DefaultErrorMessage.TOKEN_ERROR),
    REFRESH_TOKEN_NOT_EXIST(HttpStatus.UNAUTHORIZED,"BE0008", DefaultErrorMessage.REFRESH_TOKEN_NOT_EXIST),
    TOKEN_NOT_MATCH(HttpStatus.UNAUTHORIZED, "BE0009", DefaultErrorMessage.TOKEN_NOT_MATCH),
    USER_NOT_MATCH(HttpStatus.BAD_REQUEST, "BE0010", DefaultErrorMessage.USER_NOT_MATCH),
    USER_NOT_EXIST(HttpStatus.BAD_REQUEST,"BE0011", DefaultErrorMessage.USER_NOT_EXIST),
    USERNAME_DUPLICATED(HttpStatus.BAD_REQUEST,"BE0012", DefaultErrorMessage.USERNAME_DUPLICATED),
    USER_CREDENTIALS_NOT_MATCH(HttpStatus.BAD_REQUEST, "BE0013", DefaultErrorMessage.USER_CREDENTIALS_NOT_MATCH),
    USER_ALREADY_EXIST(HttpStatus.BAD_REQUEST,"BE0014",DefaultErrorMessage.USER_ALREADY_EXIST),
    AUTHORIZED_EMAIL(HttpStatus.BAD_REQUEST, "BE0015", DefaultErrorMessage.AUTHORIZED_EMAIL),
    AUTHORIZED_CODE_NOT_MATCH(HttpStatus.BAD_REQUEST, "BE0016", DefaultErrorMessage.AUTHORIZED_CODE_NOT_MATCH),
    FILE_IMG_EXTENSION(HttpStatus.BAD_REQUEST, "BE0017", DefaultErrorMessage.FILE_IMG_EXTENSION),
    FILE_UPLOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "BE0018", DefaultErrorMessage.FILE_UPLOAD_FAIL),
    SECONDARY_PASSWORD_SET(HttpStatus.BAD_REQUEST, "BE0019", DefaultErrorMessage.SECONDARY_PASSWORD_SET),
    UNSUPPORTED_URL(HttpStatus.NOT_FOUND,"BE0020", DefaultErrorMessage.UNSUPPORTED_URL),
    AUTH_NOT_ADMIN(HttpStatus.BAD_REQUEST,"BE0021",DefaultErrorMessage.AUTH_NOT_ADMIN),
    UNSUPPORTED_REGISTRATION(HttpStatus.INTERNAL_SERVER_ERROR, "BE0022", DefaultErrorMessage.UNSUPPORTED_REGISTRATION),
    SID_NOT_EXIST(HttpStatus.BAD_REQUEST, "BE0023", DefaultErrorMessage.SID_NOT_EXIST),
    BLACK_LIST_USER(HttpStatus.UNAUTHORIZED, "BE0024", DefaultErrorMessage.BLACK_LIST_USER),
    OAUTH_CLIENT_ERROR(HttpStatus.BAD_REQUEST, "BE0025", DefaultErrorMessage.OAUTH_CLIENT_ERROR),
    SERVER_NETWORK_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"BE0026",DefaultErrorMessage.SERVER_NETWORK_ERROR),
    RESPONSE_TYPE_ERROR(HttpStatus.BAD_REQUEST,"BE0026",DefaultErrorMessage.RESPONSE_TYPE_ERROR),
    AUTHORIZED_CODE_EXPIRED(HttpStatus.BAD_REQUEST,"BE0027", DefaultErrorMessage.AUTHORIZED_CODE_EXPIRED),
    FILE_SIZE_FULL(HttpStatus.BAD_REQUEST,"BE0028",DefaultErrorMessage.FILE_SIZE_FULL),

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E00002", DefaultErrorMessage.UNAUTHORIZED);


    override fun getCode(): String {
        return code
    }

    override fun getError(): String {
        return name
    }

    override fun getMessage(): String {
        return message
    }

    override fun getHttpStatus(): HttpStatus {
        return status
    }

    override fun defaultException(): ReviralException {
        return ReviralException(this)
    }

    override fun setException(cause: Throwable): ReviralException {
        return ReviralException(this, cause)
    }

    override fun setTimestamp(): String {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}