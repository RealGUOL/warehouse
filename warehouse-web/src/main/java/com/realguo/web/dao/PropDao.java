package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.view.DepotPropView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 道具管理
 */
public interface PropDao extends BaseMapper<PropEntity> {
    List<PropEntity> queryPage(Page page, @Param("ew") Wrapper<PropEntity> wrapper);

    List<DepotPropView> queryDepotDetail(Long propId);
}
