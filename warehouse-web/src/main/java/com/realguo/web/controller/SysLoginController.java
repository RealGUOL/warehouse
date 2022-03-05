package com.realguo.web.controller;

import com.google.common.collect.Lists;
import com.realguo.common.utils.R;
import com.realguo.web.config.shiro.ShiroUtils;
import com.realguo.web.form.LoginForm;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.code.kaptcha.Producer;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录相关
 */
@Controller
public class SysLoginController {
    @Autowired
    private Producer producer;

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public R login(@RequestBody LoginForm form) {
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error("账号或密码不正确");
        } catch (LockedAccountException e) {
            return R.error("账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
        return R.ok();
    }


    /**
     * 获取信息
     */
    @ResponseBody
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public R info() {
        Subject subject = ShiroUtils.getSubject();
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> list =  Lists.newArrayList();
        list.add("admin");
        map.put("roles", list);
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return R.ok().put("data", map);
    }

    /**
     * 退出
     */
    @RequestMapping(value = "user/logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }

}
