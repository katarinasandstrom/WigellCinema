package org.sandstrom.wigellcinema.services;


import org.sandstrom.wigellcinema.models.ExchangeRateResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service

public interface ExchangeRateService {
    ExchangeRateResponse getExchangeRateToUSD();
}

