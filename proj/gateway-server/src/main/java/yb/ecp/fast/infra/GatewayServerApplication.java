package yb.ecp.fast.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.DefaultCookieSerializer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 180000)
@EnableScheduling
public class GatewayServerApplication {
    public static void main(String[] a) {
        SpringApplication.run(GatewayServerApplication.class, a);
    }


    @Bean
    public DefaultCookieSerializer defaultCookieSerializer(@Value("${server.session.cookie.name:BJ_SESSION}") String a) {
        DefaultCookieSerializer tmp7_4 = new DefaultCookieSerializer();
        tmp7_4.setCookieName(a);
        return tmp7_4;
    }

}
