// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: None used
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Ball 
{

	/**
	 * Fixes magic numbers, trajectory in positive.
	 */
	private static final int POS = 3;
	/**
	 * Fixes magic numbers, trajectory in negative.
	 */
	private static final int NEG = POS - 6;
	/**
	 * Horizontal velocity tracker.
	 */
	private int horz = 3;
	/**
	 * Vertical velocity tracker.
	 */
	private int vert = 3;
	/**
	 * Creates a circle object to be called by methods.
	 */
	private Circle ball;
	
	public Ball()
	{
		ball = new Circle();
		ball.setFill(Color.BLACK);
		ball.setCenterX(100.0);
		ball.setCenterY(100.0);
		ball.setRadius(10.0);
		
		ball.setCenterX(100.0 + POS);
		ball.setCenterY(100.0 + POS);
	}
	public Ball(int x, int y)
	{
		ball = new Circle();
		ball.setFill(Color.BLACK);
		ball.setCenterX(x);
		ball.setCenterY(y);
		ball.setRadius(10.0);
		
		ball.setCenterX(x + 3.0);
		ball.setCenterY(y + 3.0);
	}
	
	void bounceHorizontal()
	{
		horz *= -1;
	}
	void bounceVerticle()
	{
		vert *= -1;
	}
	int getRadius()
	{
		double r = ball.getRadius();
		return (int) r;
	}
	int getX()
	{
		double x = ball.getCenterX();
		return (int) x;
	}
	int getY()
	{
		double y = ball.getCenterY();
		return (int) y;
	}
	void moveOnce()
	{
		 ball.setCenterY(ball.getCenterY() + vert);
		 ball.setCenterX(ball.getCenterX() + horz);
	}
	public java.lang.String toString()
	{
		return "Ball at (" + getX() + "," + getY() + ") moving (" + horz + "," + vert + ")";
	}
}
