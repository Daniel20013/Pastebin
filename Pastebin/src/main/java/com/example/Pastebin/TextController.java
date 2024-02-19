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
        model.addAttribute("texts", new TextTemplate());
        return "index";
    }

    @GetMapping("/text")
    public String displayText(Model model) {
        List<TextTemplate> texts = textService.getText();
        model.addAttribute("texts", texts);
        return "displayText";
    }

    @PostMapping("/createText")
    public String createText(@ModelAttribute(value = "inputText") TextTemplate textTemplate) {
//        textService.createText(textTemplate);
        System.out.println(textTemplate + "~~~~~~~~~~~~ A FOST ACCESATA ~~~~~~~~~~~~~~");
        return "index";
    }
}
