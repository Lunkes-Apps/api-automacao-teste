package com.lnks.siteautomacaoapi.utils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
    private static final String SENHA = "123456";
    private final BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();

    @Test
    public void testGerarHash() throws Exception{
        String hash = PasswordUtils.gerarBCrypt(SENHA);
        assertTrue(enconder.matches(SENHA, hash));
    }
    
    @Test
    public void testSenhaNula() throws Exception{
        assertNull(PasswordUtils.gerarBCrypt(null));
    }
}