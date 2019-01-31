package com.alibaba.dubbo.config.ityongman;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
//import org.apache.dubbo.config.ApplicationConfig;
//import org.apache.dubbo.config.ProtocolConfig;
//import org.apache.dubbo.config.RegistryConfig;
//import org.apache.dubbo.config.ServiceConfig;
import org.junit.Test;

public class ProviderServiceTest {

    @Test
    public void providerTest() {
        //1. 声明接口服务
        IAccountService accountService = new AccountServiceImpl() ;
        //2. 设置应用信息
        ApplicationConfig application = new ApplicationConfig();
        application.setName("accountService");

        //3. 设置配置信息
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("127.0.0.1:2181");
        //4. 设置协议信息
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12345);
        protocol.setThreads(200);

        //5. 服务提供者暴露服务
        ServiceConfig<IAccountService> service = new ServiceConfig<IAccountService>();
        service.setApplication(application);
        service.setRegistry(registry);
        service.setProtocol(protocol);
        service.setInterface(IAccountService.class);
        service.setRef(accountService);
        service.setVersion("1.0.1");

        //6. 暴露服务
        service.export();
    }
}
