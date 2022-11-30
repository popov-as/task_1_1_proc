import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        float sideA = readTriangleSide("A", scanner);
        float sideB = readTriangleSide("B", scanner);
        float sideC = readTriangleSide("C", scanner);

        float heightA = getTriangleHeight(sideA, sideB, sideC, sideA);
        float heightB = getTriangleHeight(sideA, sideB, sideC, sideB);
        float heightC = getTriangleHeight(sideA, sideB, sideC, sideC);

        printTriangleHeight("A", heightA);
        printTriangleHeight("B", heightB);
        printTriangleHeight("C", heightC);
    }

    /**
     * Вычисление высоты треугольника
     */
    private static float getTriangleHeight(float sideA, float sideB, float sideC, float side)
    {
        // Сначала назвал semiperimeter, потом переименовал в p
        float p = (sideA + sideB + sideC) / 2;
        return 2 / side * (float) Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Ввод стороны треугольника
     */
    private static float readTriangleSide(String sideName, Scanner scanner)
    {
        System.out.printf("Введите длину стороны %s треугольника: ", sideName);
        float side = scanner.nextFloat();

        if (side <= 0) throw new IllegalArgumentException("Длина должна быть больше нуля");

        return side;
    }

    /**
     * Вывод высоты треугольника
     */
    private static void printTriangleHeight(String sideName, float height)
    {
        System.out.printf("Высота стороны %s: %.3f\n", sideName, height);
    }
}