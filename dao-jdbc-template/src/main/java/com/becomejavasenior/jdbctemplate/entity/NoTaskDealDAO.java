package com.becomejavasenior.jdbctemplate.entity;

import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */
public interface NoTaskDealDAO {
    BigInteger getTotalNoTaskNum();
    BigInteger getTotalWithTaskNum();
}
