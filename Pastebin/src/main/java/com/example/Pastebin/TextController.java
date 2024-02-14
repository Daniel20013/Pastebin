package com.example.Pastebin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping(path = "/api/v1/pastebin")
public class TextController {
    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

//    @RequestMapping("/texts")
//    public String getText(Model model) {
//        TextTemplate textTemplate = (TextTemplate) textService.getText();
//        model.addAttribute("myText", textTemplate);
//        return "textTemplate.text";
//    }

    @GetMapping("/texts")
    public String getText(Model model) {
        TextTemplate textTemplate = (TextTemplate) textService.getText();
        model.addAttribute("myText", textTemplate);
        return "index.html";
    }

    @PostMapping
    public void createText(@RequestBody TextTemplate textTemplate) {
        textService.createText(textTemplate);
    }
}
