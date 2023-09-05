public class TestLine {
    public static void main(String[] args) {
        Line line1 = new Line(Color.PURPLE, 1.0, 2.0, 4.0, 6.0);
        Line line2 = new Line(Color.ORANGE, 3.0, 1.0, 7.0, 8.0);
        Line line3 = new Line(Color.TURQUOSE, 0.0, 0.0, 5.0, 5.0);
        Line line4 = new Line(Color.PINK, -2.0, -2.0, 1.0, 2.0);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
    }
}