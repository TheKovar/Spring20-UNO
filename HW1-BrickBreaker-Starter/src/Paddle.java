//
//
//
//
//
import javafx.scene.shape.Rectangle;
public class Paddle 
{
	private Rectangle paddle;
	public Paddle(int leftIn, int topIn)
	{
			paddle = new Rectangle();
			paddle.setWidth(80);
			paddle.setHeight(10);
			paddle.setX(leftIn);
			paddle.setY(topIn);
		}
	public int getLeft()
	{
		double x;
		x = paddle.getX();
		return (int) x;
	}
	public int getTop()
	{
		double y;
		y = paddle.getY();
		return (int) y;
	}
	public int getWidth()
	{
		double w;
		w = paddle.getWidth();
		return (int) w;
	}
	public int getHeight()
	{
		double h;
		h = paddle.getHeight();
		return (int) h;
	}
	public void moveTo(int newLeft)
	{
		if (newLeft <= 0)
		{
			paddle.setX(0);
		}
		else
		{
			paddle.setX(newLeft);
		}
	}
	public TouchPosition isTouching(Ball theBall)
	{
		
		if (theBall.getY() >= paddle.getY() + (paddle.getHeight() / 2))
		{
			return TouchPosition.TOP;
		}
		else if (theBall.getX() < paddle.getX())
		{
			return TouchPosition.LEFT;
		}
		else if (theBall.getX() > paddle.getX())
		{
			return TouchPosition.RIGHT;
		}
		else
		{
			return TouchPosition.NONE;
		}
	}
}
