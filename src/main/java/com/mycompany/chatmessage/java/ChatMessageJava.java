/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatmessage.java;

import java.util.Random;

/**
 *
 * @author Student
 */
public class ChatMessageJava {

    public static void main(String[] args) {
        System.out.println("Hello World!");
   import java.util.Random;

public class ChatMessage {
    private String id;
    private final String recipient;
    private final String text;
    private final String hash;
    private final String flag; // Sent, Stored, Disregard

    public ChatMessage(String recipient, String text, String flag, int index) {
        this.recipient = recipient;
        this.text = text;
        this.flag = flag;
        this.id = generateId();
        this.hash = createHash(index);
    }

    private String generateId() {
        Random r = new Random();
        long num = (long)(r.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(num);
    }

    // Special: For test data 4, ID must be 0838884567 to pass unit test
    public void setIdForTest(String customId) {
        this.id = customId;
    }

    public final String createHash(int numSent) {
        String firstTwo = id.substring(0,2);
        String[] words = text.trim().split("\\s+");
        String first = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String last = words[words.length-1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        return firstTwo + ":" + numSent + ":" + first + last;
    }

    public String checkRecipientCell() {
        if (recipient.startsWith("+") && recipient.length() <= 13) return "Cell phone number successfully captured.";
        else return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }

    public String getId() { return id; }
    public String getRecipient() { return recipient; }
    public String getText() { return text; }
    public String getHash() { return hash; }
    public String getFlag() { return flag; }
} }

