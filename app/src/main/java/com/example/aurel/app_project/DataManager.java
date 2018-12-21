package com.example.aurel.app_project;

import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;
    private List<String> nameList;

    private DataManager(){

    }

    public static DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public List<String> getNameList(){
        return nameList;
    }

    public void setNameList(List<String> name_){
        nameList = name_;
    }

    public void addItem(String name){
        nameList.add(name);
    }
}
