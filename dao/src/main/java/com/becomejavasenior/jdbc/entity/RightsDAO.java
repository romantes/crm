package com.becomejavasenior.jdbc.entity;

import java.util.List;

public interface RightsDAO extends GenericDAO<Rights> {
    List<Rights> getRightsByUserId(int userId);
}
