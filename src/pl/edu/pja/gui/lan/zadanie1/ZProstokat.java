package pl.edu.pja.gui.lan.zadanie1;

public class ZProstokat {
    static int nextProstokatUID = 1;
    static int nextKwadratUID = 1;

    private final int UID;
    private final int width;
    private final int height;
    private final char filling;
    private final char outline;

    public ZProstokat(int width, int height, char filling, char outline) {
        this.UID = (width == height ? nextKwadratUID++ : nextProstokatUID++);
        this.width = width;
        this.height = height;
        this.filling = filling;
        this.outline = outline;
    }

    public ZProstokat(int size, char filling, char outline) {
        this(size, size, filling, outline);
    }

    public void rysuj() throws ZProstokatException {

        System.out.print((width == height ? "Kwadrat" : "Prostokat") + " (" + this.UID + ") rozmiaru " + width + " x "
                + height);

        if(width < 1 || height < 1 || ((width == 1 || height == 1) && filling != outline)) {
            System.out.println();
            throw new ZProstokatException("Błędny prostokąt!");
        }

        final int totalCount = width * height;

        if(width > 2 && height > 2) {
            final int fillingCount = (width - 2) * (height - 2);
            final int outlineCount = totalCount - fillingCount;
            System.out.println(", " + filling + " = " + fillingCount + ", " + outline + " = " + outlineCount);
        } else {
            System.out.println(", " + filling + " = " + totalCount);
        }

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                System.out.print(((y == 0 || y == height - 1 || x == 0 || x == width - 1) ? outline : filling) + " ");
            }
            System.out.println();
        }

    }
}
