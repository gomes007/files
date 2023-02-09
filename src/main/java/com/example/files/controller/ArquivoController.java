package com.example.files.controller;

import com.example.files.model.Arquivo;
import com.example.files.service.ArquivoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    private final ArquivoService arquivoService;

    public ArquivoController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @PostMapping
    public Arquivo uploadFile(@RequestParam("arquivo")MultipartFile arquivo) throws Exception {
        return arquivoService.saveArquivo(arquivo);
    }

    @GetMapping("/{id}")
    public Arquivo getArquivoById(@PathVariable Long id) {
        return arquivoService.getFileById(id);
    }

}
