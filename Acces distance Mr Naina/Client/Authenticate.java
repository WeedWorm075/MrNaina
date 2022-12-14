import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;

class Authenticate extends JFrame implements ActionListener {

  private Socket cSocket = null;
  DataOutputStream psswrchk = null;
  DataInputStream verification = null;
  String verify = "";
  JButton SUBMIT;
  JPanel panel;
  JLabel label, label1;
  String width = "", height = "";
  final JTextField text1;

  Authenticate(Socket cSocket) {
    label1 = new JLabel();
    label1.setText("Ny teny miafinao");
    text1 = new JTextField(10);
    this.cSocket = cSocket;

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
    setTitle("LOGIN");
  }

  public void actionPerformed(ActionEvent ae) {
    String value1 = text1.getText();
    // System.out.println(value1);
    try {
      psswrchk = new DataOutputStream(cSocket.getOutputStream());
      verification = new DataInputStream(cSocket.getInputStream());
      psswrchk.writeUTF(value1);
      verify = verification.readUTF();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // System.out.println(verify);

    if (verify.equals("marina")) {
      try {
        width = verification.readUTF();
        height = verification.readUTF();
      } catch (IOException e) {
        e.printStackTrace();
      }
      CreateFrame abc = new CreateFrame(cSocket, width, height);
      dispose();
    } else {
      System.out.println("ny teny miafinao azafady");
      JOptionPane.showMessageDialog(
        this,
        "diso  ny teny miafinao",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
      dispose();
    }
  }
}
