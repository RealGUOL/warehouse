package com.realguo.web.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 剧组
 */
@TableName("crew")
@ApiModel("剧组")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public CrewEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 剧组ID
     */
    @TableId
    @ApiModelProperty(value = "剧组ID", hidden = true)
    private Long crewId;


    /**
     * 剧组名称
     */
    @NotBlank(message = "剧组名称不能为空")
    @ApiModelProperty(value = "剧组名称")
    private String crewName;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contact;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "联系人")
    private String phone;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Date updateTime;
}
