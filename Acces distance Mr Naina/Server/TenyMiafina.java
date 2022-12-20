import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TenyMiafina extends JFrame implements ActionListener {

  static String port = "5203";
  JButton SUBMIT;
  JPanel panel;
  JLabel label1, label2;
  JTextField text1, text2;
  String value1;
  String value2;
  JLabel label;

  TenyMiafina() {
    label1 = new JLabel();
    label1.setText("Ny teny miafinao");
    text1 = new JTextField(15);

    label = new JLabel();
    label.setText("");

    this.setLayout(new BorderLayout());

    SUBMIT = new JButton("ALEFA");

    panel = new JPanel(new GridLayout(2, 1));
    panel.add(label1);
    panel.add(text1);

    panel.add(label);
    panel.add(SUBMIT);
    add(panel, BorderLayout.CENTER);
    SUBMIT.addActionListener(this);
    setTitle("Atsofoy ny teny miafinao");
  }

  public void actionPerformed(ActionEvent ae) {
    value1 = text1.getText();
    dispose();
    new Fanombohana(Integer.parseInt(port), value1);
  }

  public String getValue1() {
    return value1;
  }

  public static void main(String[] args) {
    TenyMiafina frame1 = new TenyMiafina();
    frame1.setSize(300, 80);
    frame1.setLocation(500, 300);
    frame1.setVisible(true);
  }
}
