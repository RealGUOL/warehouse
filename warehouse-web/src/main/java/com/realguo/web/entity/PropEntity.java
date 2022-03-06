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
import java.util.List;


/**
 * 道具
 */
@TableName("prop")
@ApiModel("道具")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public PropEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 道具ID
     */
    @TableId
    @ApiModelProperty(value = "道具ID", hidden = true)
    private Long propId;


    /**
     * 道具编号
     */
    @ApiModelProperty(value = "道具编号")
    private String propCode;

    /**
     * 道具名称
     */
    @NotBlank(message = "道具名称不能为空")
    @ApiModelProperty(value = "道具名称")
    private String propName;

    /**
     * 价格
     */
    @NotBlank(message = "价格不能为空")
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    /**
     * 库存
     */
    @NotBlank(message = "库存不能为空")
    @ApiModelProperty(value = "库存")
    private Integer stock;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String img;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 仓库名称
     */
    @TableField(exist=false)
    private String deptName;

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
