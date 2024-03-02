package com.example.Pastebin.Service;

import com.example.Pastebin.Entity.TextTemplate;

import java.util.List;

public interface ITextService {
    List<TextTemplate> getText();

    TextTemplate getOneText(Long id);

    void createText(TextTemplate textTemplate);
}
