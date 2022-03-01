package com.realguo.web.config.shiro;

import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ShiroLoginFilter extends UserFilter {

    @SneakyThrows
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        HashMap<String, String> map = Maps.newHashMap();
        map.put("error", "登录已失效或未登录，请重新登录！");
        response.getWriter().print(map);
    }

}
