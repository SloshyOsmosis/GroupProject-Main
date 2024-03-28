package com.example.myapplication;

import java.io.Serializable;

public class CustomCard implements Serializable {
    private int imageResource;
    private String message;
    private String senderName;
    private String recipientName;
    public CustomCard(int imageResource, String message, String senderName, String recipientName) {
        this.imageResource = imageResource;
        this.message = message;
        this.senderName = senderName;
        this.recipientName = recipientName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
}
