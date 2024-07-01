package fractal;

import java.awt.Graphics;

public class TriangleClass {
    private PointClass p1, p2, p3;
    private PointClass mid1, mid2, mid3;

    public TriangleClass(PointClass p1, PointClass p2, PointClass p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.mid1 = new PointClass((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        this.mid2 = new PointClass((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
        this.mid3 = new PointClass((p3.x + p1.x) / 2, (p3.y + p1.y) / 2);
    }

    public void draw(Graphics g) {
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        g.drawLine(p2.x, p2.y, p3.x, p3.y);
        g.drawLine(p3.x, p3.y, p1.x, p1.y);
    }

    public PointClass getP1() { return p1; }
    public PointClass getP2() { return p2; }
    public PointClass getP3() { return p3; }
    public PointClass getMid1() { return mid1; }
    public PointClass getMid2() { return mid2; }
    public PointClass getMid3() { return mid3; }
}
