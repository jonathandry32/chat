package affichage;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.Random;
import listener.*;
public class Recever{
JButton ok=new JButton();
JLabel error=new JLabel();
    public Recever()throws Exception{
        this.formulera();
    }
    public JButton get_jb(){
        return this.ok;
    }
    public void set_error(String error){
        this.error.setText(error);
    }

	public JFrame formulera()throws Exception{
        JFrame jdp=new JFrame();
        jdp.setVisible(true);
        jdp.setSize(425,300);
        jdp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdp.setResizable(false);
        jdp.setLayout(null);
        int size=1;
        String attribut=new String();
            attribut="Port";
        JTextField formulaire=new JTextField();
        JLabel title=new JLabel();
        int x=10;
        int y=50;
            title.setBounds(x,y,50,25);
            formulaire=new JTextField();
            formulaire.setBounds(x+50,y,250,25);
            title.setText(attribut);
            jdp.add(title);
            jdp.add(formulaire);
        Lis_sv volavo=new Lis_sv(formulaire,this);
        ok.setBounds(130,20,100,25);
        ok.setText("Receive");
        ok.addActionListener(volavo);
        jdp.add(ok);
        JLabel m=new JLabel();
        m.setText("Message:");
        m.setBounds(10,50,100,200);
        jdp.add(m);
        error.setBounds(135,50,100,100);
        jdp.add(error);
        return jdp;
    }
}