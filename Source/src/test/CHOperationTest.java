package test;

import main.CHOperation;
import org.junit.Assert;
import org.junit.Test;

public class CHOperationTest {

    @Test
    public void shouldCreateARandomNumber() {
        CHOperation operation = new CHOperation();
        int number = operation.getRandomNumber(10);
        boolean expected = false;
        if (number > 0 && number < 11){
            expected = true;
        }
        Assert.assertTrue(expected);

    }

    @Test
    public void shouldCreateARandomOperator() {
        CHOperation operation = new CHOperation();
        String operator = operation.getRandomOperator();
        String[] operators = {"+","-","x","/"};
        for (String op: operators) {
            if (operator == op){
                Assert.assertTrue(true);
            }
        }
    }

    @Test
    public void shouldResolveADefinedOperation() {
        CHOperation operation = new CHOperation();
        operation.setNumberA(25);
        operation.setNumberB(4);
        operation.setOperator("x");
        Assert.assertEquals(100, operation.resolveOperation());
    }
}