package com.realguo.web.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 *
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */

@ApiModel(value = "PropVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 道具ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "道具ID", hidden = true)
    private Long propId;


    /**
     * 剧组名称
     */
    @NotBlank(message = "道具名称不能为空")
    @ApiModelProperty(value = "道具名称")
    private String propName;
}

