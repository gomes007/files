package com.example.files.repository;

import com.example.files.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Arquivo, Long> {
}
