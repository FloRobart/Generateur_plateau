package ihm.customComponent;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
public class TextFieldWithHint extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;
  
    public TextFieldWithHint(final String hint) {
      super(hint);
      setCaretColor(new Color (255,255,255));

      this.hint = hint;
      this.showingHint = true;
      super.addFocusListener(this);
    }
  
    @Override
    public void focusGained(FocusEvent e) {
      if(this.getText().isEmpty()) {
        super.setText("");
        setForeground(new Color(255, 255, 255,255));
        showingHint = false;
      }
    }
    @Override
    public void focusLost(FocusEvent e) {
      if(this.getText().isEmpty()) {
        super.setText(hint);
        setForeground(new Color(255, 255, 255,100));
        showingHint = true;
      }
    }
  
    @Override
    public String getText() {
      return showingHint ? "" : super.getText();
    }
  }
