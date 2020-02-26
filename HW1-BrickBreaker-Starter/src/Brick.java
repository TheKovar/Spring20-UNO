//
//
//
//
//

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
public class Brick 
{
	private boolean hit = false;
	private int health;
	private Rectangle brick;
	private Color clr;
	public Brick(int topIn, int leftIn)
	{
		brick = new Rectangle();
		brick.setFill(Color.GREEN);
		clr = Color.GREEN;
		brick.setX(leftIn);
		brick.setY(topIn);
		health = 3;
		
	}
	public Brick(int topIn, int leftIn, int hitsIn)
	{
		brick = new Rectangle();
		brick.setX(leftIn);
		brick.setY(topIn);
		health = hitsIn;
		if (health >= 3)
		{
			brick.setFill(Color.GREEN);
			clr = Color.GREEN;
			
		}
		else if (health == 2)
		{
			brick.setFill(Color.YELLOW);
			clr = Color.YELLOW;
		}
		else if (health == 1)
		{
			brick.setFill(Color.RED);
			clr = Color.RED;
		}
		else
		{
			brick.setFill(Color.WHITE);
			clr = Color.WHITE;
		}
	}
	
	public int getTop()
	{
		double y;
		y = brick.getY();
		return (int) y;
	}
	public int getLeft()
	{
		double x;
		x = brick.getX();
		return (int) x;
	}
	public int getWidth()
	{
		double w;
		w = brick.getWidth();
		return (int) w;
	}
	public int getHeight()
	{
		double h;
		h = brick.getHeight();
		return (int) h;
	}
	public javafx.scene.paint.Color getColor()
	{
		Color c;
		c = clr;
		return c;
		
	}
	public boolean hit()
	{
		if (health == 0)
		{
			hit = true;
		}
		else 
		{
			hit = false;
		}
		
		return hit;
	}
	public TouchPosition isTouching(Ball theBall)
	{
		if (theBall.getY() <= brick.getY() - (brick.getHeight() / 2))
		{
			return TouchPosition.BOTTOM;
		}
		else if (theBall.getY() >= brick.getY() + (brick.getHeight() / 2))
		{
			return TouchPosition.TOP;
		}
		else if (theBall.getX() < brick.getX())
		{
			return TouchPosition.LEFT;
		}
		else if (theBall.getX() > brick.getX())
		{
			return TouchPosition.RIGHT;
		}
		else
		{
			return TouchPosition.NONE;
		}
	}
}
