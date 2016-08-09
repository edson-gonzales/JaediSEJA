import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;

public class Editor extends JFrame {
    JTextPane textPane;
    DefaultStyledDocument  lsd;

    public Editor() {
        super("Editor");

        lsd = new DefaultStyledDocument ();

        textPane = new JTextPane(lsd);
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(200, 400));

        //Estatus
        JPanel statusPane = new JPanel(new GridLayout(1, 1));
        CaretListenerLabel caretListenerLabel = new CaretListenerLabel("Estatus");
        statusPane.add(caretListenerLabel);

        //componentes
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(statusPane, BorderLayout.SOUTH);
        setContentPane(contentPane);

        //escucha
        textPane.addCaretListener(caretListenerLabel);
    }
    //escucha.
    protected class CaretListenerLabel extends JLabel implements CaretListener {
        public CaretListenerLabel (String label) {
            super(label);
        }

        public void caretUpdate(CaretEvent e) {
            //obtener la localizacion
            int dot = e.getDot();
            int mark = e.getMark();
            if (dot == mark) {
                try {
                    Rectangle caretCoords = textPane.modelToView(dot);
                    //coordenadas.
                    setText(dot + "  "+ caretCoords.x + "  " + caretCoords.y);
                } catch (BadLocationException ble) {
                    setText(dot+"");
                }
            }
        }
    }
}