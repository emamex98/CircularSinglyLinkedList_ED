import javax.swing.*;
import java.awt.*;

class GUI extends JFrame{

  public GUI(){
    super("Circular Singly Linked List");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(500,610);

    ImagePanel mapPanel = new ImagePanel();
    this.add(mapPanel, BorderLayout.SOUTH);

    MainPanel guiPanel = new MainPanel(mapPanel);
    this.add(guiPanel, BorderLayout.NORTH);

    this.setVisible(true);
  }

  public static void main(String[] args) {
    GUI newGUI = new GUI();
  }

}
