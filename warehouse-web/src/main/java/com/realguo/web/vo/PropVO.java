package com.realguo.web.vo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.realguo.web.entity.PropEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("prop")
@ApiModel("道具")
@Data
@NoArgsConstructor
public class PropVO extends PropEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public PropVO(PropEntity propEntity) {
        try {
            BeanUtils.copyProperties(this, propEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
