package phonebook;

// SplashScreen.java
// A simple application to show a title screen in the center of the screen
// for the amount of time given in the constructor.  This class includes
// a sample main() method to test the splash screen, but it's meant for use
// with other applications.
//

import java.awt.*;
import java.io.Serializable;
import javax.swing.*;

public class SplashScreen extends JWindow implements Serializable{
  private int duration;
  public SplashScreen(int d) {
    duration = d;
  }

  // A simple little method to show a title screen in the center
  // of the screen for the amount of time given in the constructor
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.LIGHT_GRAY);

    // Set the window's bounds, centering the window
    int width = 400;
    int height =225;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    // Build the splash screen
    JLabel label = new JLabel(new ImageIcon(getClass().getResource("splash.jpg")));
    JLabel copyrt = new JLabel
      ("by Barcan Adrian", JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.ITALIC, 16));
    content.add(label, BorderLayout.CENTER);
    content.add(copyrt, BorderLayout.SOUTH);
    Color oraRed = new Color(20, 20, 10,  55);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 20));

    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }


}