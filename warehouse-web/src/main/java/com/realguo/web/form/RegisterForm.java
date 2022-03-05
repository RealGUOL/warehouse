package com.realguo.web.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "注册表单")
@Data
@Getter
@Setter
public class RegisterForm {
    @ApiModelProperty(value = "用户名")
    @NotBlank(message="用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotBlank(message="密码不能为空")
    private String password;
}
