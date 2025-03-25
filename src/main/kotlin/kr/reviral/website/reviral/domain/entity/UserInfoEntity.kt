package kr.reviral.website.reviral.domain.entity

import jakarta.persistence.*
import kr.reviral.website.reviral.domain.enums.Gender
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

/**
 *packageName    : kr.reviral.website.reviral.adapter.out.persistence.user.entity
 * fileName       : UserInfoEntity
 * author         : joy58
 * date           : 2025-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-19        joy58       최초 생성
 */
@Entity
@Table(name = "tb_user_settings")
class UserInfoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_set_id")
    val id: Long? = null,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val user: UserEntity? = null,

    @Column(name = "second_password", nullable = false)
    @Comment("2차 비밀번호")
    var secondPassword: String,

    @Column(name = "username")
    @Comment("이름")
    var username: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    @Comment("성별")
    var gender: Gender,

    @Column(name = "phone_number")
    @Comment("휴대폰 번호")
    var phone: String,

    @Column(name = "address")
    @Comment("주소")
    var address: String? = null,

    @Column(name = "bank_code")
    @Comment("은행 코드")
    var bankCode: String? = null,

    @Column(name = "account_number")
    @Comment("계좌 번호")
    var account: String? = null,

    @Column(name = "nv_id")
    @Comment("네이버 아이디")
    var nvId: String? = null,

    @Column(name = "cp_id")
    @Comment("쿠팡 아이디")
    var cpId: String? = null,

    @Column(name = "created_at")
    @Comment("최초 생성 일시")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    @Comment("최종 수정 일시")
    var updatedAt: LocalDateTime? = null
)
