package com.example.Pastebin.Service;

import com.example.Pastebin.Repository.TextRepository;
import com.example.Pastebin.Entity.TextTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TextService implements ITextService {
    private final TextRepository textRepository;

    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public List<TextTemplate> getText() {
        return textRepository.findAll();
    }

    @Override
    public TextTemplate getOneText(Long id) {
        return textRepository.getById(id);
    }

    @Override
    public void createText(TextTemplate textTemplate) {
        validateText(textTemplate.getText());
        textRepository.save(textTemplate);
    }

    public String validateText(String text) {
        Optional<TextTemplate> textOptional = textRepository.getTextByText(text);
        if (textOptional.isPresent()) {
            throw new IllegalStateException(String.format(" %s already exists", text));
        } else {
            return "Text saved successfully";
        }
    }

}
