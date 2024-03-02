package com.example.Pastebin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "text")
public class TextTemplate {
    @Id
    @SequenceGenerator(
            name = "text_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "text_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String text;

    public TextTemplate() {}

    public TextTemplate(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
