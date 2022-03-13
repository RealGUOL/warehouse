package com.realguo.web.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.realguo.web.entity.PropEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */

@TableName("prop")
@ApiModel("道具")
@Data
@NoArgsConstructor
public class PropView extends PropEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public PropView(PropEntity propEntity) {
        try {
            BeanUtils.copyProperties(this, propEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
