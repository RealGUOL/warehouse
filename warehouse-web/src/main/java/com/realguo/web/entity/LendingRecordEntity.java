package com.realguo.web.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 出借记录
 */
@TableName("lending_record")
@ApiModel("出借记录")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LendingRecordEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public LendingRecordEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 出借记录ID
     */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "出借记录ID", hidden = true)
    private Long lendingRecordId;


    /**
     * 剧组ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "剧组不能为空")
    @ApiModelProperty(value = "剧组ID")
    private Long crewId;

    /**
     * 道具ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "道具不能为空")
    @ApiModelProperty(value = "道具ID")
    private Long propId;

    /**
     * 仓库ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "仓库不能为空")
    @ApiModelProperty(value = "仓库ID", hidden = true)
    private Long depotId;

    /**
     * 出借数量
     */
    @NotNull(message = "出借数量不能为空")
    @ApiModelProperty(value = "出借数量")
    private Integer borrowNum;

    /**
     * 每日租金
     */
    @NotNull(message = "每日租金不能为空")
    @ApiModelProperty(value = "每日租金")
    private BigDecimal dailyRent;

    /**
     * 租期
     */
    @NotNull(message = "租期不能为空")
    @ApiModelProperty(value = "租期")
    private Integer rentalDays;

    /**
     * 归还数量
     */
    @ApiModelProperty(value = "归还数量")
    private Integer returnNum;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 归还时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @ApiModelProperty(value = "归还时间")
    private Date returnTime;

    /**
     * 操作人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "操作人")
    private String operator;

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
     * 剧组名称
     */
    @TableField(exist=false)
    private String crewName;

    /**
     * 道具名称
     */
    @TableField(exist=false)
    private String propName;

    /**
     * 仓库名称
     */
    @TableField(exist=false)
    private String depotName;
}

