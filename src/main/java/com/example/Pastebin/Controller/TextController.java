package com.example.Pastebin.Controller;

import com.example.Pastebin.Service.TextService;
import com.example.Pastebin.Entity.TextTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/pastebin")
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

    @GetMapping("/texts")
    public String displayText(Model model) {
        List<TextTemplate> texts = textService.getText();
        model.addAttribute("texts", texts);
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
        String validationMessage;
        try {
            validationMessage = textService.validateText(textTemplate.getText());
            textService.createText(textTemplate);
            model.addAttribute("textExista", false);
        } catch (IllegalStateException e) {
            validationMessage = e.getMessage();
            model.addAttribute("textExista", true);
        }
        model.addAttribute("validationMessage", validationMessage);
        model.addAttribute("text", textTemplate);
        return "index";
    }
}
