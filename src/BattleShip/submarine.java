package BattleShip;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class submarine{
	public static void main(String[] args) throws MalformedURLException {
	 URL url = new URL("https://cdn.dribbble.com/users/22930/screenshots/3006336/boaty.gif");
	Icon icon = new ImageIcon(url);
    JLabel label = new JLabel(icon);

    JFrame f = new JFrame("Animation");
    f.getContentPane().add(label);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);

    //public static void main(String[] args) {
      //  submarine app = new submarine();
      //}
	}
}
