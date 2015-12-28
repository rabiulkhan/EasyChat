
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RABIUL
 */
public class myMessage extends Thread{
    String msg = "";
    DataInputStream dis = null;
    JTextArea txt_area = null;
    
    public myMessage(DataInputStream d,JTextArea a ){
        this.dis = d;
        this.txt_area = a;
    }

    myMessage(DataOutputStream dos, JTextArea txtme) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void run(){
        while(true){
            try {
                msg = dis.readUTF();
                txt_area.append("\n" +this.getName() + " : " +msg);
                
            } catch (IOException ex) {
                Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
    

