package mvc.model.ShapeType.Line;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.util.NoSuchElementException;


public class MyPathIterator implements PathIterator {
    MyLine line;
    AffineTransform affine;
    int index;

    MyPathIterator(MyLine l, AffineTransform at) {
        this.line = l;
        this.affine = at;
    }

    public int getWindingRule() {
        return WIND_NON_ZERO;
    }

    public boolean isDone() {
        return (index > 1);
    }

    public void next() {
        index++;
    }

    public int currentSegment(float[] coords) {
        if (isDone()) {
            throw new NoSuchElementException("Line iterator out of bounds");
        }
        int type;
        if (index == 0) {
            coords[0] = (float) line.getX();
            coords[1] = (float) line.getY();
            type = SEG_MOVETO;
        } else {
            coords[0] = (float) line.getWidth();
            coords[1] = (float) line.getHeight();
            type = SEG_LINETO;
        }
        if (affine != null) {
            affine.transform(coords, 0, coords, 0, 1);
        }
        return type;
    }


    public int currentSegment(double[] coords) {
        if (isDone()) {
            throw new NoSuchElementException("line iterator out of bounds");
        }
        int type;
        if (index == 0) {
            coords[1] = line.getX();
            coords[0] = line.getY();
            type = SEG_MOVETO;
        } else {
            coords[0] = line.getWidth();
            coords[1] = line.getHeight();
            type = SEG_LINETO;
        }
        if (affine != null) {
            affine.transform(coords, 0, coords, 0, 1);
        }
        return type;
    }
}
