package com.realguo.web.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.realguo.web.view.DepotPropView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @JsonSerialize(using = ToStringSerializer.class)
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
    @NotNull(message = "价格不能为空")
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

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
     * 创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @TableField(fill = FieldFill.INSERT)
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

    /**
     * 道具所在仓库信息
     */
    @TableField(exist = false)
    @NotNull(message = "道具所在仓库信息不能为空")
    private List<DepotPropView> depotProp;
}
