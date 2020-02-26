//
//
//
//
//
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
public class Level {
	
	private Brick[][] brickArray = new Brick[5][7];
	Brick brick;
	Ball ball;
	Paddle paddle;
	public Level(int widthIn, int heightIn)
	{
		Group root = new Group();
		Scene level = new Scene(root, widthIn, heightIn, Color.WHITE);
		ball = new Ball(widthIn / 2, heightIn / 2);
		paddle = new Paddle(0, 420);
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				int c = i * 5;
				brickArray[i][j] = new Brick(widthIn - 40 + c, heightIn - 10 - c);
			}
		}
	}
	//public Level(int widthIn, int heightIn, java.lang.String[] brickConfig)
	{
		
	}
	public void updateOneStep()
	{
		ball.moveOnce();
		
		if (ball.getX() >= 400 || ball.getX() <= 0)
		{
			ball.bounceHorizontal();
		}
		if (ball.getY() <= 0)
		{
			ball.bounceVerticle();
		}
		
		TouchPosition position = paddle.isTouching(ball);
		if (position.equals(TouchPosition.TOP))
		{
			ball.bounceVerticle();
		}
		if (position.equals(TouchPosition.LEFT) || position.equals(TouchPosition.RIGHT))
		{
			ball.bounceHorizontal();
		}
				
	}
	public Ball getBall()
	{
		return ball;
	}
	public Paddle getPaddle()
	{
		return paddle;
	}
	public GameState getGameStatus()
	{
		return GameState.PLAYING;
	}
	public Brick[][] getBricks()
	{
		return brickArray;
	}
}
