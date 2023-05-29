/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompress;
import static java.awt.Color.green;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sachin
 */
public class Appframe extends JFrame implements ActionListener {
    
    JButton Compressor;
    JButton Decompressor;
    
    Appframe()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(green);
        this.setSize(1000,500);
        
        Compressor = new JButton("Select the file to compress");
        Compressor.setBounds(20, 100, 200, 40);
        Compressor.addActionListener(this);
        
        Decompressor = new JButton("Selecet file to decompress");
        Decompressor.setBounds(270,100,200,40);
        Decompressor.addActionListener(this);
        
        this.add(Compressor);
        this.add(Decompressor);
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Compressor)
        {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                
                try{
                    compressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        
        if(e.getSource() == Decompressor)
        {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                
                try{
                    decompress.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
