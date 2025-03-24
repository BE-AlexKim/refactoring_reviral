package kr.reviral.website.reviral.adapter.`in`.auth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.model.Registration
import kr.reviral.website.reviral.domain.port.auth.`in`.OAuthProvider
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
    private val oAuthProvider: OAuthProvider
) {

    @GetMapping("/{provider}/redirect")
    fun getRedirectUri(
        @PathVariable provider: String
    ): String {
        return "redirect: ${oAuthProvider.getRedirectUri(Registration.from(provider))}"
    }

    @GetMapping("/{provider}/callback")
    fun setKakaoCallback(
        @RequestParam code: String,
        @PathVariable provider: String
    ): ResponseEntity<ResponseOAuthUserInfo> {
        val oAuthToken = oAuthProvider.getAccessToken(code, Registration.from(provider))
        val token = oAuthToken?.let { oAuthProvider.getUserInfo(it) }
        return ResponseEntity.ok(token)
    }

}