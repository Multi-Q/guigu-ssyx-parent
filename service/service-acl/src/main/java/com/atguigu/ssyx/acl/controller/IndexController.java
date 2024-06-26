package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.vo.acl.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author QRH
 * @date 2024/6/25 20:26
 * @description 登录接口
 */
@Api(tags = "登录Controller")
@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin
public class IndexController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result  login(@RequestBody LoginVo loginVo) {
        System.out.println(loginVo);
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("token","token-admin");
        return Result.ok(map);
    }
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public Result  info() {
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }
    @ApiOperation(value = "退出")
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }
}
