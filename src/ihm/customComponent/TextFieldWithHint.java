package ihm.customComponent;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;


public class TextFieldWithHint extends JTextField implements FocusListener
{
    private final String HINT;

    private boolean showingHint;
    private Color placeholderColor = new Color(255, 255, 255, 100);
    private Color foregroundColor = new Color(255, 0, 0, 255);

  
    public TextFieldWithHint(final String hint)
    {
        super(hint);
        this.setCaretColor(new Color (255,255,255));

        this.HINT = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }
  
    @Override
    public void focusGained(FocusEvent e)
    {
        if(this.getText().isEmpty())
        {
            super.setText("");
            this.setForeground(new Color(255, 0, 0, 255)); // texte quand on écrit
            this.showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        if(this.getText().isEmpty())
        {
            super.setText(HINT);
            this.setForeground(new Color(255, 255, 255,100)); // placeholder
            this.showingHint = true;
        }
    }
  
    @Override
    public String getText()
    {
        return this.showingHint ? "" : super.getText();
    }

    public void setPlaceholderColor(Color placeholderColor)
    {
        this.placeholderColor = placeholderColor;
    }

    public void setForeground(Color foregroundColor)
    {
        this.foregroundColor = foregroundColor;
    }
}
