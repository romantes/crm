package com.becomejavasenior.jdbctemplate.entity;

import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */
public interface CompletedDealDAO {
    BigInteger getTotalCompletedNum();
    BigInteger getTotalIncomletedNum();
}
