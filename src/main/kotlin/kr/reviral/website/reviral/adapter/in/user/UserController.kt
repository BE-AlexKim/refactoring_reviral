package kr.reviral.website.reviral.adapter.`in`.user

import kr.reviral.website.reviral.adapter.`in`.user.dto.request.RequestBasicUserInfo
import kr.reviral.website.reviral.adapter.`in`.user.dto.request.RequestUpdateUserInfo
import kr.reviral.website.reviral.domain.port.user.`in`.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : kr.reviral.website.reviral.adapter.`in`.user
 * fileName       : UserController
 * author         : joy58
 * date           : 2025-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        joy58       최초 생성
 */
@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/basic/info")
    fun setBasicUserInfo(
        @RequestBody request: RequestBasicUserInfo
    ) {

    }

    @GetMapping("/basic/info")
    fun getUserInfo(
        @RequestBody userId: Long
    ) {

    }

    @PutMapping("/basic/info")
    fun updateUserInfo(
        @RequestBody request: RequestUpdateUserInfo
    ) {

    }

    @DeleteMapping("/basic/info")
    fun deleteUserInfo() {

    }

}