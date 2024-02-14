package com.example.Pastebin;

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
    public void createText(TextTemplate textTemplate) {
        validateText(textTemplate.getText());
        textRepository.save(textTemplate);
    }

    private void validateText(String text) {
        Optional<TextTemplate> textOptional = textRepository.getTextByText(text);
        if (textOptional.isPresent()) {
            throw new IllegalStateException(String.format("TextTemplate %s alerady exists", text));
        }
    }
}
