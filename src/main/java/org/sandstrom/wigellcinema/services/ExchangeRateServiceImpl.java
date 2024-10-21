package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.models.ExchangeRateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@EnableCaching
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceImpl.class);

    @Value("${exchange.api.key}")
    private String apiKey;
    private static final String API_URL_TEMPLATE = "https://api.exchangeratesapi.io/latest?access_key=%s";

    @Cacheable(value = "exchangeRateUSD", unless = "#result == null")
    @Scheduled(fixedRate = 3600000) // Uppdatera varje timme
    public ExchangeRateResponse getExchangeRateToUSD() {
    String apiUrl = String.format(API_URL_TEMPLATE, apiKey, "SEK");
    logger.info("API URL: " + apiUrl);

    RestTemplate restTemplate = new RestTemplate();
    ExchangeRateResponse response = restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);

    logger.info("Exchange API Response: " + response);
    return response;
}
}



