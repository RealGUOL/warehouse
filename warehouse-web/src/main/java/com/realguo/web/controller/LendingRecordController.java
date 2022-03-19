package com.realguo.web.controller;

import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.R;
import com.realguo.common.validator.ValidatorUtils;
import com.realguo.web.entity.LendingRecordEntity;
import com.realguo.web.service.LendingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 出借记录
 */
@RestController
@RequestMapping("/record")
public class LendingRecordController extends AbstractController {

    @Autowired
    private LendingRecordService lendingRecordService;


    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lendingRecordService.queryPage(params);

        return R.ok().put("data", page);
    }

    @RequestMapping("/update")
    public R update(@RequestBody LendingRecordEntity lendingRecord) {
        ValidatorUtils.validateEntity(lendingRecord);
        lendingRecordService.updateById(lendingRecord);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody LendingRecordEntity lendingRecord) {
        ValidatorUtils.validateEntity(lendingRecord);
        lendingRecordService.deleteById(lendingRecord.getDepotId());
        return R.ok();
    }

    @RequestMapping("/create")
    public R create(@RequestBody LendingRecordEntity lendingRecord) {
        ValidatorUtils.validateEntity(lendingRecord);
        lendingRecordService.save(lendingRecord);
        // 检查道具所在仓库是否有库存
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("item", lendingRecord);
        return R.ok().put("data", map);
    }
}
