package chattingapp.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

public class client extends JFrame implements ActionListener {
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    client(){
        p1= new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,50);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("chattingapp/app/icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(25,22,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(7,15,25,22);
        p1.add(l1);

        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // super.mouseClicked(e);
                System.exit(0);
            }
        });

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("chattingapp/app/icons/2.png"));
        Image i5=i4.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2=new JLabel(i6);
        l2.setBounds(35,7,40,40);
        p1.add(l2);

        JLabel l3= new JLabel("Bunty");
        l3.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        p1.add(l3);
        l3.setBounds(85,8,110,20);

        JLabel l4= new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF", Font.BOLD,9));
        l4.setForeground(Color.WHITE);
        p1.add(l4);
        l4.setBounds(90,32,90,10);


        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("chattingapp/app/icons/phone.png"));
        Image i8=i7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5=new JLabel(i9);
        l5.setBounds(285,12,25,25);
        p1.add(l5);

        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("chattingapp/app/icons/video.png"));
        Image i11=i10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l6=new JLabel(i12);
        l6.setBounds(235,12,25,25);
        p1.add(l6);

        t1= new JTextField();
        t1.setBounds(5,550,270,25);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        add(t1);

        b1= new JButton("SEND");
        b1.setBounds(278,550,70,25);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);


        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("chattingapp/app/icons/3icon.png"));
        Image i14=i13.getImage().getScaledInstance(9,20,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l7=new JLabel(i15);
        l7.setBounds(315,12,9,20);
        p1.add(l7);

        a1= new JTextArea();
        a1.setBounds(5,55,340,490);
        a1.setBackground(Color.WHITE);
        a1.setFont(new Font("SAN_SERIF", Font.PLAIN,14));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);

        // getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setSize(350,600);

        setLocation(600,100);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new client().setVisible(true);
        String msginput="";

        try{
            s=new Socket("157.33.249.207",6001);
            while (true) {
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                dout.flush();
                msginput = din.readUTF();
                a1.setText(a1.getText() + "\n" + msginput);
            }
            }

        catch (Exception e){

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            String out = t1.getText();
            a1.setText(a1.getText() + "\n\t\t\t" + out);
           // dout =new DataOutputStream(s.getOutputStream());
            dout.writeUTF(out);
            t1.setText("");
        }
        catch (Exception e){

        }
    }
}

