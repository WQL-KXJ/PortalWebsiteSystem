package com.wuhao.wuhaozn_springboot.config;

import com.wuhao.wuhaozn_springboot.shiro.realm_;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class shiro_filter  {

        @Bean
        public ShiroFilterFactoryBean getshiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

            shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

            Map<String,String> map =new HashMap<String, String>();
            map.put("/login","anon");
            map.put("/","anon");
            map.put("/user/**","authc");

            shiroFilterFactoryBean.setLoginUrl("/");
            shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
            return shiroFilterFactoryBean;
        }

        @Bean
    public DefaultWebSecurityManager getdefaultWebSecurityManager(Realm realm){

            DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

            defaultWebSecurityManager.setRealm(realm);

            return defaultWebSecurityManager;
        }

        @Bean
        public Realm getrealm(){

            realm_ realm =new realm_();

            return  realm;
        }

}
