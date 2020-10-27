package cn.mvc.realm;

import cn.mvc.pojo.UserAccount;
import cn.mvc.service.EmpyService;
import cn.mvc.tools.DeNEnCoder;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现自定义域
 * Authorization 授权（权限校验）
 * <p>
 * Authentication 认证（登录校验）
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private EmpyService empyService;

    //获取授权信息
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前的用户对象
//        WeChatBind user = (WeChatBind) principalCollection.getPrimaryPrincipal();
//        if(user==null || "".equals(user.getEmpyNo())){
//            return null;
//        }
//        //查询用户有哪些权限
//        List<String> list = empyService.getRole(user.getEmpyNo());
//        //创建授权对象
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //把用户能操作的资源的信息放置到授权对象中
//        info.addStringPermissions(list);
        return null;
    }

    //获取认证信息
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名 不过一般往shiro中放置用户身份信息的时候，不直接放用户名字符串，放用户对象
        String username = token.getPrincipal().toString();
        //有了用户名，要根据用户名在数据库中查询用户对象
        UserAccount userAccount = new UserAccount();
        userAccount.setEmployeeId("123");
        try {
            userAccount.setPassword(DeNEnCoder.Encode("123"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Empy user = wechatService.queryOpenid(openid);
        //判断如果用户对象不存在，抛出UnknownAccountException
//        if(user==null){
//            throw new UnknownAccountException("用户名不存在");
//        }
        //封装用户的身份对象 返回这个身份对象
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userAccount, userAccount.getPassword(), "authRealm");
        return info;
    }
}