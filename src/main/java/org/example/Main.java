package org.example;


import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        VendingMachine vm = new VendingMachine();
        vm.addBauble(1, "Cat", 4, 20);
        vm.addBauble(2, "Elephant", 27, 20);
        vm.addBauble(3, "Turtle", 20, 5);
        vm.addBauble(4, "Lion", 5, 10);
        vm.addBauble(5, "Tiger", 22, 25);
        vm.addBauble(6, "Dog", 24, 10);
        vm.addBauble(7, "Wolf", 30, 10);



        vm.baublesFrequency(4, 20);
        vm.printBaubles(vm.baublesList);
        System.out.println("\n");
        vm.definitionOfPrizeBauble();
        vm.printBaubles(vm.baublesList);
        vm.prizeList();
    }
}