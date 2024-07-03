package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VendingMachine {


    public List<Baubles> baublesList;
    private final List<Baubles> prizebaublesList;


    public VendingMachine(){
        baublesList = new ArrayList<>();
        prizebaublesList = new ArrayList<>();
    }

    public void addBauble(int id, String name, int quantity, double frequency){
        Baubles bauble = new Baubles(id, name, quantity, frequency);
        baublesList.add (bauble);
    }


    public void printBaubles(List<Baubles> baublesList){
        for (Baubles bauble : baublesList){
            System.out.println(bauble.getId() + ". " + bauble.getName() + ", quantity - " + bauble.getQuantity() + ", frequency: " + bauble.getFrequency());
        }
    }

    public void baublesFrequency(int id, double frequency) {
        for (Baubles bauble : baublesList) {
            if (bauble.getId() == id) {
                bauble.setFrequency(frequency);
                break;
            }
        }
    }

    public void definitionOfPrizeBauble() throws IOException {
        double sumFrequency = 0;
        for (Baubles bauble : baublesList) {
            sumFrequency = sumFrequency + bauble.getFrequency();
        }
        Random rand = new Random();
        double randomNumber = rand.nextDouble() * sumFrequency;
        Baubles prizeBauble = null;
        for (Baubles bauble : baublesList) {
            if (randomNumber < bauble.getFrequency()) {
                prizeBauble = bauble;
                baublesList.remove(bauble);
                break;
            }
            randomNumber = randomNumber - bauble.getFrequency();
        }
        if (prizeBauble != null && prizeBauble.getFrequency() > 0) {
            prizebaublesList.add(prizeBauble);
            prizeBauble.setFrequency(0);
        }
    }


    public void prizeList() throws IOException {
        if (prizebaublesList.size() > 0) {
            Baubles prizeBauble = prizebaublesList.remove(0);
            FileWriter writer = new FileWriter("Prize.txt", true);
            writer.write(prizeBauble.getName() + "\n");
            writer.close();
        }
    }
}