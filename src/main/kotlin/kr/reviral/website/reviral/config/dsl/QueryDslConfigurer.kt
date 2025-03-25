package kr.reviral.website.reviral.config.dsl

import com.querydsl.jpa.JPQLTemplates
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory

/**
 *packageName    : kr.reviral.website.reviral.config.dsl
 * fileName       : QueryDslConfigurer
 * author         : joy58
 * date           : 2025-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-25        joy58       최초 생성
 */
@Configuration
class QueryDslConfigurer {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Bean
    fun queryFactory(): JPAQueryFactory {
        return JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager)
    }

}