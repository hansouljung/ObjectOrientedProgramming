public class Line {
    private Color color;
    private double x1, y1, x2, y2;

    public Line(Color color, double x1, double y1, double x2, double y2) {
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double length() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return color + " (" + x1 + "," + y1 + ")-(" + x2 + "," + y2 + ") has the length of" + length();
    }
}
