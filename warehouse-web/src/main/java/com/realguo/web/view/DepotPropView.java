package com.realguo.web.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.realguo.web.entity.DepotPropEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
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

@TableName("depot_prop")
@ApiModel("仓库道具")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepotPropView extends DepotPropEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public DepotPropView(DepotPropEntity depotPropEntity) {
        try {
            BeanUtils.copyProperties(this, depotPropEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private String depotName;
}
