package org.javaboy.swagger2.controller;

import io.swagger.annotations.*;
import org.javaboy.swagger2.bean.User;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/25 22:28
 */
@RestController
@Api(tags = "用户数据接口")
public class UserController {

    @GetMapping("/user")
    @ApiOperation(value = "查询用户", notes = "根据用户id查询用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, defaultValue = "99")
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, defaultValue = "99")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        System.out.println("deleteUserById" + id);
    }

    @ApiOperation(value = "更新用户", notes = "根据用户id更新用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, defaultValue = "99"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, defaultValue = "丁代光")
    })
    @ApiIgnore  //不暴露此接口
    @PutMapping("/user")
    public User updateUsernameById(Integer id, String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @ApiOperation(value = "添加用户", notes = "添加用户接口")
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return user;
    }

}
