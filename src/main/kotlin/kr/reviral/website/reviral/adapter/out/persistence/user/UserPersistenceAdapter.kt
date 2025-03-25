package kr.reviral.website.reviral.adapter.out.persistence.user

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import kr.reviral.website.reviral.adapter.`in`.user.dto.response.ResponseUserInfo
import kr.reviral.website.reviral.domain.entity.QUserEntity
import kr.reviral.website.reviral.domain.entity.QUserInfoEntity
import kr.reviral.website.reviral.domain.entity.UserEntity
import kr.reviral.website.reviral.domain.port.user.out.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.user.repository
 * fileName       : UserPersistenceAdapter
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@Repository
class UserPersistenceAdapter constructor(
    private val jpaUserRepository: JpaUserRepository,
    private val queryFactory: JPAQueryFactory
): UserRepository {

    override fun findAll(): MutableList<UserEntity> {
        return jpaUserRepository.findAll()
    }

    override fun findById(userId: Long): UserEntity {
        return jpaUserRepository.findById(userId).orElseThrow {
            throw Exception("User Not Found")
        }
    }

    @Transactional
    override fun save(user: UserEntity): UserEntity {
        return jpaUserRepository.save(user)
    }

    @Transactional
    override fun deleteByUserId(userId: Long) {
        val user = jpaUserRepository.findById(userId).orElseThrow {
            throw Exception("User Not Found.")
        }
        jpaUserRepository.delete(user)
    }

    /**
     * 객체의 생성 비용을 줄이는 Projections 객체 생성과 QueryDSL을 이용한 N+1 해결 및 성능 개선을 하였다.
     * 다만, 코드가 조금 길어지고 Projections 사용으로 코드 복잡도가 증가하였다.
     */
    override fun findUserAndUserInfoByUserId(userId: Long): ResponseUserInfo {
        val qUser = QUserEntity.userEntity
        val qUserInfo = QUserInfoEntity.userInfoEntity

        return queryFactory
            .select(
                Projections.fields(
                    ResponseUserInfo::class.java,
                    qUserInfo.username.`as`("name"),
                    qUser.email.`as`("loginId"),
                    qUserInfo.phone.`as`("phoneNumber"),
                    qUserInfo.nvId.`as`("nvId"),
                    qUserInfo.cpId.`as`("cpId"),
                    qUserInfo.address.`as`("address"),
                    qUserInfo.bankCode.`as`("bankCode"),
                    qUserInfo.account.`as`("accountNumber"),
                    qUser.profileImage.`as`("profileImage")
                )
            )
            .from(qUser)
            .leftJoin(qUser.userInfo, qUserInfo).fetchJoin()
            .where(qUser.id.eq(userId))
            .fetchOne()
            ?: throw Exception("User Not Found.")
    }
}