package com.example.Pastebin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

//    @RequestMapping("/texts")
//    public String getText(Model model) {
//        model.addAttribute("myText", textService.getText());
//        return "textTemplate";
//    }

//    @ModelAttribute("messages")
//    public List<TextTemplate> messages() {
//        return textService.getText();
//    }

//    @RequestMapping(value = "message", method = RequestMethod.GET)
//    public ModelAndView messages() {
//        ModelAndView mav = new ModelAndView("message/list");
//        mav.addObject("messages", textService.getText());
//        return mav;
//    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("messages", textService.getText());
        return "message/list";
    }

    @PostMapping
    public void createText(@RequestBody TextTemplate textTemplate) {
        textService.createText(textTemplate);
    }
}
