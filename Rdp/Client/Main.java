import java.net.Socket;
import javax.swing.JOptionPane;

public class Main {

  static String port = "4907";

  public static void main(String args[]) {
    String ip = JOptionPane.showInputDialog("Please enter server ip");
    new Main().initialize(ip, Integer.parseInt(port));
  }

  public void initialize(String ip, int port) {
    try {
      Socket sc = new Socket(ip, port);
      System.out.println("Connecting to the Server");
      //Authenticate class is responsible for security purposes
      Authenticate frame1 = new Authenticate(sc);

      frame1.setSize(450, 100);
      frame1.setLocation(450, 450);
      frame1.setVisible(true);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
