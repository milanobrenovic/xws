package com.xws.tim12.MessageService.dto;

public class GreetingDTO {

    private String content;

    public GreetingDTO() {}

    public GreetingDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "GreetingDTO{" +
                "content='" + content + '\'' +
                '}';
    }

}
