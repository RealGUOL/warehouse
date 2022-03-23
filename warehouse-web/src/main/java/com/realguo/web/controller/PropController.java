package com.realguo.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.common.validator.ValidatorUtils;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.service.PropService;
import com.realguo.web.vo.PropVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 道具
 */
@RestController
@RequestMapping("/prop")
public class PropController extends AbstractController {
	@Autowired
	private PropService propService;


	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = propService.queryPage(params);

		return R.ok().put("data", page);
	}

	@RequestMapping("/update")
	public R update(@RequestBody PropEntity prop) {
		ValidatorUtils.validateEntity(prop);
		propService.update(prop);
		return R.ok();
	}

	@RequestMapping("/search")
	public R search(@RequestBody Map<String, String> params) {
		final List<PropVO> res = propService.selectListVO(new EntityWrapper<PropEntity>()
				.setSqlSelect("prop_id, prop_name")
				.like("prop_name", params.get("keyword")));

		HashMap<String, Object> map = Maps.newHashMap();
		map.put("items", res);
		return R.ok().put("data", map);
	}
}
