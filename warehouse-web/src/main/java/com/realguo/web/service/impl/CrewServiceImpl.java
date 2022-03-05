package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.web.dao.CrewDao;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.service.CrewService;
import org.springframework.stereotype.Service;

@Service("crewService")
public class CrewServiceImpl extends ServiceImpl<CrewDao, CrewEntity> implements CrewService {

}
