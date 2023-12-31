package zw.co.equals.customersupportservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import zw.co.equals.customersupportservice.dto.UpdateAccountRequest;
import zw.co.equals.customersupportservice.dto.UpdateAccountResponse;
import zw.co.equals.customersupportservice.service.CustomerSupportService;
import zw.co.equals.customersupportservice.util.WebClientUtil;

@Slf4j
@Service
public class CustomerSupportServiceImpl implements CustomerSupportService {

    private final WebClient webClient;

    @Value("${eq.account-service-url}")
    private String url;

    public CustomerSupportServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public UpdateAccountResponse updateAccountType(UpdateAccountRequest updateAccountRequest) {
      log.info("Updating account: {}", updateAccountRequest);
        return webClient
                .post()
                .uri(url)
                .bodyValue(updateAccountRequest)
                .retrieve()
                .bodyToMono(UpdateAccountResponse.class)
                .doOnError(WebClientUtil::handleNettyExceptions)
                .block();
    }
}
