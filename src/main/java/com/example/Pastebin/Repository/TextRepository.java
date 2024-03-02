package com.example.Pastebin.Repository;

import com.example.Pastebin.Entity.TextTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TextRepository extends JpaRepository<TextTemplate, Long> {
    Optional<TextTemplate> getTextByText(String text);
}
