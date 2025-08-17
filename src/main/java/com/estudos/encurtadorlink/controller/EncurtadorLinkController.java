package com.estudos.encurtadorlink.controller;


import com.estudos.encurtadorlink.model.EncurtadorLink;
import com.estudos.encurtadorlink.repository.EncurtadorLinkRepository;
import com.estudos.encurtadorlink.service.EncurtadorLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/link")
public class EncurtadorLinkController {

    @Autowired
    private EncurtadorLinkService encurtadorLinkService;

    //Criar o link encurtado
    @PostMapping("/encurtar")
    public String encurtar(@RequestBody String linkOriginal){
        String shorCode = encurtadorLinkService.encurtarLink(linkOriginal);
        return "http://localhost:8080/link/" + shorCode;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirecionar(@PathVariable String shortCode) {
        return encurtadorLinkService.buscarShortCode(shortCode)
                .map(link -> ResponseEntity.status(302)
                        .header("Location", link.getLinkOriginal())
                        .build())
                .orElse(ResponseEntity.notFound().build());
    }
}

