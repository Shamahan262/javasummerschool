package sef.module6.activity;

/**
 * @author  John Doe
 * 
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D{
	
	private double z;
	
	/**
	 * Creates a Point3D object with the default coordinate of 0,0,0 
	 *
	 */
	public Point3DImpl(){
		super();
		this.z = 0;
	}
	
	/**
	 * Creates a Point3D object at the specified coordinates
	 * 
	 * @param x coordinate along the x axis
	 * @param y coordinate along the y axis
	 * @param z coordinate along the z axis
	 */
	public Point3DImpl(double x, double y, double z){
		super(x, y);
		this.z = z;		
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#setZ(double)
	 */
	public final void setZ(double z){
		this.z = z;		
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getZ()
	 */
	public final double getZ(){
		return z;
	}
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#move(double, double, double)
	 */
	public void move(double x2, double y2, double z2){
		super.move(x2, y2);
		this.z = z2;	
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#translate(double, double, double)
	 */
	public void translate(double x2, double y2, double z2){
		super.translate(x2, y2);
		this.z += z2;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#equals(double, double, double)
	 */
	public boolean equals(double x2, double y2, double z2){
		return (this.getX() == x2 && this.getY() == y2 && this.getZ() == z2);
	}
	
	
	/**
	 * Compares if the coordinates are equal to the coordinates specified by the parameter
	 * 
	 * @param p the coordinates to compare
	 * 
	 * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
	 */
	public boolean equals(Object p){
		if (p != null && p instanceof Point3DImpl) {
			Point3DImpl temp = (Point3DImpl) p;
			return (this.getX() == temp.getX() && this.getY() == temp.getY()&& this.getZ() == temp.getZ());
		}			
		return false;	
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
	 */
	public double getDistance(Point3D p){
		double dx = Math.abs(this.getX() - p.getX());
		double dy = Math.abs(this.getY() - p.getY());
		double dz = Math.abs(this.getZ() - p.getZ());
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(double, double, double)
	 */
	public double getDistance(double x2, double y2, double z2){
		double dx = Math.abs(this.getX() - x2);
		double dy = Math.abs(this.getY() - y2);
		double dz = Math.abs(this.getZ() - z2);
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
	}
	

}
