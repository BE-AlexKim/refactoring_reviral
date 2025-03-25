package kr.reviral.website.reviral.application.service.user

import kr.reviral.website.reviral.adapter.`in`.user.dto.request.RequestSignUp
import kr.reviral.website.reviral.adapter.`in`.user.dto.response.ResponseUserInfo
import kr.reviral.website.reviral.adapter.out.persistence.user.JpaUserRepository
import kr.reviral.website.reviral.adapter.out.persistence.user.UserPersistenceAdapter
import kr.reviral.website.reviral.domain.entity.UserEntity
import kr.reviral.website.reviral.domain.model.User
import kr.reviral.website.reviral.domain.port.user.`in`.UserService
import org.springframework.stereotype.Service

/**
 *packageName    : kr.reviral.website.reviral.application.user
 * fileName       : UserService
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Service
class UserServiceImpl(
    private val userPersistenceAdapter: UserPersistenceAdapter
): UserService {

    override fun getUserInfo(userId: Long): UserEntity {
        return userPersistenceAdapter.findById(userId)
    }

    override fun delete(userId: Long) {
        userPersistenceAdapter.deleteByUserId(userId)
    }

    override fun save(request: RequestSignUp): ResponseUserInfo {
        TODO("Not yet implemented")
    }
}