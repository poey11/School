import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//root crop settings
public class RootCrop implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton turnip, carrot, potato, cancel;
    private Container container;
    private JLabel pTurnip, pCarrot, pPotato;
    private String[] cost = { "5", "10", "20" };
    private String[] names = { "Turnip", "Carrot", "Potato" };
    private ImageIcon image = new ImageIcon("icon.png");
    private ImageIcon turnipIcon = new ImageIcon(new ImageIcon("turnip.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    private ImageIcon carrotIcon = new ImageIcon(new ImageIcon("carrot.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    private ImageIcon potatoIcon = new ImageIcon(new ImageIcon("potato.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
     /**
     * It creates a label for each item in the shop
     */
    private void label() {
        // setup for the label
        pTurnip = new JLabel("$" + cost[0]);
        pTurnip.setFont(new Font("Lexend", Font.BOLD, 20));
        pTurnip.setBounds(50, 10, 150, 55);
        pTurnip.setForeground(Color.WHITE);
        frame.add(pTurnip);

        pCarrot = new JLabel("$" + cost[1]);
        pCarrot.setForeground(Color.WHITE);
        pCarrot.setFont(new Font("Lexend", Font.BOLD, 20));
        pCarrot.setBounds(175, 10, 150, 55);
        frame.add(pCarrot);

        pPotato = new JLabel("$" + cost[2]);
        pPotato.setForeground(Color.WHITE);
        pPotato.setFont(new Font("Lexend", Font.BOLD, 20));
        pPotato.setBounds(307, 10, 150, 55);
        frame.add(pPotato);
    }

    // The code is a constructor for the class RootCrop.
    public RootCrop() {
        // the intial lauch for Rootcrop and for the players to see what available rootCrop there are to plant

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
        frame.setTitle("Root Crop");
        frame.setIconImage(image.getImage());
        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0x263159));

        label();

        turnip = new JButton("Turnip");
        turnip.setBounds(10, 50, 100, 90);
        turnip.setIcon(turnipIcon);
        turnip.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        turnip.setForeground(new Color(0xFFFBEB));
        turnip.setFont(new Font("Lexend", Font.BOLD, 15));
        turnip.setHorizontalTextPosition(JLabel.CENTER);
        turnip.setVerticalTextPosition(JLabel.TOP);
        turnip.setBackground(new Color(0x476072));
        turnip.setActionCommand("0");
        turnip.addActionListener(this);
        turnip.setFocusable(false);
        frame.add(turnip);

        carrot = new JButton("Carrot");
        carrot.setBounds(138, 50, 110, 90);
        carrot.setIcon(carrotIcon);
        carrot.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        carrot.setForeground(new Color(0xFFFBEB));
        carrot.setFont(new Font("Lexend", Font.BOLD, 15));
        carrot.setHorizontalTextPosition(JLabel.CENTER);
        carrot.setVerticalTextPosition(JLabel.TOP);
        carrot.setBackground(new Color(0x476072));
        carrot.setActionCommand("1");
        carrot.addActionListener(this);
        carrot.setFocusable(false);
        frame.add(carrot);

        potato = new JButton("Potato");
        potato.setBounds(275, 50, 100, 90);
        potato.setIcon(potatoIcon);
        potato.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        potato.setForeground(new Color(0xFFFBEB));
        potato.setFont(new Font("Lexend", Font.BOLD, 15));
        potato.setHorizontalTextPosition(JLabel.CENTER);
        potato.setVerticalTextPosition(JLabel.TOP);
        potato.setBackground(new Color(0x476072));
        potato.setActionCommand("2");
        potato.addActionListener(this);
        potato.setFocusable(false);
        frame.add(potato);

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
     */
    private void quit() {
        // to directly go back to the Game/MyFarm

        CropList.frame.setEnabled(true);
        CropList.frame.dispose();

        MyFarm.frame.setEnabled(true);
        MyFarm.frame.toFront();
        MyFarm.rLabels();
        frame.dispose();
    }

    /**
     * When the user clicks the quit button, the CropList window is enabled, brought to the front,
     * repainted, validated, and the current window is disposed of.
     */
    private void quit_B() {
        // to go back to CropList

        CropList.frame.setEnabled(true);
        CropList.frame.toFront();
        CropList.frame.repaint();
        CropList.frame.validate();
        frame.dispose();
    }

    // The above code is a method that is called when a button is pressed. It is checking if the player
    // has enough coins to buy the crop. If the player has enough coins, it will subtract the cost of
    // the crop from the player's coins and change the button's text to the name of the crop. It will
    // also change the button's icon to the icon of the crop.
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
                
                if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Turnip")) {
                	 //MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBounds(10, 50, 100, 90);
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(turnipIcon);
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
                     MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
                     
                } else if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Carrot")) {
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(carrotIcon);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
                	
                } else if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Potato")) {
                	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(potatoIcon);
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
