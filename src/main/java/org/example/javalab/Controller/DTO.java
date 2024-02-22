package org.example.javalab.Controller;


import java.util.List;

public class DTO {
    List<String> numList;
    List<String> emailList;


    public DTO(List<String> numList, List<String> emailList) {
        this.numList = numList;
        this.emailList = emailList;
    }

    public List<String> getNumList() {
        return numList;
    }

    public void setNumList(List<String> numList) {
        this.numList = numList;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }
}
