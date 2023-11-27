package zw.co.equals.customersupportservice.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;
import java.util.concurrent.TimeUnit;

import static zw.co.equals.customersupportservice.constants.RestClientConstants.WIRETAP_CATEGORY;

@Slf4j
@Configuration
public class WebClientConfig {

    @Value("${webclient.read-timeout}")
    private int readTimeOut;
    @Value("${webclient.conn-timeout}")
    private int connectionTimeOut;

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient
                .create()
                .doOnConnected(
                        conn -> conn
                                .addHandlerLast(new ReadTimeoutHandler(readTimeOut, TimeUnit.SECONDS)))
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeOut)
                .wiretap(WIRETAP_CATEGORY,
                        LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
        return WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

}
