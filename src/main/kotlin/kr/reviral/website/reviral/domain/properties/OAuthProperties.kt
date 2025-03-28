package kr.reviral.website.reviral.domain.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client")
class OAuthProperties {
    lateinit var registration: Registration
    lateinit var provider: Provider

    class Registration {
        lateinit var kakao: Kakao
        lateinit var naver: Naver
    }

    class Provider {
        lateinit var kakao: KakaoProvider
        lateinit var naver: NaverProvider
    }

    class Kakao {
        lateinit var clientId: String
        lateinit var clientSecret: String
        lateinit var adminKey: String
        lateinit var redirectUri: String
        lateinit var responseType: String
        lateinit var authorizationGrantType: String
        lateinit var clientName: String
        lateinit var scope: List<String>
    }

    class Naver {
        lateinit var clientId: String
        lateinit var clientSecret: String
        lateinit var redirectUri: String
        lateinit var responseType: String
        lateinit var authorizationGrantType: String
        lateinit var clientName: String
        lateinit var scope: List<String>
    }

    class KakaoProvider {
        lateinit var authorizationUri: String
        lateinit var tokenUri: String
        lateinit var userInfoUri: String
        lateinit var userNameAttribute: String
        lateinit var unlinkUri: String
    }

    class NaverProvider {
        lateinit var authorizationUri: String
        lateinit var tokenUri: String
        lateinit var userInfoUri: String
        lateinit var userNameAttribute: String
    }
}