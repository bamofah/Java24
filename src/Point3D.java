/**
 * Java already has a standard class that represents two-dimensional points;
 * it’s called Point.
 * It has two integer variables called x and y that store a Point object’s (x,y)
 * location. It also has a move() method to place a point at the specified 
 * location, and a translate() method to move an object by an amount of x and y
 * values.
 */

import java.awt.*;

public class Point3D extends Point{ /*Point3D is a subclass of Point*/
    
    public int z;
    
    public Point3D(int x, int y, int z){
        super(x,y);
        this.z = z; //instance variable public int
    }
    
    public void move(int x, int y, int z){
        this.z = z;
        super.move(x, y);
    }
    
    public void translate(int x,int y,int z){
        this.z += z;
        super.translate(x, y);
    }
}