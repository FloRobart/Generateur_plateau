package ihm.customComponent;

import javax.swing.JTextField;
import java.awt.event.*;
public class TextFieldOnlyInteger extends JTextField 
{
    public TextFieldOnlyInteger()
    {
        super();
        JTextField txt = this;
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txt.setEditable(true);
               }else
               {
                  txt.setEditable(false);
               }               
            }
         });    
    }

}
