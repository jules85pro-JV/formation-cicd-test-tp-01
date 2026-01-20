package com.devops.cicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPolicyTest {

    PasswordPolicy police = new PasswordPolicy();

    @Test
    public void checkPasswordStrong(){
        assertTrue(police.isStrong("test"));
        assertFalse(police.isStrong(null));
    }
}
