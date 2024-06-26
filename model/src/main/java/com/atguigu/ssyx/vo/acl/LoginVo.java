package com.atguigu.ssyx.vo.acl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author QRH
 * @date 2024/6/25 22:04
 * @description TODO
 */
@Data
@ApiModel(value = "管理员表单登录实体")
public class LoginVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

}