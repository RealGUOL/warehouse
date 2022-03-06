package com.realguo.web.vo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.PropEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@TableName("depot_prop")
@ApiModel("仓库道具")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepotPropVO extends DepotPropEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public DepotPropVO(DepotPropEntity depotPropEntity) {
        try {
            BeanUtils.copyProperties(this, depotPropEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private String depotName;
}
