package cn.mvc.controller;

import cn.mvc.pojo.UserAccount;
import cn.mvc.service.EmpyService;
import cn.mvc.tools.DeNEnCoder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private EmpyService empyService;

    @RequestMapping("/Login")
    public String tologin(Model model) {
        return "Login";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //获取用户的主体对象就可以了
        Subject subject = SecurityUtils.getSubject();
        //封装用户名和密码的认证信息对象
        UsernamePasswordToken upt = new UsernamePasswordToken(account, DeNEnCoder.Encode(password));
        //进行登录认证
        try {
            subject.login(upt);
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("用户名或者密码错误");
            return "Login";
        }
        //UserAccount userAccount = (UserAccount) SecurityUtils.getSubject().getPrincipal();
        return "platform";
    }
}
