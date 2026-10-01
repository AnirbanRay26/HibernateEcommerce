package com.ecommerce;

import org.junit.jupiter.api.Test;

import com.ecommerce.util.PasswordUtil;

import static org.junit.jupiter.api.Assertions.*;

public class CrudTest {

    @Test
    void passwordHashingTest() {

        String password = "hello123";

        String hashed = PasswordUtil.hashPassword(password);

        assertNotNull(hashed);
        assertNotEquals(password, hashed);

        assertTrue(
                PasswordUtil.checkPassword(password, hashed)
        );

        assertFalse(
                PasswordUtil.checkPassword("wrong", hashed)
        );
    }
}