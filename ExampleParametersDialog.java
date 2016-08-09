/**
 * Created by SergioLanda on 8/3/2016.
 */
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class ExampleParametersDialog extends JDialog{
    private final JPanel panel=new JPanel();
    public ExampleParametersDialog(){
        this.setResizable(false);
        this.setTitle("Parameters");
        //necesito recibir parametros de posicion
        this.setBounds(100,100,150,100);
        this.getContentPane().setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(5,5,5,5));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        {
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10,11,424,146);
            panel.add(scrollPane);
            {
                JTextArea txtParametros=new JTextArea();
                txtParametros.setText("String name, int age");
                txtParametros.setLineWrap(true);
                txtParametros.setAutoscrolls(true);
                scrollPane.setViewportView(txtParametros);
            }
        }
        {
            JPanel buttonPanel=new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            {
                JButton okButton=new JButton("Ok");
                okButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        dispose();
                    }
                });
                okButton.setActionCommand("Ok");
                panel.add(okButton);
                this.getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent arg0){
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancelar");
                panel.add(cancelButton);
            }
        }
    }
}
