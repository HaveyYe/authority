package com.havey.controller;

import com.havey.model.ResponseBean;
import com.havey.model.VerificationCode;
import com.havey.model.entity.SysPermission;
import com.havey.service.SysPermissionService;
import com.havey.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    SysPermissionService sysPermissionService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String index() {
        return "Hello World!" + port;
    };

    @GetMapping("/login")
    @ResponseBody
    public ResponseBean login() {
        return ResponseBean.error("尚未登录");
    }
    @GetMapping("/verificode")
    public void verificode(HttpServletRequest request, HttpServletResponse response) {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession();
        session.setAttribute("ver_code", text);
        try {
            VerificationCode.output(image, response.getOutputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getCode")
    @ResponseBody
    public String getCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String code=(String)session.getAttribute("ver_code");
        return code;
    }

    @GetMapping("/getPermission")
    @ResponseBody
    public List<SysPermission> getPermission(Integer id) {
        List<SysPermission> selectListByUser = sysPermissionService.selectListByUser(id);
        return selectListByUser;
    }
}
