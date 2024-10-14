package org.sandstrom.wigellcinema.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.ServletOutputStream;
import org.sandstrom.wigellcinema.dao.BookingCVenueRepository;
import org.sandstrom.wigellcinema.entities.BookingCVenue;
import org.sandstrom.wigellcinema.models.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookingCVenueServiceImpl implements BookingCVenueService {

    @Autowired
    private BookingCVenueRepository bookingCVenueRepository;

    @Autowired
    private ExchangeRateService exchangeRateService; // Injektera ExchangeRateService

    @Override
    public List<BookingCVenue> findAllBookingsByCustomerId(int customerId) {
        return bookingCVenueRepository.findByCustomerId(customerId);
    }

    @Override
    public BookingCVenue save(BookingCVenue bookingCVenue) {
        BigDecimal priceInUSD = calculatePriceInUSD(bookingCVenue.getTotalPriceSEK());
        System.out.println("Priset i USD är " + priceInUSD);
        bookingCVenue.setTotalPriceUSD(priceInUSD);

        return bookingCVenueRepository.save(bookingCVenue);
    }

    @Override
    public void deleteById(int id) {
        bookingCVenueRepository.deleteById(id);
    }

    private BigDecimal calculatePriceInUSD(BigDecimal priceInSEK) {
        ExchangeRateResponse exchangeRate = exchangeRateService.getExchangeRateToUSD();

        if (exchangeRate != null && exchangeRate.getRates() != null) {
            BigDecimal usdRate = exchangeRate.getRate("USD");
            BigDecimal sekRate = exchangeRate.getRate("SEK");
            if (usdRate != null && sekRate != null) {
                BigDecimal priceInUSD = priceInSEK.divide(sekRate, 4, BigDecimal.ROUND_HALF_UP).multiply(usdRate);
                return priceInUSD.setScale(2, BigDecimal.ROUND_HALF_UP);
            }
        }

        return BigDecimal.ZERO; // Returnera 0 om växelkursen inte kan hämtas
    }
}
