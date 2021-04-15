package com.wuhao.wuhaozn_springboot.shiro;

import com.wuhao.wuhaozn_springboot.bean.login_bean;
import com.wuhao.wuhaozn_springboot.server.login_server;
import com.wuhao.wuhaozn_springboot.util.applicationContextUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

public class realm_ extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String  principal = (String) authenticationToken.getPrincipal();

        applicationContextUtil applicationContexts =  new applicationContextUtil();

        login_server loginServer = (login_server) applicationContexts.getlogin_server("login_server");

        login_bean loginbean=loginServer.get_login(principal);

        if(!ObjectUtils.isEmpty(loginbean)){

            SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo(loginbean.getUsername(),loginbean.getPassword(),this.getName());

            return simpleAuthenticationInfo;
        }

        return null;
    }
}
