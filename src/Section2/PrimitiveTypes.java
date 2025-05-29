package Section2;

public class PrimitiveTypes {

    private int BYTES_TO_BITS = 8;
    private String BITS = " bits";

    public void showBytes() {

        System.out.println("PRIMITIVE TYPES SIZES.");

        System.out.println("byte data type has: " + Byte.BYTES * BYTES_TO_BITS + BITS);
        System.out.println("short data type has: " + Short.BYTES * BYTES_TO_BITS + BITS);
        System.out.println("char data type has: " + Character.BYTES * BYTES_TO_BITS + BITS);
        System.out.println("int data type has: " + Integer.BYTES * BYTES_TO_BITS + BITS);
        System.out.println("float data type has: " + Float.BYTES * BYTES_TO_BITS + BITS);
        System.out.println("long data type has: " + Long.BYTES * BYTES_TO_BITS + BITS);
        System.out.println("double data type has: " + Double.BYTES * BYTES_TO_BITS + BITS);
    }

}
