package main;

import java.util.Random;

public class CHOperation {


    /**
     * Fields
     */

    private int numberA, numberB;
    private String operator;
    private int resolvedOperation;
    private String operation;

    /**
     *
     * Getters & Setters
     */

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public int getNumberB() {
        return numberB;
    }

    public void setNumberB(int numberB) {
        this.numberB = numberB;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperation(){ return this.operation; }
    /**
     *
     * Constructors
     *
     */

    public CHOperation(){

    }

    public CHOperation(int range){
        this.numberA = this.getRandomNumber(range);
        this.numberB = this.getRandomNumber(range);
        this.operator = this.getAcumRandomOperator(); /* Al ser la primera operacion solo vamos a sumar o multiplicar*/
        this.resolvedOperation = this.resolveOperation();
        this.operation = String.format("%d%s%d", this.numberA,this.operator, this.numberB);
    }

    public CHOperation(int range, int numberA){
        this.numberA = numberA;
        this.numberB = this.getRandomNumber(range);
        this.operator = this.getRandomOperator();
        this.resolvedOperation = this.resolveOperation();
        this.operation = String.format("%d%s%d", this.numberA,this.operator, this.numberB);
    }




    public int resolveOperation() {
        int productResolved = 0;
        switch (this.operator){
            case "+":
                productResolved = this.numberA + this.numberB;
                break;
            case "-":
                productResolved = this.numberA - this.numberB;
                break;
            case "x":
                productResolved = this.numberA * this.numberB;
                break;
            case "/":
                productResolved = this.numberA % this.numberB;
        }
        return productResolved;
    }

    public int getRandomNumber(int range) {
        int number = new Random().nextInt(range);
        if (number<2)
            number = 2;
        return number;
    }

    public String getRandomOperator() {
        String[] operators = {"+","-","x","/"};
        return operators[new Random().nextInt(operators.length)];
    }

    private String getAcumRandomOperator(){
        String[] operators = {"+","x"};
        return operators[new Random().nextInt(operators.length)];
    }



}
