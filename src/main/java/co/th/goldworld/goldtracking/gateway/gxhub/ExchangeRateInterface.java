package co.th.goldworld.goldtracking.gateway.gxhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class ExchangeRateInterface {

    @Autowired
    RestTemplate restTemplate;

    public BigDecimal getExchangeRateToTHB(String currency){
        return restTemplate.getForEntity("/gxhub/api/rate?from=THB&to"+currency, BigDecimal.class).getBody();
    }
}
