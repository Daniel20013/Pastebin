package com.example.Pastebin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/pastebin")
public class TextController {
    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping("/text")
    public String getText(Model model) {
        List<TextTemplate> texts = textService.getText();
        model.addAttribute("texts", texts);
        System.out.println("~~~~~~~~~~~~~~~~~  A FOST ACCESAT  ~~~~~~~~~~~~~~~~");
        return "displayText";
    }

    @PostMapping(path = "/create")
    public void createText(@RequestBody TextTemplate textTemplate) {
        textService.createText(textTemplate);
    }
}
