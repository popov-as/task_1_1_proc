import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double[] sides = readTriangleSides(scanner);
        double[] heights = calcTriangleHeights(sides);
        printTriangleHeights(heights);
    }

    /**
     * Вычисление высот
     */
    private static double[] calcTriangleHeights(double[] sides)
    {
        double semiPerimeter = Arrays.stream(sides).sum() / 2;

        double coef = 1;
        for (int i = 0; i < sides.length; i++) {
            coef = coef * (semiPerimeter - sides[i]);
        }
        // Одинаковая часть (база) для расчета высот
        double base = 2 * Math.sqrt(semiPerimeter * coef);

        double[] heights = new double[3];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = base / sides[i];
        }

        return heights;
    }

    /**
     * Ввод сторон треугольника
     */
    private static double[] readTriangleSides(Scanner scanner)
    {
        System.out.println("Введите длины сторон треугольника через пробел:");
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = scanner.nextDouble();
        }
        return sides;
    }

    /**
     * Вывод высот треугольника
     */
    private static void printTriangleHeights(double[] heights)
    {
        for (int i = 0; i < heights.length; i++) {
            System.out.printf("Высота %d: %.3f\n", i + 1, heights[i]);
        }
    }
}