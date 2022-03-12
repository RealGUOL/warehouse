package com.realguo.web.controller;

import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.common.validator.ValidatorUtils;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.service.CrewService;
import com.realguo.web.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 剧组
 */
@RestController
@RequestMapping("/depot")
public class DepotController extends AbstractController {
    @Autowired
    private DepotService depotService;


    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = depotService.queryPage(params);

        return R.ok().put("data", page);
    }

    @RequestMapping("/update")
    public R update(@RequestBody DepotEntity depot) {
        ValidatorUtils.validateEntity(depot);
        depotService.updateById(depot);//全部更新
        return R.ok();
    }
}
