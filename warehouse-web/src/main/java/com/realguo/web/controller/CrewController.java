package com.realguo.web.controller;


import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.common.validator.ValidatorUtils;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 剧组
 */
@RestController
@RequestMapping("/crew")
public class CrewController extends AbstractController {
	@Autowired
	private CrewService crewService;


	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = crewService.queryPage(params);

		return R.ok().put("data", page);
	}

	@RequestMapping("/update")
	public R update(@RequestBody CrewEntity crew) {
		ValidatorUtils.validateEntity(crew);
		crewService.updateById(crew);
		return R.ok();
	}

	@RequestMapping("/delete")
	public R delete(@RequestBody CrewEntity crew) {
		ValidatorUtils.validateEntity(crew);
		crewService.deleteById(crew.getCrewId());
		return R.ok();
	}

	@RequestMapping("/create")
	public R create(@RequestBody CrewEntity crew) {
		ValidatorUtils.validateEntity(crew);
		crewService.insert(crew);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", crew);
		return R.ok().put("data", map);
	}
}
