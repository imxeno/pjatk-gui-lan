package pl.edu.pja.gui.lan.zadanie4;

public class ReversibleString implements Reversible {
    private String s;
    public ReversibleString(String s) {
        this.s = s;
    }

    public Reversible reverse() {
        StringBuffer sb = new StringBuffer(s);

        for (int i = 0; i < sb.length(); i++)
        {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c))
                sb.replace(i, i + 1, Character.toUpperCase(c) + "");
            else
                sb.replace(i, i + 1, Character.toLowerCase(c) + "");

        }

        s = sb.toString();
        return this;
    }

    public String toString() {
        return s;
    }
}
