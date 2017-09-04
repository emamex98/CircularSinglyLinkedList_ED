import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainPanel extends JPanel implements ActionListener{

  private JTextField tfNombreParada;
  private JButton btAdd, btDlt, btDltLast;

  private CircularList route;
  private ImagePanel map;

  private int stopIndex;

  public MainPanel(ImagePanel map){
    super();
    this.setPreferredSize(new Dimension(500,300));

    this.route = new CircularList<String>();
    this.map = map;
    stopIndex = 0;

    this.add(new JLabel("<html><center><br><b>Ruleta 2<br>Emanuel Estrada Larios<br>Circular Singly Linked List</b><br><br>Problema: Se necesitan crear mapas de las rutas de transporte urbano<br>para colocarse en cada parada. Este programa crea listas<br>uniligadas circulares para ilustrar las paradas de la ruta.<br><br>Ingrese el nombre de la parada por agregar/borrar:<br></center></html>"));


    this.tfNombreParada = new JTextField(20);

    this.add(new JLabel("                    "));
    this.add(this.tfNombreParada);
    this.add(new JLabel("                    "));

    this.btAdd = new JButton("Agregar");
    this.btAdd.addActionListener(this);
    this.add(this.btAdd);

    this.btDlt = new JButton("Borrar");
    this.btDlt.addActionListener(this);
    this.add(this.btDlt);

    this.btDltLast = new JButton("Deshacer");
    this.btDltLast.addActionListener(this);
    this.add(this.btDltLast);

  }

  public void actionPerformed(ActionEvent e){

    if(e.getSource() == this.btAdd) {
      if (this.stopIndex < 12) {
        this.route.addElement(this.tfNombreParada.getText());
        this.map.updateNames(this.stopIndex, this.tfNombreParada.getText());
        this.map.updateStops(this.route.getListSize());
        this.stopIndex++;
      }
      else {
        JOptionPane.showMessageDialog(null, "Cada ruta solo puede contener 12 paradas.");
      }
    }

    else if(e.getSource() == this.btDlt) {
      Boolean notFound = true;
      if (this.stopIndex != 0) {
        search: for (int i=0; i<this.stopIndex; i++) {
          if(this.map.getNames(i).equals(this.tfNombreParada.getText())){
            for (int j=i; j<=this.stopIndex-i; j++) {
              this.map.updateNames(j,map.getNames(j+1));
            }
            this.route.deleteItem(i);
            this.map.updateStops(this.route.getListSize());
            this.stopIndex--;
            notFound = false;
            break search;
          }
        }
        if(notFound){
          JOptionPane.showMessageDialog(null, "No se encontró la parada que desea eliminar.");
        }
      }
      else {
        JOptionPane.showMessageDialog(null, "No existen paradas todavía.");
      }
    }

    else{
      if (this.stopIndex != 0) {
        this.route.deleteLast();
        this.map.updateStops(this.route.getListSize());
        this.stopIndex--;
      }
      else {
        JOptionPane.showMessageDialog(null, "No existen paradas todavía.");
      }
    }

  }

}
