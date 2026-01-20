package com.ey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

    private static final Logger log = LoggerFactory.getLogger(Password.class);

    public static void main(String[] args) {
        log.info("Generating bcrypt password");
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }
}
