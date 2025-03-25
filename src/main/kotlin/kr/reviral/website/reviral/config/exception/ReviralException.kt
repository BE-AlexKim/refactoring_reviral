package kr.reviral.website.reviral.config.exception

/**
 *packageName    : kr.reviral.website.reviral.config.exception
 * fileName       : ReviralException
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
class ReviralException: DefaultExceptionResolver {

    constructor(message: String): super(message)

    constructor(message: String, cause: Throwable): super(message, cause)

    constructor(exceptionCode: ExceptionMessageHandler): super(exceptionCode)

    constructor(exceptionCode: ExceptionMessageHandler, cause: Throwable): super(exceptionCode, cause)

}