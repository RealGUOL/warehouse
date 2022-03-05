package com.realguo.web.controller;


import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.web.service.CrewService;
import com.realguo.web.service.PropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
