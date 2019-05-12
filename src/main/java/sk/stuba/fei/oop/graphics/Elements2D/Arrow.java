package sk.stuba.fei.oop.graphics.Elements2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.lang.Object;
public class Arrow extends Line2D.Float {



    private final int ARR_SIZE = 8;




    public Arrow(int x1, int y1, int x2, int y2) {
        super(x1+25,y1+25,x2+25,y2+25);
        setStartPoint();
    }



    public double getCenterX(){
        return (super.x1+super.x2)/2;
    }
    public double getCenterY(){
        return (super.y1+super.y2)/2;
    }


    void drawArrow(Graphics g1) {
        Graphics2D g = (Graphics2D) g1.create();
        g.setPaint(Color.BLACK);
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy)-25;
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }

    private void setStartPoint(){
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        double theta = Math.toDegrees(angle);
        if (theta < 0.0) {
            theta += 360.0;
        }

        if(theta>=45 && theta<=135){
            addY1(25);
        }else if(theta>=135 && theta<=225){
            addX1(-25);
        }else if(theta>=225 && theta<=315){
            addY1(-25);
        }else if(theta>=315 || theta<=45){
            addX1(25);
        }

    }

    public void addX1(int n) {
        super.x1 = super.x1+n;
    }

    public void addY1(int n) {
        super.y1 = super.y1+n;
    }



}

