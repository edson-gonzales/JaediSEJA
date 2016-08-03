/**
 * Created by SergioLanda on 8/3/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class ExampleSearchWords extends JFrame{
    JPanel panel;
    JTextPane textPane;
    String lineReverse="";
    String line;
    int recorrido=-1;
    StringBuilder builder;


    public void crearTextPane(){
        textPane=new JTextPane();
        textPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c=e.getKeyChar();
                if((byte)c==40)
                {
                    //Element root = textPane.getDocument().getDefaultRootElement();
                    //line =textPane.getDocument().getDefaultRootElement().toString();
                    //line=textPane.getCaretPosition()+"";
                    //line =textPane.getCaretPosition()+"";
                    try {
                        while(textPane.getText(textPane.getCaretPosition()+recorrido,1).codePointAt(0)!=10&&textPane.getText(textPane.getCaretPosition()+recorrido,1).codePointAt(0)!=32&&textPane.getText(textPane.getCaretPosition()+recorrido,1).codePointAt(0)!=61){
                            lineReverse+=textPane.getText(textPane.getCaretPosition()+recorrido,1);
                            recorrido--;
                            //espacio igual
                        }
//                        for(int i=-1;textPane.getText(textPane.getCaretPosition()-1,1).charAt(1)!=13;i--){
//
//                        }
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    builder=new StringBuilder(lineReverse);

                    line=builder.reverse().toString();
                    System.out.println(line);
                }
            }
        });
        //textPane.setMinimumSize(new Dimension(panel.getWidth(),panel.getHeight()));
    }
    public void crearPanelYTextPane(){
        panel=new JPanel();
        //panel.setSize(new Dimension(this.getWidth(),this.getHeight()));
        crearTextPane();
        panel.add(textPane);
    }
    public ExampleSearchWords(){
        this.setTitle("Analizador");
        this.setSize(400, 400);
        this.setBackground(Color.gray);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        crearPanelYTextPane();
        this.add(panel);
    }
}
