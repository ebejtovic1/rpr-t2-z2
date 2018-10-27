package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna;
    private double krajnja;
    private boolean pripada_pocetna;
    private boolean pripada_krajnja;

    public Interval (double poc, double kraj, boolean prip_poc, boolean prip_kraj) {
        if (poc > kraj) throw new IllegalArgumentException("Pocetna tacka ne moze biti veca od krajnje");
        pocetna = poc;
        krajnja = kraj;
        pripada_pocetna = prip_poc;
        pripada_krajnja = prip_kraj;
    }

    public Interval ( ) {
        pocetna = krajnja = 0;
        pripada_krajnja = pripada_pocetna = false;
    }

    public boolean isNull ( ) {
        if (pocetna == 0 && krajnja == 0 && pripada_krajnja == false && pripada_pocetna == false) return true;
        return false;
    }

    public boolean isIn (double tacka) {
        if (pripada_pocetna == true && pripada_krajnja == true)
            if (tacka >= pocetna && tacka <= krajnja) return true;
        if (pripada_pocetna == true && pripada_krajnja == false)
            if (tacka >= pocetna && tacka < krajnja) return true;
        if (pripada_pocetna == false && pripada_krajnja == true)
            if (tacka > pocetna && tacka <= krajnja) return true;
        if (pripada_krajnja == false && pripada_pocetna == false)
            if (tacka > pocetna && tacka < krajnja) return true;
        return false;
    }

    public Interval intersect(Interval prvi) {
        if (this.pocetna < prvi.pocetna && this.krajnja < prvi.krajnja)
            if (this.pripada_pocetna && prvi.pripada_pocetna)
                if (!this.pripada_krajnja && prvi.pripada_krajnja) {
                    this.pocetna = prvi.pocetna;
                }
        if (this.pocetna < prvi.pocetna && this.krajnja > prvi.krajnja)
            if (this.pripada_pocetna && prvi.pripada_pocetna)
                if (!this.pripada_krajnja && prvi.pripada_krajnja) {
                    this.pocetna = prvi.pocetna;
                    this.krajnja = prvi.krajnja;
                    this.pripada_krajnja = prvi.pripada_krajnja;
                }
        if (this.pocetna < prvi.pocetna && this.krajnja < prvi.krajnja)
            if (this.pripada_pocetna && !prvi.pripada_pocetna)
                if (!this.pripada_krajnja && prvi.pripada_krajnja) {
                    this.pocetna = prvi.pocetna;
                    this.pripada_pocetna = prvi.pripada_pocetna;
                }
        return this;
    }

    public static Interval intersect(Interval prvi, Interval drugi) {
        Interval novi = new Interval();
        if (prvi.pocetna < drugi.pocetna && prvi.krajnja < drugi.krajnja)
            if (prvi.pripada_pocetna && drugi.pripada_pocetna)
                if (!prvi.pripada_krajnja && drugi.pripada_krajnja) {
                    novi.pocetna = drugi.pocetna;
                    novi.krajnja = prvi.krajnja;
                    novi.pripada_pocetna = prvi.pripada_pocetna;
                    novi.pripada_krajnja = prvi.pripada_krajnja;
                }
        if (prvi.pocetna < drugi.pocetna && prvi.krajnja > drugi.krajnja)
            if (prvi.pripada_pocetna && drugi.pripada_pocetna)
                if (!prvi.pripada_krajnja && drugi.pripada_krajnja) {
                    novi.pocetna = drugi.pocetna;
                    novi.krajnja = drugi.krajnja;
                    novi.pripada_pocetna = prvi.pripada_pocetna;
                    novi.pripada_krajnja = drugi.pripada_krajnja;
                }
        if (prvi.pocetna < drugi.pocetna && prvi.krajnja < drugi.krajnja)
            if (prvi.pripada_pocetna && !drugi.pripada_pocetna)
                if (!prvi.pripada_krajnja && drugi.pripada_krajnja) {
                    novi.pocetna = drugi.pocetna;
                    novi.krajnja = prvi.krajnja;
                    novi.pripada_pocetna = drugi.pripada_pocetna;
                    novi.pripada_krajnja = prvi.pripada_krajnja;
                }
        return novi;
    }

    @Override
    public String toString ( ) {
        if (pocetna == 0 && krajnja == 0) return "()";
        if (pripada_pocetna == true && pripada_krajnja == true) return "[" + pocetna + "," + krajnja + "]";
        if (pripada_pocetna == true && pripada_krajnja == false) return "[" + pocetna + "," + krajnja + ")";
        if (pripada_pocetna == false && pripada_krajnja == true) return "(" + pocetna + "," + krajnja + "]";
        if (pripada_krajnja == false && pripada_pocetna == false) return "(" + pocetna + "," + krajnja + ")";
        return null;
    }
    @Override
    public boolean equals(Object obj){
        Interval inte =(Interval)obj;
        if(this.pocetna==inte.pocetna && this.krajnja==inte.krajnja && this.pripada_pocetna==inte.pripada_pocetna && this.pripada_krajnja==inte.pripada_krajnja)return true;
        return false;
    }
}