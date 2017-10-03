import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton b1=new JButton("範例");
    private JButton b2=new JButton("加密");
    private JButton b3=new JButton("清除");
    private JButton b4=new JButton("離開");
    private JTextField key=new JTextField("0");
    private JLabel l2=new JLabel("Key");
    private JPanel p1=new JPanel(new GridLayout(6,1,0,2)) ;
    private JTextArea jta1=new JTextArea();
    private JTextArea jta2=new JTextArea();
    private JScrollPane jsp1=new JScrollPane(jta1);
    private JScrollPane jsp2=new JScrollPane(jta2);
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,500,500);
        cp=this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.setLayout(new BorderLayout(0,3));
        cp.add(p1,BorderLayout.CENTER);
        p1.add(b1);
        p1.add(b2);
        p1.add(l2);
        p1.add(key);
        p1.add(b3);
        p1.add(b4);
        jta1.setLineWrap(true);
        jta2.setLineWrap(true);
        jsp1.setPreferredSize(new Dimension(200,400));
        jsp2.setPreferredSize(new Dimension(200,400));
        cp.add(jsp2,BorderLayout.EAST);
        cp.add(jsp1,BorderLayout.WEST);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta1.setText("Take this kiss upon the brow!\n" +
                        "And, in parting from you now,\n" +
                        "Thus much let me avow--\n" +
                        "You are not wrong, who deem\n" +
                        "That my days have been a dream;\n" +
                        "Yet if hope has flown away\n" +
                        "In a night, or in a day,\n" +
                        "In a vision, or in none,\n" +
                        "Is it therefore the less gone?\n" +
                        "All that we see or seem\n" +
                        "Is but a dream within a dream.");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k=Integer.parseInt(key.getText());
                char data[]=jta1.getText().toCharArray();
                int len=data.length;
                for(int i=0;i<len;i++){
                    data[i]+=k;
                }
                String st=new String(data);
                jta2.setText(st);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta1.setText("");
                jta2.setText("");
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);            }
        });




    }
}
