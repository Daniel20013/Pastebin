package com.example.Pastebin;

import java.util.List;

public interface ITextService {
    List<TextTemplate> getText();

    void createText(TextTemplate textTemplate);
}
