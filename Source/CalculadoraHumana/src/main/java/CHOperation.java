import java.util.Random;

public class CHOperation {


    /**
     * Fields
     */

    private int numberA, numberB;
    private String operator;
    private int resolvedOperation;

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
        this.operator = this.getRandomOperator();
        this.resolvedOperation = this.resolveOperation();
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
        return new Random().nextInt(10);
    }

    public String getRandomOperator() {
        String[] operators = {"+","-","x","/"};
        return operators[new Random().nextInt(operators.length)];
    }


}
