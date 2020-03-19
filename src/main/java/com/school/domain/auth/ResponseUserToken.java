package com.school.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("用户登录返回信息")
public class ResponseUserToken {
    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "用户详细信息")
    private UserDetail userDetail;
}
