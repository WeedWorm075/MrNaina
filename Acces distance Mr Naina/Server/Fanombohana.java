import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

//selection port
//manao securite(mdp)
//maka socket

public class Fanombohana {

  ServerSocket socket = null;         //definir avy eo
  DataInputStream password = null;
  DataOutputStream verify = null;
  String width = "";
  String height = "";

  Fanombohana(int port, String value1) {
    Robot robot = null;
    Rectangle rectangle = null;
    try {
      System.out.println("Miandry kely client azafady");
      socket = new ServerSocket(port);

      GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice gDev = gEnv.getDefaultScreenDevice();

      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      String width = "" + dim.getWidth();
      String height = "" + dim.getHeight();
      rectangle = new Rectangle(dim);
      robot = new Robot(gDev);

      drawGUI();

      while (true) {
        Socket sc = socket.accept();
        password = new DataInputStream(sc.getInputStream());
        verify = new DataOutputStream(sc.getOutputStream());
        String pssword = password.readUTF();

        if (pssword.equals(value1)) {
          verify.writeUTF("marina");
          verify.writeUTF(width);
          verify.writeUTF(height);
          new Affichage(sc, robot, rectangle);
          new MakaEvents(sc, robot);
        } else {
          verify.writeUTF("diso");
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void drawGUI() {}
}
