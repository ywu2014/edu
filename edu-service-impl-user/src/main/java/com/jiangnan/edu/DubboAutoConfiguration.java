package com.jiangnan.edu;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 吴叶俊
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)//开启属性注入,通过@autowired注入
@ConditionalOnClass({AnnotationBean.class,ApplicationConfig.class,ProtocolConfig.class,RegistryConfig.class})
public class DubboAutoConfiguration {
    @Autowired
    private DubboProperties prop;

    @Bean
    @ConditionalOnMissingBean(AnnotationBean.class)//容器中如果没有这个类,那么自动配置这个类
    public static AnnotationBean annotationBean(@Value("${dubbo.packageName}")String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }

    @Bean
    @ConditionalOnMissingBean(ApplicationConfig.class)//容器中如果没有这个类,那么自动配置这个类
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(prop.getApplication().getName());
        return applicationConfig;
    }

    @Bean
    @ConditionalOnMissingBean(ProtocolConfig.class)//容器中如果没有这个类,那么自动配置这个类
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(prop.getProtocol().getName());
        protocolConfig.setPort(prop.getProtocol().getPort());
        return protocolConfig;
    }

    @Bean
    @ConditionalOnMissingBean(RegistryConfig.class)//容器中如果没有这个类,那么自动配置这个类
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(prop.getRegistry().getAddress());
        return registryConfig;
    }
}
