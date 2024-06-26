package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QRH
 * @date 2024/6/25 21:15
 * @description TODO
 */
@Api(tags="角色Controller")
@RestController
@RequestMapping("/admin/acl/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
}
