package com.realguo.web.vo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.realguo.web.entity.LendingRecordEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("lending_record")
@ApiModel("出借记录")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LendingRecordVO extends LendingRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public LendingRecordVO(LendingRecordEntity lendingRecordEntity) {
        try {
            BeanUtils.copyProperties(this, lendingRecordEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String crewName;

    private String propName;

    private String depotName;
}
