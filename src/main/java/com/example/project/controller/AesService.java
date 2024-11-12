package com.example.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AesService {

    private final AesBytesEncryptor encryptor;

    public String Encode(String userpw) throws Exception {
        byte[] encrypt = encryptor.encrypt(userpw.getBytes(StandardCharsets.UTF_8));
        return new String(encrypt);
    }
}
