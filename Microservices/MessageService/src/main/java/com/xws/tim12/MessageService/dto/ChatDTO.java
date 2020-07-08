package com.xws.tim12.MessageService.dto;

public class ChatDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChatDTO{" +
                "name='" + name + '\'' +
                '}';
    }

}
