package _0_intro._0_washing_machine;

import java.io.IOException;

public class App04 {
    public static void main(String[] args) throws IOException {
        try {
            int area = area(-10, 20);
            System.out.println("Area = " + area);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad...");
        }
        System.out.println("Next");
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width < 0 || height < 0 == true, " +
                    "width = " + width + " height = " + height);
        }
        return width * height;
    }
}
