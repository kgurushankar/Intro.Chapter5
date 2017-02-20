package moving.disk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingDisk extends JPanel
  implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	private int time;

  public MovingDisk()
  {
    time = 0;
    Timer clock = new Timer(50, this); 
    clock.start();
  }

  public void paintComponent(Graphics g)
  {
	  int winx = getWidth()/2;
	  int winy = (int) (getHeight()*13/15);
    int x = winx - (int)(100 * Math.cos(0.005 * Math.PI * time));	// x/2
    int y = winy - (int)(75 * Math.sin(0.005 * Math.PI * time));		// 13/15*y
    int r = 20;

    Color sky;
    if (y > 130) sky = Color.BLACK;
    else sky = Color.CYAN;
    setBackground(sky);//Color.getColor(("jetblack"), (int)((Math.random()*(255*255*255))))); //should be sky
    super.paintComponent(g);

    g.setColor(Color.ORANGE);
    g.fillOval(x - r, y - r, 2*r, 2*r); 
  }

  public void actionPerformed(ActionEvent e)
  {
    time++;
    repaint();
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Moving Disk");
    w.setSize(300, 150);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new MovingDisk());
    w.setResizable(true);
    w.setVisible(true);
  }
}
