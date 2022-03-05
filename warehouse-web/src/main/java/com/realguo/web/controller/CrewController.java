package com.realguo.web.controller;


import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.web.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

		return R.ok().put("page", page);
	}
}
