package com.realguo.web.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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

@ApiModel(value = "CrewVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("crew")
public class CrewVO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 剧组ID
     */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "剧组ID", hidden = true)
    private Long crewId;


    /**
     * 剧组名称
     */
    @NotBlank(message = "剧组名称不能为空")
    @ApiModelProperty(value = "剧组名称")
    private String crewName;
}

