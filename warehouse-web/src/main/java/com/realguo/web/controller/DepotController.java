package com.realguo.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.common.validator.ValidatorUtils;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.service.DepotService;
import com.realguo.web.vo.DepotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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

    @RequestMapping("/search")
    public R search(@RequestBody Map<String, String> params) {
        final List<DepotVO> res = depotService.selectListVO(new EntityWrapper<DepotEntity>()
                .setSqlSelect("depot_id, depot_name")
                .like("depot_name", params.get("keyword")));

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("items", res);
        return R.ok().put("data", map);
    }

    @RequestMapping("/update")
    public R update(@RequestBody DepotEntity depot) {
        ValidatorUtils.validateEntity(depot);
        depotService.updateById(depot);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody DepotEntity depot) {
        ValidatorUtils.validateEntity(depot);
        depotService.deleteById(depot.getDepotId());
        return R.ok();
    }

    @RequestMapping("/create")
    public R create(@RequestBody DepotEntity depot) {
        ValidatorUtils.validateEntity(depot);
        depotService.insert(depot);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("item", depot);
        return R.ok().put("data", map);
    }
}
