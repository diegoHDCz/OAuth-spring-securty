package com.diegoczajka.securityclient.event.listener;

import com.diegoczajka.securityclient.entity.User;
import com.diegoczajka.securityclient.event.RegistrationCompleteEvent;
import com.diegoczajka.securityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //CREATE THE VERIFICATION TOKEN FOR THE USER
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //SEND MAIL TO USER
        String url =
                event.getApplicationUrl()
                        + "verifyRegistration?token="
                        + token;
        //sendVerificationEmail()
        log.info("Click the link to verify your account: {} ", url);
    }
}
