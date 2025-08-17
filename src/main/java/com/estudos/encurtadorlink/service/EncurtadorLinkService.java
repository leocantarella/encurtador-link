package com.estudos.encurtadorlink.service;

import com.estudos.encurtadorlink.model.EncurtadorLink;
import com.estudos.encurtadorlink.repository.EncurtadorLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EncurtadorLinkService {

    @Autowired
    private EncurtadorLinkRepository encurtadorLinkRepository;

    String shortCode = UUID.randomUUID().toString().substring(0,6);

    public String encurtarLink(String urlOriginal) {
        // Adiciona http:// se não existir
        if (!urlOriginal.startsWith("http://") && !urlOriginal.startsWith("https://")) {
            urlOriginal = "http://" + urlOriginal;
        }

        String shortCode = UUID.randomUUID().toString().substring(0,6);
        EncurtadorLink link = new EncurtadorLink(urlOriginal, shortCode);
        encurtadorLinkRepository.save(link);
        return shortCode;
    }

    public Optional<EncurtadorLink> buscarShortCode(String shortCode) {
        return encurtadorLinkRepository.findByShortCode(shortCode);
    }

}
