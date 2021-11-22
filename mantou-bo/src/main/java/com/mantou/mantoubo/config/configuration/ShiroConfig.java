package com.mantou.mantoubo.config.configuration;

import com.mantou.mantoubo.basic.common.constant.UtilConstants;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lm
 * @title: ShiroConfig
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2120:17
 */
@Configuration
public class ShiroConfig {

    /**
     * 设置安全管理器
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        // 设置拦截，添加内置过滤器
        /**
         * anon: 配置不会被拦截的请求 顺序判断
         * authc: 配置拦截的请求
         * user: 必有拥有记住我功能才能用
         * perms: 有用对某个资源的权限才能访问
         * role: 拥有某个角色才能访问
         */
        Map<String,String> filterChain = new LinkedHashMap<String,String>();
        filterChain.put("/base/v1.0/register","anon");
        filterChain.put("/base/v1.0/render","anon");
        filterChain.put("/base/v1.0/doLogin","anon");
        filterChain.put("/sys/*","authc");
        bean.setFilterChainDefinitionMap(filterChain);
        return bean;
    }

    /**
     * manager关联realm
     * @param mantouRealm
     * @return
     */
    @Bean(name = "getSecurityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("mantouRealm") MantouRealm mantouRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(mantouRealm);
        return securityManager;
    }

    /**
     * 自有realm
     * @return
     */
    @Bean(name = "mantouRealm")
    public MantouRealm mantouRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher){
        MantouRealm shiroRealm = new MantouRealm();
        shiroRealm.setCredentialsMatcher(matcher);
        return shiroRealm;
    }

    /**
     *  密码凭证匹配器，作为自定义认证的基础
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher matcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(UtilConstants.Public.ENCRYPTION_TYPE);// 散列类型
        matcher.setHashIterations(UtilConstants.Public.ENCRYPTION_TIMES);// 散列次数
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    
}
