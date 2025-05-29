package Section2;

public class ImplicitCasting {

    boolean myBoolean;
    int myInt;//This variables are inicializaed by JVM

    public void implicitVars() {

        byte myByte = 5;
        char myChar = '@';

        short myShort = 6;
        long myLong = 23L;
        float myFloat = 3.14F;
        double myDouble = 2.64;

        System.out.println("Value of boolean primitive var as property of class is: " + myBoolean);
        System.out.println("implicit casting -> MyChar Var is: " + myChar + " in int is equal to: " + (myInt = myChar));

        int mySecondInt = 3450;
        //byte r1 = mySecondInt; error to cast it could be explicit

        byte r2 = (byte) mySecondInt;

        System.out.println("Result of explicit casting is this byte value: " + r2 + " of my int: " + mySecondInt);

    }
}
