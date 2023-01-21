
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the settings for the flower crop

public class FlowerCrop implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton rose, tulip, sunflower, cancel;
    private Container container;
    private JLabel pRose, pTulips, pSunFlower;
    private String[] cost = { "5", "10", "20" };
    private String[] names = { "Rose", "Tulips", "Sunflower" };
    private ImageIcon image = new ImageIcon("icon.png");
    private ImageIcon roseIcon = new ImageIcon(new ImageIcon("rose.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    private ImageIcon tulipIcon = new ImageIcon(new ImageIcon("tulip.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    private ImageIcon sunflowerIcon = new ImageIcon(new ImageIcon("sunflower.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
     /**
     * It creates a label for each of the three flowers and sets the text to the cost of the flower
     */
    private void label() {
        // setup for the label
        pRose = new JLabel();
        pRose.setText("$" + cost[0]);
        pRose.setBounds(50, 10, 150, 55);
        pRose.setFont(new Font("Lexend", Font.BOLD, 20));
        pRose.setForeground(Color.WHITE);
        frame.add(pRose);

        pTulips = new JLabel();
        pTulips.setForeground(Color.WHITE);
        pTulips.setFont(new Font("Lexend", Font.BOLD, 20));
        pTulips.setText("$" + cost[1]);
        pTulips.setBounds(175, 10, 150, 55);
        frame.add(pTulips);

        pSunFlower = new JLabel();
        pSunFlower.setFont(new Font("Lexend", Font.BOLD, 20));
        pSunFlower.setText("$" + cost[2]);
        pSunFlower.setForeground(Color.WHITE);
        pSunFlower.setBounds(307, 10, 150, 55);
        frame.add(pSunFlower);
    }
    
    // The code is a constructor for the class FlowerCrop.
    public FlowerCrop() {
        // the intial lauch for flowerCrop and for the players to see what available flowercrop there are to plant
        if(MyFarm.p.getLevel() == 5) {
            cost[0]= "4";
            cost[1]= "9";
            cost[2]= "19";
        }
        else if(MyFarm.p.getLevel() == 10){
            cost[0]= "3";
            cost[1]= "8";
            cost[2]= "18";
        }
        else if(MyFarm.p.getLevel() == 15){
            cost[0]= "2";
            cost[1]= "7";
            cost[2]= "17";
        }
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setTitle("Flower Crop");
        frame.setIconImage(image.getImage());
        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0x263159));

        label();

        rose = new JButton("Rose");
        rose.setBounds(10, 50, 100, 90);
        rose.setIcon(roseIcon);
        rose.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        rose.setForeground(new Color(0xFFFBEB));
        rose.setFont(new Font("Lexend", Font.BOLD, 15));
        rose.setHorizontalTextPosition(JLabel.CENTER);
        rose.setVerticalTextPosition(JLabel.TOP);
        rose.setBackground(new Color(0x476072));
        rose.setActionCommand("0");
        rose.addActionListener(this);
        rose.setFocusable(false);
        frame.add(rose);

        tulip = new JButton("Tulips");
        tulip.setBounds(138, 50, 110, 90);
        tulip.setIcon(tulipIcon);
        tulip.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tulip.setForeground(new Color(0xFFFBEB));
        tulip.setFont(new Font("Lexend", Font.BOLD, 15));
        tulip.setHorizontalTextPosition(JLabel.CENTER);
        tulip.setVerticalTextPosition(JLabel.TOP);
        tulip.setBackground(new Color(0x476072));
        tulip.setActionCommand("1");
        tulip.addActionListener(this);
        tulip.setFocusable(false);
        frame.add(tulip);

        sunflower = new JButton("Sunflower");
        sunflower.setBounds(275, 50, 100, 90);
        sunflower.setIcon(sunflowerIcon);
        sunflower.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        sunflower.setForeground(new Color(0xFFFBEB));
        sunflower.setFont(new Font("Lexend", Font.BOLD, 15));
        sunflower.setHorizontalTextPosition(JLabel.CENTER);
        sunflower.setVerticalTextPosition(JLabel.TOP);
        sunflower.setBackground(new Color(0x476072));
        sunflower.setActionCommand("2");
        sunflower.addActionListener(this);
        sunflower.setFocusable(false);
        frame.add(sunflower);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 150, 90, 50);
        cancel.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        cancel.setForeground(new Color(0xFFFBEB));
        cancel.setFont(new Font("Lexend", Font.BOLD, 15));
        cancel.setBackground(new Color(0x476072));
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        frame.add(cancel);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

        frame.setLocation(x, y);
        frame.setVisible(true);

    }
     /**
     * It disables the current frame, disposes of it, enables the previous frame, brings it to the
     * front, and disposes of the current frame.
     * 
     */
    private void quit() {
        // to directly go back to the Game/MyFarm
        MyFarm.frame.setEnabled(true);
        MyFarm.frame.toFront();
        MyFarm.frame.repaint();
        MyFarm.frame.validate();
        MyFarm.rLabels();

        CropList.frame.setEnabled(true);
        CropList.frame.dispose();
        frame.dispose();
    }
     /**
     * 
     * to go back to CropList
     */
    private void quit_B() {
        // to go back to CropList
        MyFarm.frame.toFront();
        MyFarm.frame.repaint();
        MyFarm.frame.validate();

        CropList.frame.setEnabled(true);
        CropList.frame.toFront();
        CropList.frame.repaint();
        CropList.frame.validate();
        frame.dispose();
    }

    // A method that is called when a button is pressed.
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // changing the button name into the chosen crop
        String src = e.getActionCommand();

        try {
            int nos = Integer.parseInt(src);
            if(MyFarm.p.getCoin() < Integer.parseInt(cost[nos])){
                JOptionPane.showMessageDialog(frame, "You don't have enough coins");
            }
            else{
                MyFarm.p.subtractCoin(Integer.parseInt(cost[nos]));
                MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setText(names[nos]);
                
                if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Rose")) {
               	 //MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBounds(10, 50, 100, 90);
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(roseIcon);
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
                    MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
                    
                } else if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Tulips")) {
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(tulipIcon);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
               	
                } else if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Sunflower")) {
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(sunflowerIcon);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
               	
               }

            }
            
            quit();
        } catch (Exception c) {
            // TODO: handle exception
            quit_B();
        }

    }

}
