package kr.reviral.website.reviral.adapter.out.persistence.oauth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.KakaoToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.OAuthToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseKakaoUserInfo
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration
import kr.reviral.website.reviral.domain.properties.OAuthProperties
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.ResourceAccessException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.oauth
 * fileName       : OAuthPersistenceAdaptor
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
@Component
class KakaoServiceAdaptor(
    private val oAuthProperties: OAuthProperties
): OAuthServiceAdaptor {

    private val restTemplate = RestTemplate()

    override fun redirectUri(): String {
        return UriComponentsBuilder.fromUriString(oAuthProperties.provider.kakao.authorizationUri)
            .queryParam("client_id",oAuthProperties.registration.kakao.clientId)
            .queryParam("scope", oAuthProperties.registration.kakao.scope.joinToString(" "))
            .queryParam("redirect_uri",oAuthProperties.registration.kakao.redirectUri)
            .queryParam("response_type",oAuthProperties.registration.kakao.responseType)
            .queryParam("prompt","login")
            .toUriString()
    }

    override fun getAccessToken(code: String): OAuthToken? {

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        headers.set("Accept", "application/json")

        val formData = LinkedMultiValueMap<String, String>()
        formData.set("grant_type", oAuthProperties.registration.kakao.authorizationGrantType)
        formData.set("client_id", oAuthProperties.registration.kakao.clientId)
        formData.set("redirect_uri", oAuthProperties.registration.kakao.redirectUri)
        formData.set("code", code)
        formData.set("client_secret", oAuthProperties.registration.kakao.clientSecret)

        val request = HttpEntity(formData, headers)

        try {
            return restTemplate.postForEntity(oAuthProperties.provider.kakao.tokenUri, request, KakaoToken::class.java).body
        }catch (ex: HttpClientErrorException) {
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST, "Kakao Client Error")
        }catch (ex: HttpServerErrorException) {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error")
        }catch (ex: ResourceAccessException) {
            throw ResourceAccessException("Resource Access Exception")
        }

    }

    override fun getUserInfo(oAuthToken: OAuthToken): ResponseOAuthUserInfo? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.set("Authorization", "${oAuthToken.getGrantType()} ${oAuthToken.getAccessToken()}")

        val requestEntity = HttpEntity(null, headers)

        try {

            return restTemplate
                .exchange(
                    oAuthProperties.provider.kakao.userInfoUri,
                    HttpMethod.GET,
                    requestEntity,
                    ResponseKakaoUserInfo::class.java
                ).body!!

        }catch (ex: HttpClientErrorException) {
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST, "Kakao Client Error")
        }catch (ex: HttpServerErrorException) {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error")
        }catch (ex: ResourceAccessException) {
            throw ResourceAccessException("Resource Access Exception")
        }
    }

    override fun unlink() {
        TODO("Not yet implemented")
    }

    override fun support(provider: Registration): Boolean = provider == Registration.KAKAO
}