package com.example.Pastebin;

import java.util.List;

public interface ITextService {
    List<TextTemplate> getText();

    TextTemplate getOneText(Long id);

    void createText(TextTemplate textTemplate);
}
