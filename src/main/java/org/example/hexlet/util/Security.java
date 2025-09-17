package org.example.hexlet.util;

import org.apache.commons.lang3.RandomStringUtils;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    public static String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes();
            byte[] hashedBytes = md.digest(passwordBytes);

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String generateToken() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    public static String encryptSession(String password) {
        var hashed = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        return hashed;
    }
}
