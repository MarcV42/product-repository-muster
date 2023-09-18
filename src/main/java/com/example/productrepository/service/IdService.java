package com.example.productrepository.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {


        public String randomId() {
            // Verwenden Sie die UUID-Klasse, um eine zufällige ID zu generieren
            return UUID.randomUUID().toString();
        }



        }



