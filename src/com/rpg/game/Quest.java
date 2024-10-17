package com.rpg.game;

public class Quest {
    private String name;
    private int progress;
    private String description;

    public Quest(String name, String description) {
        this.name = name;
        this.description = description;
        this.progress = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setProgress(int progress){
        this.progress = progress;
    }

    public int getProgress(){
        return progress;
    }

    public void displayQuest() {
        System.out.println(name);
        System.out.println(description);
    }
}


