package com.becomejavasenior.jdbc.service;

import com.becomejavasenior.jdbc.entity.Language;
import com.becomejavasenior.jdbc.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, User> getUserMap();

    String createNewUser(String name, String password, String email, int langId);

    List<Language> getLanguageList();
}
