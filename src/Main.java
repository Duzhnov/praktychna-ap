import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printPrimitiveInfo();
        readValuesFromUser();
    }

    private static void printPrimitiveInfo() {
        System.out.println(" Інформація про примітивні типи даних \n");

        printRow("Тип", "Розмір (біт)", "Мінімум", "Максимум");
        System.out.println("-".repeat(95));

        printRow("byte", Byte.SIZE + " (" + Byte.BYTES + " б)",
                String.valueOf(Byte.MIN_VALUE), String.valueOf(Byte.MAX_VALUE));

        printRow("short", Short.SIZE + " (" + Short.BYTES + " б)",
                String.valueOf(Short.MIN_VALUE), String.valueOf(Short.MAX_VALUE));

        printRow("int", Integer.SIZE + " (" + Integer.BYTES + " б)",
                String.valueOf(Integer.MIN_VALUE), String.valueOf(Integer.MAX_VALUE));

        printRow("long", Long.SIZE + " (" + Long.BYTES + " б)",
                String.valueOf(Long.MIN_VALUE), String.valueOf(Long.MAX_VALUE));

        printRow("float", Float.SIZE + " (" + Float.BYTES + " б)",
                String.valueOf(-Float.MAX_VALUE) + " (найменше додатне: " + Float.MIN_VALUE + ")",
                String.valueOf(Float.MAX_VALUE));

        printRow("double", Double.SIZE + " (" + Double.BYTES + " б)",
                String.valueOf(-Double.MAX_VALUE) + " (найменше додатне: " + Double.MIN_VALUE + ")",
                String.valueOf(Double.MAX_VALUE));

        printRow("char", Character.SIZE + " (" + Character.BYTES + " б)",
                "\\u" + String.format("%04X", (int) Character.MIN_VALUE) + " (" + (int) Character.MIN_VALUE + ")",
                "\\u" + String.format("%04X", (int) Character.MAX_VALUE) + " (" + (int) Character.MAX_VALUE + ")");

        printRow("boolean", "залежить від JVM", "false", "true");

        System.out.println();
    }

    private static void printRow(String type, String size, String min, String max) {
        System.out.printf("%-8s | %-16s | %-40s | %s%n", type, size, min, max);
    }


    private static void readValuesFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Введення значень \n");

        // byte
        System.out.print("Введіть значення типу byte (" + Byte.MIN_VALUE + " .. " + Byte.MAX_VALUE + "): ");
        try {
            byte b = Byte.parseByte(scanner.nextLine().trim());
            System.out.println("Ви ввели byte: " + b);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: некоректне значення для byte.");
        }

        // short
        System.out.print("Введіть значення типу short (" + Short.MIN_VALUE + " .. " + Short.MAX_VALUE + "): ");
        try {
            short s = Short.parseShort(scanner.nextLine().trim());
            System.out.println("Ви ввели short: " + s);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: некоректне значення для short.");
        }

        // int
        System.out.print("Введіть значення типу int: ");
        try {
            int i = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Ви ввели int: " + i);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: некоректне значення для int.");
        }

        // long
        System.out.print("Введіть значення типу long: ");
        try {
            long l = Long.parseLong(scanner.nextLine().trim());
            System.out.println("Ви ввели long: " + l);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: некоректне значення для long.");
        }

        // float
        System.out.print("Введіть значення типу float (наприклад, 3.14): ");
        try {
            float f = Float.parseFloat(scanner.nextLine().trim());
            System.out.println("Ви ввели float: " + f);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: некоректне значення для float.");
        }

        // double
        System.out.print("Введіть значення типу double (наприклад, 2.718281828): ");
        try {
            double d = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Ви ввели double: " + d);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: некоректне значення для double.");
        }

        // boolean
        System.out.print("Введіть значення типу boolean (true/false): ");
        boolean bool = Boolean.parseBoolean(scanner.nextLine().trim());
        System.out.println("Ви ввели boolean: " + bool);

        // char
        System.out.print("Введіть значення типу char (один символ): ");
        String line = scanner.nextLine();
        if (line.length() >= 1) {
            char c = line.charAt(0);
            System.out.println("Ви ввели char: '" + c + "' (код: " + (int) c + ")");
        } else {
            System.out.println("Помилка: порожній рядок, символ не введено.");
        }

        scanner.close();
    }
}