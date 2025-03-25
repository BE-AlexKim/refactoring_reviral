package kr.reviral.website.reviral.adapter.out.persistence.oauth

import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.NaverToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.OAuthToken
import kr.reviral.website.reviral.adapter.out.persistence.oauth.dto.ResponseOAuthUserInfo
import kr.reviral.website.reviral.domain.enums.Registration
import kr.reviral.website.reviral.domain.properties.OAuthProperties
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.ResourceAccessException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.oauth
 * fileName       : NaverServiceAdaptor
 * author         : joy58
 * date           : 2025-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-24        joy58       최초 생성
 */
@Component
class NaverServiceAdaptor(
    private val oAuthProperties: OAuthProperties
):OAuthServiceAdaptor {
    private val restTemplate = RestTemplate()

    override fun redirectUri(): String {
        return UriComponentsBuilder.fromUriString(oAuthProperties.provider.naver.authorizationUri)
            .queryParam("client_id",oAuthProperties.registration.naver.clientId)
            .queryParam("scope",oAuthProperties.registration.naver.scope.joinToString(" "))
            .queryParam("redirect_uri",oAuthProperties.registration.naver.redirectUri)
            .queryParam("response_type",oAuthProperties.registration.naver.responseType)
            .toUriString()
    }

    override fun getAccessToken(code: String): OAuthToken? {
        val headers: HttpHeaders = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        headers.set("Accept", "application/json")

        val formData = LinkedMultiValueMap<String, String>()
        formData.set("grant_type", oAuthProperties.registration.naver.authorizationGrantType)
        formData.set("client_id", oAuthProperties.registration.naver.clientId)
        formData.set("redirect_uri", oAuthProperties.registration.naver.redirectUri)
        formData.set("code", code)
        formData.set("client_secret", oAuthProperties.registration.naver.clientSecret)

        val request = HttpEntity(formData, headers)

        try {
            return restTemplate.postForEntity(oAuthProperties.provider.naver.tokenUri, request, NaverToken::class.java).body
        }catch (ex: HttpClientErrorException) {
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST, "Client Error Exception")
        }catch (ex: HttpServerErrorException) {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error Exception")
        }catch (ex: ResourceAccessException) {
            throw ResourceAccessException("Resource Access Exception")
        }catch (ex: HttpMessageNotReadableException) {
            throw Exception("Message Not Readable Exception")
        }
    }

    override fun getUserInfo(oAuthToken: OAuthToken): ResponseOAuthUserInfo? {
        TODO("Not yet implemented")
    }

    override fun unlink() {
        TODO("Not yet implemented")
    }

    override fun support(provider: Registration): Boolean = provider == Registration.NAVER
}