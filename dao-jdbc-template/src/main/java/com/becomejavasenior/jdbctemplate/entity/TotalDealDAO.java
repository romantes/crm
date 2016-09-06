package com.becomejavasenior.jdbctemplate.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */
public interface TotalDealDAO {
    BigInteger getTotalNumOfDeals();
    BigDecimal getTotalDealBudget();
}
