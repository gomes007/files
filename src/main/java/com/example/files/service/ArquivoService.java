package com.example.files.service;

import com.example.files.model.Arquivo;
import com.example.files.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.FileSystemNotFoundException;

@Service
public class ArquivoService {

    private final FileRepository fileRepository;

    public ArquivoService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    public Arquivo saveArquivo(MultipartFile arquivo) throws Exception {
        String filePath = "C:\\Users\\Paulo\\Desktop\\files\\" + arquivo.getOriginalFilename();
        File folder = new File("C:\\Users\\Paulo\\Desktop\\files\\");
        if (!folder.exists()) {
            folder.mkdir();
        }
        arquivo.transferTo(new File(filePath));

        Arquivo newArquivo = new Arquivo();
        newArquivo.setFileName(arquivo.getOriginalFilename());
        newArquivo.setFilePath(filePath);

        return fileRepository.save(newArquivo);
    }

    public Arquivo getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("Arquivo não encontrado" + id));
    }


}
