package pl.edu.pja.gui.lan.zadanie18;

public class Silnik {

    private final double a;
    private final double b;
    private final double c;
    private final double delta;
    private final double pDelta;

    public Silnik(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delta = b * b - 4 * a * c;
        this.pDelta = Math.sqrt(delta);
    }

    public double[] rozwiazania() {
        if(this.delta < 0) return new double[]{};
        else if(this.delta == 0) return new double[]{(-this.b / 2 * this.a) };
        else return new double[]{
                (-this.b - this.pDelta / 2) * this.a,
                (-this.b + this.pDelta) / 2 * this.a
        };
    }
}
