package com.example.Pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TextController {
    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping("/")
    public String getText(Model model) {
        model.addAttribute("text", new TextTemplate());
        return "index";
    }

    @GetMapping("/text")
    public String displayText(Model model) {
        List<TextTemplate> texts = textService.getText();
        model.addAttribute("text", texts);
        return "displayText";
    }

    @GetMapping("/fullText")
    public String fullText(@RequestParam Long id, Model model) {
        TextTemplate textTemplate = textService.getOneText(id);
        model.addAttribute("fullText", textTemplate);
        return "fullText";
    }

    @PostMapping("/")
    public String createText(@ModelAttribute TextTemplate textTemplate, Model model) {
        model.addAttribute("text", textTemplate);
        textService.createText(textTemplate);
        return "wasCreatedSuccessfully";
    }
}
