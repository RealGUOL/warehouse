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

@ApiModel(value = "DepotVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepotVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 仓库ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓库ID", hidden = true)
    private Long depotId;


    /**
     * 仓库名称
     */
    @NotBlank(message = "仓库名称不能为空")
    @ApiModelProperty(value = "仓库名称")
    private String depotName;
}

