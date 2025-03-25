package kr.reviral.website.reviral.adapter.`in`.auth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration
import kr.reviral.website.reviral.domain.port.auth.`in`.OAuthService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.auth
 * fileName       : OAuthController
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
@Controller
@RequestMapping("/api/v1/oauth/kakao")
class OAuthController(
    private val oAuthService: OAuthService
) {

    @GetMapping("/{provider}/redirect")
    fun getRedirectUri(
        @PathVariable provider: String
    ): String {
        return "redirect: ${oAuthService.getRedirectUri(Registration.from(provider))}"
    }

    @GetMapping("/{provider}/callback")
    fun callback(
        @RequestParam code: String,
        @PathVariable provider: String
    ): ResponseEntity<ResponseOAuthUserInfo> {
        return ResponseEntity.ok(oAuthService.callback(code, Registration.from(provider)))
    }

}