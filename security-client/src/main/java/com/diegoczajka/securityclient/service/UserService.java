package com.diegoczajka.securityclient.service;

import com.diegoczajka.securityclient.entity.User;
import com.diegoczajka.securityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
