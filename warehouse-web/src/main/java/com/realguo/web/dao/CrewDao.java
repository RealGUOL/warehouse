package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.entity.SysRoleEntity;
import com.realguo.web.vo.CrewVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 剧组管理
 */
public interface CrewDao extends BaseMapper<CrewEntity> {
}
