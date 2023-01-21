import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

//contains all the contents of a farm
public class MyFarm implements ActionListener {
    public static JButton[][] tile = new JButton[5][10];
    public static int tileRow;
    public static int tileColumn,l=0;
    public static JFrame frame = new JFrame();
    public static player p = new player();
    public  static MyFarmData myData = new MyFarmData();
    
    private JTextPane jtp = new JTextPane();
    private static int levelCost[] = {200,300,400};
    private CropList cl;
    private JButton[] tools = new JButton[6];// Shovel,Pickaxe, Water, Fertilize, skipDay,Plow,tools[5], Quit;
    private JButton skip, quit, levelUp;
    private static JLabel labelLevelCost, Title, Coin, Exp, level, pickaxe, water, fer, plow, shovel, days, farmStatus, picture;
    private static int[] cost = { 50, 0, 7, 0, 10, 0 };
    private static String status = "Regular Farmer";
    private ImageIcon image = new ImageIcon("icon.png");


     /**
     * It removes all the labels and then adds them back.
     * this function serves to reset all the label to updates its latest values
     */
    public static void rLabels() {
        // this function serves to reset all the label to updates its latest values
        frame.remove(pickaxe);
        frame.remove(water);
        frame.remove(fer);
        frame.remove(days);
        frame.remove(plow);
        frame.remove(shovel);
        frame.remove(Title);
        frame.remove(level);
        frame.remove(Exp);
        frame.remove(farmStatus);
        frame.remove(Coin);
        frame.remove(labelLevelCost);
        frame.revalidate();
        frame.repaint();
        labels();
    }
 
    /**
     * It creates labels for the GUI
     * the initialization of the labels
     */
    public static void labels() {
        // the initialization of the labels
        DecimalFormat df = new DecimalFormat("0.00");
        Title = new JLabel();
        Title.setText("My Farm Simulator");
        Title.setFont(new Font("Lexend", Font.BOLD, 15));
        Title.setForeground(new Color(0x263159));
        Title.setBounds(1180, 30, 150, 55);
        frame.add(Title);

        days = new JLabel();
        days.setText("Day: " + p.getDays());
        days.setFont(new Font("Lexend", Font.BOLD, 15));
        days.setForeground(new Color(0x263159));
        days.setBounds(1140, 150, 150, 55);
        frame.add(days);

        Coin = new JLabel();
        Coin.setText("Coins: " + df.format(p.getCoin()));
        Coin.setFont(new Font("Lexend", Font.BOLD, 15));
        Coin.setForeground(new Color(0x263159));
        Coin.setBounds(1140, 65, 150, 55);
        frame.add(Coin);

        level = new JLabel();
        level.setText("Level: " + p.getLevel());
        level.setFont(new Font("Lexend", Font.BOLD, 15));
        level.setForeground(new Color(0x263159));
        level.setBounds(1270, 65, 150, 55);
        frame.add(level);

        Exp = new JLabel();
        Exp.setText("Exp: " + p.getExp() + "/" + p.getExpCap());
        Exp.setFont(new Font("Lexend", Font.BOLD, 15));
        Exp.setForeground(new Color(0x263159));
        Exp.setBounds(1140, 110, 150, 55);
        frame.add(Exp);

        pickaxe = new JLabel();
        pickaxe.setText("$" + cost[0]);
        pickaxe.setFont(new Font("Lexend", Font.BOLD, 15));
        pickaxe.setForeground(new Color(0x263159));
        pickaxe.setBounds(170, 530, 150, 55);
        frame.add(pickaxe);

        plow = new JLabel();
        plow.setText("$" + cost[1]);
        plow.setFont(new Font("Lexend", Font.BOLD, 15));
        plow.setForeground(new Color(0x263159));
        plow.setBounds(272, 530, 150, 55);
        frame.add(plow);

        shovel = new JLabel();
        shovel.setText("$" + cost[2]);
        shovel.setFont(new Font("Lexend", Font.BOLD, 15));
        shovel.setForeground(new Color(0x263159));
        shovel.setBounds(372, 530, 150, 55);
        frame.add(shovel);

        water = new JLabel();
        water.setText("$" + cost[3]);
        water.setFont(new Font("Lexend", Font.BOLD, 15));
        water.setForeground(new Color(0x263159));
        water.setBounds(472, 530, 150, 55);
        frame.add(water);

        fer = new JLabel();
        fer.setText("$" + cost[4]);
        fer.setFont(new Font("Lexend", Font.BOLD, 15));
        fer.setForeground(new Color(0x263159));
        fer.setBounds(570, 530, 150, 55);
        frame.add(fer);

        labelLevelCost = new JLabel();
        labelLevelCost.setText("$"+levelCost[l]);
        labelLevelCost.setFont(new Font("Lexend", Font.BOLD, 15));
        labelLevelCost.setForeground(new Color(0x263159));
        labelLevelCost.setBounds(1275, 132, 150, 55);
        frame.add(labelLevelCost);

        farmStatus = new JLabel();
        farmStatus.setText(status);
        farmStatus.setFont(new Font("Lexend", Font.BOLD, 15));
        farmStatus.setForeground(new Color(0x263159));
        farmStatus.setBounds(1240, 150, 150, 55);
        frame.add(farmStatus);
    }

    /**
     * It sets up the game window
     */
    public void launch() {
        // The settings for the game window
        frame.setSize(1400, 690);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0xF5EBE0));
        frame.setIconImage(image.getImage());
        frame.setTitle("My Farm Simulator");
        frame.setEnabled(true);

        // SETUP THE 5x10 TILES FOR THE THE CROPS TO BE PLANTED
        buttons();
        
        // SETUP THE 1X8 BUTTONS FOR THE TOOLS AND THE SKIP DAY BUTTON
        tool();

        // ON THE RIGHT SIDE OF THE PANEL, IT SHOULD SHOW THE LEVEL, THE EXP,THE COINS,THE DAYS, AND THE STATS OF THE PLAYER
        labels();
        picture = new JLabel();
        ImageIcon icon = new ImageIcon(new ImageIcon("farmer.gif").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		picture.setIcon(icon);
        picture.setBounds(1100, 200, 300, 300);
        frame.add(picture);

        // To make the window appear centered everytime you launched it
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        // make the window appear in the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setEnabled(true);
        frame.setVisible(true);
    }

     /**
     * This where all the tile button are located and initial setup is 
     */
    private void buttons() {
        /* This where all the tile button are located and initial setup is */
        tile[0][0] = new JButton("Unplowed");
        tile[0][0].setBackground(new Color(0x594545));
        tile[0][0].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][0].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][0].setForeground(Color.WHITE);
        tile[0][0].setBounds(10, 10, 100, 90);
        tile[0][0].setActionCommand("00");
        tile[0][0].addActionListener(this);
        tile[0][0].setFocusable(false);
        frame.add(tile[0][0]);

        tile[0][1] = new JButton("Unplowed");
        tile[0][1].setBackground(new Color(0x594545));
        tile[0][1].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][1].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][1].setForeground(Color.WHITE);
        tile[0][1].setBounds(120, 10, 100, 90);
        tile[0][1].setActionCommand("01");
        tile[0][1].addActionListener(this);
        tile[0][1].setFocusable(false);
        frame.add(tile[0][1]);

        tile[0][2] = new JButton("Unplowed");
        tile[0][2].setBackground(new Color(0x594545));
        tile[0][2].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][2].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][2].setForeground(Color.WHITE);
        tile[0][2].setBounds(230, 10, 100, 90);
        tile[0][2].setActionCommand("02");
        tile[0][2].addActionListener(this);
        tile[0][2].setFocusable(false);
        frame.add(tile[0][2]);

        tile[0][3] = new JButton("Unplowed");
        tile[0][3].setBackground(new Color(0x594545));
        tile[0][3].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][3].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][3].setForeground(Color.WHITE);
        tile[0][3].setBounds(340, 10, 100, 90);
        tile[0][3].setActionCommand("03");
        tile[0][3].addActionListener(this);
        tile[0][3].setFocusable(false);
        frame.add(tile[0][3]);

        tile[0][4] = new JButton("Unplowed");
        tile[0][4].setBackground(new Color(0x594545));
        tile[0][4].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][4].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][4].setForeground(Color.WHITE);
        tile[0][4].setBounds(450, 10, 100, 90);
        tile[0][4].setActionCommand("04");
        tile[0][4].addActionListener(this);
        tile[0][4].setFocusable(false);
        frame.add(tile[0][4]);

        tile[0][5] = new JButton("Unplowed");
        tile[0][5].setBackground(new Color(0x594545));
        tile[0][5].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][5].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][5].setForeground(Color.WHITE);
        tile[0][5].setBounds(560, 10, 100, 90);
        tile[0][5].setActionCommand("05");
        tile[0][5].addActionListener(this);
        tile[0][5].setFocusable(false);
        frame.add(tile[0][5]);

        tile[0][6] = new JButton("Unplowed");
        tile[0][6].setBackground(new Color(0x594545));
        tile[0][6].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][6].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][6].setForeground(Color.WHITE);
        tile[0][6].setBounds(670, 10, 100, 90);
        tile[0][6].setActionCommand("06");
        tile[0][6].addActionListener(this);
        tile[0][6].setFocusable(false);
        frame.add(tile[0][6]);

        tile[0][7] = new JButton("Unplowed");
        tile[0][7].setBackground(new Color(0x594545));
        tile[0][7].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][7].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][7].setForeground(Color.WHITE);
        tile[0][7].setBounds(782, 10, 100, 90);
        tile[0][7].setActionCommand("07");
        tile[0][7].addActionListener(this);
        tile[0][7].setFocusable(false);
        frame.add(tile[0][7]);

        tile[0][8] = new JButton("Unplowed");
        tile[0][8].setBackground(new Color(0x594545));
        tile[0][8].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][8].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][8].setForeground(Color.WHITE);
        tile[0][8].setBounds(893, 10, 100, 90);
        tile[0][8].setActionCommand("08");
        tile[0][8].addActionListener(this);
        tile[0][8].setFocusable(false);
        frame.add(tile[0][8]);

        tile[0][9] = new JButton("Unplowed");
        tile[0][9].setBackground(new Color(0x594545));
        tile[0][9].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[0][9].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[0][9].setForeground(Color.WHITE);
        tile[0][9].setBounds(1003, 10, 100, 90);
        tile[0][9].setActionCommand("09");
        tile[0][9].addActionListener(this);
        tile[0][9].setFocusable(false);
        frame.add(tile[0][9]);

        tile[1][0] = new JButton("Unplowed");
        tile[1][0].setBackground(new Color(0x594545));
        tile[1][0].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][0].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][0].setForeground(Color.WHITE);
        tile[1][0].setBounds(10, 120, 100, 90);
        tile[1][0].setActionCommand("10");
        tile[1][0].addActionListener(this);
        tile[1][0].setFocusable(false);
        frame.add(tile[1][0]);

        tile[1][1] = new JButton("Unplowed");
        tile[1][1].setBackground(new Color(0x594545));
        tile[1][1].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][1].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][1].setForeground(Color.WHITE);
        tile[1][1].setBounds(120, 120, 100, 90);
        tile[1][1].setActionCommand("11");
        tile[1][1].addActionListener(this);
        tile[1][1].setFocusable(false);
        frame.add(tile[1][1]);

        tile[1][2] = new JButton("Unplowed");
        tile[1][2].setBackground(new Color(0x594545));
        tile[1][2].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][2].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][2].setForeground(Color.WHITE);
        tile[1][2].setBounds(230, 120, 100, 90);
        tile[1][2].setActionCommand("12");
        tile[1][2].addActionListener(this);
        tile[1][2].setFocusable(false);
        frame.add(tile[1][2]);

        tile[1][3] = new JButton("Unplowed");
        tile[1][3].setBackground(new Color(0x594545));
        tile[1][3].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][3].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][3].setForeground(Color.WHITE);
        tile[1][3].setBounds(340, 120, 100, 90);
        tile[1][3].setActionCommand("13");
        tile[1][3].addActionListener(this);
        tile[1][3].setFocusable(false);
        frame.add(tile[1][3]);

        tile[1][4]= new JButton("Unplowed");
        tile[1][4].setBackground(new Color(0x594545));
        tile[1][4].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][4].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][4].setForeground(Color.WHITE);
        tile[1][4].setBounds(450, 120, 100, 90);
        tile[1][4].setActionCommand("14");
        tile[1][4].addActionListener(this);
        tile[1][4].setFocusable(false);
        frame.add( tile[1][4]);

        tile[1][5] = new JButton("Unplowed");
        tile[1][5].setBackground(new Color(0x594545));
        tile[1][5].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][5].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][5].setForeground(Color.WHITE);
        tile[1][5].setBounds(560, 120, 100, 90);
        tile[1][5].setActionCommand("15");
        tile[1][5].addActionListener(this);
        tile[1][5].setFocusable(false);
        frame.add(tile[1][5]);

        tile[1][6] = new JButton("Unplowed");
        tile[1][6].setBackground(new Color(0x594545));
        tile[1][6].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][6].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][6].setForeground(Color.WHITE);
        tile[1][6].setBounds(670, 120, 100, 90);
        tile[1][6].setActionCommand("16");
        tile[1][6].addActionListener(this);
        tile[1][6].setFocusable(false);
        frame.add(tile[1][6]);

        tile[1][7] = new JButton("Unplowed");
        tile[1][7].setBackground(new Color(0x594545));
        tile[1][7].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][7].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][7].setForeground(Color.WHITE);
        tile[1][7].setBounds(782, 120, 100, 90);
        tile[1][7].setActionCommand("17");
        tile[1][7].addActionListener(this);
        tile[1][7].setFocusable(false);
        frame.add(tile[1][7]);

        tile[1][8] = new JButton("Unplowed");
        tile[1][8].setBackground(new Color(0x594545));
        tile[1][8].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][8].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][8].setForeground(Color.WHITE);
        tile[1][8].setBounds(893, 120, 100, 90);
        tile[1][8].setActionCommand("18");
        tile[1][8].addActionListener(this);
        tile[1][8].setFocusable(false);
        frame.add(tile[1][8]);

        tile[1][9] = new JButton("Unplowed");
        tile[1][9].setBackground(new Color(0x594545));
        tile[1][9].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[1][9].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[1][9].setForeground(Color.WHITE);
        tile[1][9].setBounds(1003, 120, 100, 90);
        tile[1][9].setActionCommand("19");
        tile[1][9].addActionListener(this);
        tile[1][9].setFocusable(false);
        frame.add(tile[1][9]);

        tile[2][0] = new JButton("Unplowed");
        tile[2][0].setBackground(new Color(0x594545));
        tile[2][0].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][0].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][0].setForeground(Color.WHITE);
        tile[2][0].setBounds(10, 230, 100, 90);
        tile[2][0].setActionCommand("20");
        tile[2][0].addActionListener(this);
        tile[2][0].setFocusable(false);
        frame.add(tile[2][0]);

        tile[2][1] = new JButton("Unplowed");
        tile[2][1].setBackground(new Color(0x594545));
        tile[2][1].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][1].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][1].setForeground(Color.WHITE);
        tile[2][1].setBounds(120, 230, 100, 90);
        tile[2][1].setActionCommand("21");
        tile[2][1].addActionListener(this);
        tile[2][1].setFocusable(false);
        frame.add(tile[2][1]);

        tile[2][2] = new JButton("Unplowed");
        tile[2][2].setBackground(new Color(0x594545));
        tile[2][2].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][2].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][2].setForeground(Color.WHITE);
        tile[2][2].setBounds(230, 230, 100, 90);
        tile[2][2].setActionCommand("22");
        tile[2][2].addActionListener(this);
        tile[2][2].setFocusable(false);
        frame.add(tile[2][2]);

        tile[2][3] = new JButton("Unplowed");
        tile[2][3].setBackground(new Color(0x594545));
        tile[2][3].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][3].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][3].setForeground(Color.WHITE);
        tile[2][3].setBounds(340, 230, 100, 90);
        tile[2][3].setActionCommand("23");
        tile[2][3].addActionListener(this);
        tile[2][3].setFocusable(false);
        frame.add(tile[2][3]);

        tile[2][4] = new JButton("Unplowed");
        tile[2][4].setBackground(new Color(0x594545));
        tile[2][4].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][4].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][4].setForeground(Color.WHITE);
        tile[2][4].setBounds(450, 230, 100, 90);
        tile[2][4].setActionCommand("24");
        tile[2][4].addActionListener(this);
        tile[2][4].setFocusable(false);
        frame.add(tile[2][4]);

        tile[2][5] = new JButton("Unplowed");
        tile[2][5].setBackground(new Color(0x594545));
        tile[2][5].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][5].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][5].setForeground(Color.WHITE);
        tile[2][5].setBounds(560, 230, 100, 90);
        tile[2][5].setActionCommand("25");
        tile[2][5].addActionListener(this);
        tile[2][5].setFocusable(false);
        frame.add(tile[2][5]);

        tile[2][6] = new JButton("Unplowed");
        tile[2][6].setBackground(new Color(0x594545));
        tile[2][6].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][6].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][6].setForeground(Color.WHITE);
        tile[2][6].setBounds(670, 230, 100, 90);
        tile[2][6].setActionCommand("26");
        tile[2][6].addActionListener(this);
        tile[2][6].setFocusable(false);
        frame.add(tile[2][6]);

        tile[2][7] = new JButton("Unplowed");
        tile[2][7].setBackground(new Color(0x594545));
        tile[2][7].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][7].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][7].setForeground(Color.WHITE);
        tile[2][7].setBounds(782, 230, 100, 90);
        tile[2][7].setActionCommand("27");
        tile[2][7].addActionListener(this);
        tile[2][7].setFocusable(false);
        frame.add(tile[2][7]);

        tile[2][8] = new JButton("Unplowed");
        tile[2][8].setBackground(new Color(0x594545));
        tile[2][8].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][8].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][8].setForeground(Color.WHITE);
        tile[2][8].setBounds(893, 230, 100, 90);
        tile[2][8].setActionCommand("28");
        tile[2][8].addActionListener(this);
        tile[2][8].setFocusable(false);
        frame.add(tile[2][8]);

        tile[2][9] = new JButton("Unplowed");
        tile[2][9].setBackground(new Color(0x594545));
        tile[2][9].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[2][9].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[2][9].setForeground(Color.WHITE);
        tile[2][9].setBounds(1003, 230, 100, 90);
        tile[2][9].setActionCommand("29");
        tile[2][9].addActionListener(this);
        tile[2][9].setFocusable(false);
        frame.add(tile[2][9]);

        tile[3][0] = new JButton("Unplowed");
        tile[3][0].setBackground(new Color(0x594545));
        tile[3][0].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][0].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][0].setForeground(Color.WHITE);
        tile[3][0].setBounds(10, 340, 100, 90);
        tile[3][0].setActionCommand("30");
        tile[3][0].addActionListener(this);
        tile[3][0].setFocusable(false);
        frame.add(tile[3][0]);

        tile[3][1] = new JButton("Unplowed");
        tile[3][1].setBackground(new Color(0x594545));
        tile[3][1].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][1].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][1].setForeground(Color.WHITE);
        tile[3][1].setBounds(120, 340, 100, 90);
        tile[3][1].setActionCommand("31");
        tile[3][1].addActionListener(this);
        tile[3][1].setFocusable(false);
        frame.add(tile[3][1]);

        tile[3][2] = new JButton("Unplowed");
        tile[3][2].setBackground(new Color(0x594545));
        tile[3][2].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][2].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][2].setForeground(Color.WHITE);
        tile[3][2].setBounds(230, 340, 100, 90);
        tile[3][2].setActionCommand("32");
        tile[3][2].addActionListener(this);
        tile[3][2].setFocusable(false);
        frame.add(tile[3][2]);

        tile[3][3] = new JButton("Unplowed");
        tile[3][3].setBackground(new Color(0x594545));
        tile[3][3].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][3].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][3].setForeground(Color.WHITE);
        tile[3][3].setBounds(340, 340, 100, 90);
        tile[3][3].setActionCommand("33");
        tile[3][3].addActionListener(this);
        tile[3][3].setFocusable(false);
        frame.add(tile[3][3]);

        tile[3][4] = new JButton("Unplowed");
        tile[3][4].setBackground(new Color(0x594545));
        tile[3][4].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][4].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][4].setForeground(Color.WHITE);
        tile[3][4].setBounds(450, 340, 100, 90);
        tile[3][4].setActionCommand("34");
        tile[3][4].addActionListener(this);
        tile[3][4].setFocusable(false);
        frame.add(tile[3][4]);

        tile[3][5] = new JButton("Unplowed");
        tile[3][5].setBackground(new Color(0x594545));
        tile[3][5].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][5].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][5].setForeground(Color.WHITE);
        tile[3][5].setBounds(560, 340, 100, 90);
        tile[3][5].setActionCommand("35");
        tile[3][5].addActionListener(this);
        tile[3][5].setFocusable(false);
        frame.add(tile[3][5]);

        tile[3][6] = new JButton("Unplowed");
        tile[3][6].setBackground(new Color(0x594545));
        tile[3][6].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][6].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][6].setForeground(Color.WHITE);
        tile[3][6].setBounds(670, 340, 100, 90);
        tile[3][6].setActionCommand("36");
        tile[3][6].addActionListener(this);
        tile[3][6].setFocusable(false);
        frame.add(tile[3][6]);

        tile[3][7] = new JButton("Unplowed");
        tile[3][7].setBackground(new Color(0x594545));
        tile[3][7].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][7].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][7].setForeground(Color.WHITE);
        tile[3][7].setBounds(782, 340, 100, 90);
        tile[3][7].setActionCommand("37");
        tile[3][7].addActionListener(this);
        tile[3][7].setFocusable(false);
        frame.add(tile[3][7]);

        tile[3][8] = new JButton("Unplowed");
        tile[3][8].setBackground(new Color(0x594545));
        tile[3][8].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][8].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][8].setForeground(Color.WHITE);
        tile[3][8].setBounds(893, 340, 100, 90);
        tile[3][8].setActionCommand("38");
        tile[3][8].addActionListener(this);
        tile[3][8].setFocusable(false);
        frame.add(tile[3][8]);

        tile[3][9] = new JButton("Unplowed");
        tile[3][9].setBackground(new Color(0x594545));
        tile[3][9].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[3][9].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[3][9].setForeground(Color.WHITE);
        tile[3][9].setBounds(1003, 340, 100, 90);
        tile[3][9].setActionCommand("39");
        tile[3][9].addActionListener(this);
        tile[3][9].setFocusable(false);
        frame.add(tile[3][9]);

        tile[4][0] = new JButton("Unplowed");
        tile[4][0].setBackground(new Color(0x594545));
        tile[4][0].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][0].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][0].setForeground(Color.WHITE);
        tile[4][0].setBounds(10, 450, 100, 90);
        tile[4][0].setActionCommand("40");
        tile[4][0].addActionListener(this);
        tile[4][0].setFocusable(false);
        frame.add(tile[4][0]);

        tile[4][1] = new JButton("Unplowed");
        tile[4][1].setBackground(new Color(0x594545));
        tile[4][1].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][1].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][1].setForeground(Color.WHITE);
        tile[4][1].setBounds(120, 450, 100, 90);
        tile[4][1].setActionCommand("41");
        tile[4][1].addActionListener(this);
        tile[4][1].setFocusable(false);
        frame.add(tile[4][1]);

        tile[4][2] = new JButton("Unplowed");
        tile[4][2].setBackground(new Color(0x594545));
        tile[4][2].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][2].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][2].setForeground(Color.WHITE);
        tile[4][2].setBounds(230, 450, 100, 90);
        tile[4][2].setActionCommand("42");
        tile[4][2].addActionListener(this);
        tile[4][2].setFocusable(false);
        frame.add(tile[4][2]);

        tile[4][3] = new JButton("Unplowed");
        tile[4][3].setBackground(new Color(0x594545));
        tile[4][3].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][3].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][3].setForeground(Color.WHITE);
        tile[4][3].setBounds(340, 450, 100, 90);
        tile[4][3].setActionCommand("43");
        tile[4][3].addActionListener(this);
        tile[4][3].setFocusable(false);
        frame.add(tile[4][3]);

        tile[4][4] = new JButton("Unplowed");
        tile[4][4].setBackground(new Color(0x594545));
        tile[4][4].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][4].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][4].setForeground(Color.WHITE);
        tile[4][4].setBounds(450, 450, 100, 90);
        tile[4][4].setActionCommand("44");
        tile[4][4].addActionListener(this);
        tile[4][4].setFocusable(false);
        frame.add(tile[4][4]);

        tile[4][5] = new JButton("Unplowed");
        tile[4][5].setBackground(new Color(0x594545));
        tile[4][5].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][5].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][5].setForeground(Color.WHITE);
        tile[4][5].setBounds(560, 450, 100, 90);
        tile[4][5].setActionCommand("45");
        tile[4][5].addActionListener(this);
        tile[4][5].setFocusable(false);
        frame.add(tile[4][5]);

        tile[4][6] = new JButton("Unplowed");
        tile[4][6].setBackground(new Color(0x594545));
        tile[4][6].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][6].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][6].setForeground(Color.WHITE);
        tile[4][6].setBounds(670, 450, 100, 90);
        tile[4][6].setActionCommand("46");
        tile[4][6].addActionListener(this);
        tile[4][6].setFocusable(false);
        frame.add(tile[4][6]);

        tile[4][7] = new JButton("Unplowed");
        tile[4][7].setBackground(new Color(0x594545));
        tile[4][7].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][7].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][7].setForeground(Color.WHITE);
        tile[4][7].setBounds(782, 450, 100, 90);
        tile[4][7].setActionCommand("47");
        tile[4][7].addActionListener(this);
        tile[4][7].setFocusable(false);
        frame.add(tile[4][7]);

        tile[4][8] = new JButton("Unplowed");
        tile[4][8].setBackground(new Color(0x594545));
        tile[4][8].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][8].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][8].setForeground(Color.WHITE);
        tile[4][8].setBounds(893, 450, 100, 90);
        tile[4][8].setActionCommand("48");
        tile[4][8].addActionListener(this);
        tile[4][8].setFocusable(false);
        frame.add(tile[4][8]);

        tile[4][9] = new JButton("Unplowed");
        tile[4][9].setBackground(new Color(0x594545));
        tile[4][9].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tile[4][9].setFont(new Font("Lexend", Font.BOLD, 15));
        tile[4][9].setForeground(Color.WHITE);
        tile[4][9].setBounds(1003, 450, 100, 90);
        tile[4][9].setActionCommand("49");
        tile[4][9].addActionListener(this);
        tile[4][9].setFocusable(false);
        frame.add(tile[4][9]);

    }

     /**
     * It creates a button, sets the icon, sets the text position, sets the background color, sets the
     * font, sets the border, sets the foreground color, sets the bounds, sets the action command, adds
     * an action listener, sets the focusable, and adds it to the frame.
     */
    private void tool() {
        /* This where all the Tools button are located and initial setup is */

        tools[0] = new JButton("Pickaxe");
        ImageIcon pickIcon = new ImageIcon(new ImageIcon("pickaxe.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        tools[0].setIcon(pickIcon);
        tools[0].setHorizontalTextPosition(JButton.CENTER);
        tools[0].setVerticalTextPosition(JButton.TOP);
        tools[0].setBackground(new Color(0x495C83));
        tools[0].setFont(new Font("Lexend", Font.BOLD, 15));
        tools[0].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tools[0].setForeground(Color.WHITE);
        tools[0].setBounds(140, 570, 90, 65);
        tools[0].setActionCommand("50");
        tools[0].addActionListener(this);
        tools[0].setFocusable(false);
        frame.add(tools[0]);

        tools[1] = new JButton("Plow");
        ImageIcon plowIcon = new ImageIcon(new ImageIcon("plow.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        tools[1].setIcon(plowIcon);
        tools[1].setHorizontalTextPosition(JButton.CENTER);
        tools[1].setVerticalTextPosition(JButton.TOP);
        tools[1].setBackground(new Color(0x495C83));
        tools[1].setFont(new Font("Lexend", Font.BOLD, 15));
        tools[1].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tools[1].setForeground(Color.WHITE);
        tools[1].setBounds(240, 570, 90, 65);
        tools[1].setActionCommand("51");
        tools[1].addActionListener(this);
        tools[1].setFocusable(false);
        frame.add(tools[1]);

        tools[2] = new JButton("Shovel");
        ImageIcon shovelIcon = new ImageIcon(new ImageIcon("shovel.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        tools[2].setIcon(shovelIcon);
        tools[2].setHorizontalTextPosition(JButton.CENTER);
        tools[2].setVerticalTextPosition(JButton.TOP);
        tools[2].setBackground(new Color(0x495C83));
        tools[2].setFont(new Font("Lexend", Font.BOLD, 15));
        tools[2].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tools[2].setForeground(Color.WHITE);
        tools[2].setBounds(340, 570, 90, 65);
        tools[2].setActionCommand("52");
        tools[2].addActionListener(this);
        tools[2].setFocusable(false);
        frame.add(tools[2]);

        tools[3] = new JButton("Water");
        ImageIcon waterIcon = new ImageIcon(new ImageIcon("water.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        tools[3].setIcon(waterIcon);
        tools[3].setHorizontalTextPosition(JButton.CENTER);
        tools[3].setVerticalTextPosition(JButton.TOP);
        tools[3].setBackground(new Color(0x495C83));
        tools[3].setFont(new Font("Lexend", Font.BOLD, 15));
        tools[3].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tools[3].setForeground(Color.WHITE);
        tools[3].setBounds(440, 570, 90, 65);
        tools[3].setActionCommand("53");
        tools[3].addActionListener(this);
        tools[3].setFocusable(false);
        frame.add(tools[3]);

        tools[4] = new JButton("Fertilize");
        ImageIcon fertIcon = new ImageIcon(new ImageIcon("fertilizer.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        tools[4].setIcon(fertIcon);
        tools[4].setHorizontalTextPosition(JButton.CENTER);
        tools[4].setVerticalTextPosition(JButton.TOP);
        tools[4].setBackground(new Color(0x495C83));
        tools[4].setFont(new Font("Lexend", Font.BOLD, 15));
        tools[4].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tools[4].setForeground(Color.WHITE);
        tools[4].setBounds(540, 570, 90, 65);
        tools[4].setActionCommand("54");
        tools[4].addActionListener(this);
        tools[4].setFocusable(false);
        frame.add(tools[4]);

        tools[5] = new JButton("Harvest");
        ImageIcon harvestIcon = new ImageIcon(new ImageIcon("harvest.gif").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        tools[5].setIcon(harvestIcon);
        tools[5].setHorizontalTextPosition(JButton.CENTER);
        tools[5].setVerticalTextPosition(JButton.TOP);
        tools[5].setBackground(new Color(0x495C83));
        tools[5].setFont(new Font("Lexend", Font.BOLD, 15));
        tools[5].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        tools[5].setForeground(Color.WHITE);
        tools[5].setBounds(640, 570, 90, 65);
        tools[5].setActionCommand("55");
        tools[5].addActionListener(this);
        tools[5].setFocusable(false);
        frame.add(tools[5]);

        skip = new JButton("Skip Day");
        ImageIcon skipIcon = new ImageIcon(new ImageIcon("nextday.gif").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        skip.setIcon(skipIcon);
        skip.setHorizontalTextPosition(JButton.CENTER);
        skip.setVerticalTextPosition(JButton.TOP);
        skip.setBackground(new Color(0x495C83));
        skip.setFont(new Font("Lexend", Font.BOLD, 15));
        skip.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        skip.setForeground(Color.WHITE);
        skip.setActionCommand("56");
        skip.setBounds(740, 570, 90, 65);
        skip.addActionListener(this);
        skip.setFocusable(false);
        frame.add(skip);

        quit = new JButton("Quit");
        quit.setBackground(new Color(0x495C83));
        quit.setFont(new Font("Lexend", Font.BOLD, 15));
        quit.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        quit.setForeground(Color.WHITE);
        quit.setActionCommand("58");
        quit.setBounds(1275, 570, 75, 55);
        quit.addActionListener(this);
        quit.setFocusable(false);
        frame.add(quit);

        levelUp = new JButton("Level Up");
        levelUp.setBackground(new Color(0x495C83));
        levelUp.setFont(new Font("Lexend", Font.BOLD, 15));
        levelUp.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        levelUp.setForeground(Color.WHITE);
        levelUp.setActionCommand("57");
        levelUp.setBounds(1258, 115, 90, 30);
        levelUp.addActionListener(this);
        levelUp.setFocusable(false);
        levelUp.setEnabled(false);
        frame.add(levelUp);
    }
   
    // Calling the launch method.
    public MyFarm() {
        launch();
    }
    
    /**
     * "If the cropList window is open, disable the main window."
     */
    private void pause() {
        // to disable the window while if the cropList window is open
        Window w = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
        if (w.isActive() == true) {
            frame.setEnabled(false);
        }
    }

    /**
     * to re enable all the tools
     */
    private void reset() {
        // to re enable all the tools
        for (int i = 0; i < tools.length; i++) {
            tools[i].setEnabled(true);
        }
    }
       
    /**
    * It's a function that checks if the tile is empty and if it is, it will check if the player has a
    * tool that can be used on the tile. If the player has a tool that can be used on the tile, it will
    * be used. If the player has no tool that can be used on the tile, it will show a message dialog
    * that says "This tile has no rocks" or "There is something at the tile".
    */
    private void tileNoCrop() {
        /*This function serves as the behaviour functions on how the tools should interact while the tile is empty */
        if (tools[0].isEnabled() == false && tile[tileRow][tileColumn].getText() == "Rocks") {//Pickaxe
            p.subtractCoin(cost[0]);
            p.addExp(15);
            tile[tileRow][tileColumn].setText("Unplowed");
            tile[tileRow][tileColumn].setBackground(new Color(0x594545));
            tile[tileRow][tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
            tile[tileRow][tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
            tile[tileRow][tileColumn].setForeground(Color.WHITE);
            tile[tileRow][tileColumn].setIcon(null);
            tools[0].setEnabled(true);
        } else if (tools[0].isEnabled() == false && tile[tileRow][tileColumn].getText() != "Rocks") {//pickaxe
            JOptionPane.showMessageDialog(frame, "This Tile Has no Rocks");
        } else if (tools[1].isEnabled() == false && tile[tileRow][tileColumn].getText() == "Unplowed") {//plow
        	 tile[tileRow][tileColumn].setBackground(new Color(0xA77979));
        	 tile[tileRow][tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        	 tile[tileRow][tileColumn].setForeground(Color.WHITE);
            tile[tileRow][tileColumn].setText("Plowed");
            p.addExp(0.5);
        } else if (tools[1].isEnabled() == false && (tile[tileRow][tileColumn].getText() == "Rocks"||tile[tileRow][tileColumn].getText() == "Withered")) {//plow
            JOptionPane.showMessageDialog(frame, "There is something at the tile");
        } else if (tools[2].isEnabled() == false && (tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Unplowed"|| tile[tileRow][tileColumn].getText() == "Plowed")) {
            //shovel
            p.subtractCoin(cost[2]);
            JOptionPane.showMessageDialog(frame, "This Tile has no Crops or Withered Crops to remove");
        }
        else if(tools[2].isEnabled() == false && tile[tileRow][tileColumn].getText() == "Withered"){
            p.subtractCoin(cost[2]);
            p.addExp(2);
            tile[tileRow][tileColumn].setText("Unplowed");
            tile[tileRow][tileColumn].setBackground(new Color(0x594545));
       	 	tile[tileRow][tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
       	 	tile[tileRow][tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
       	 	tile[tileRow][tileColumn].setIcon(null);;
       	 	tile[tileRow][tileColumn].setForeground(Color.WHITE);
            JOptionPane.showMessageDialog(frame, "The withered Crop has been removed");
        }
        else if ((tools[3].isEnabled() == false || tools[4].isEnabled() == false || tools[5].isEnabled() == false)
                && (tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Unplowed"
                || tile[tileRow][tileColumn].getText() == "Withered" || tile[tileRow][tileColumn].getText() == "Plowed")) {// water and fertilizer
            JOptionPane.showMessageDialog(frame, "The tile has no Crop planted");
        } else if (tile[tileRow][tileColumn].getText() == "Plowed" && (tools[0].isEnabled() == true
                && tools[1].isEnabled() == true && tools[2].isEnabled() == true && tools[3].isEnabled() == true
                && tools[4].isEnabled() == true && tools[5].isEnabled() == true)) { // if it has no rocks and it plowed, you may plant  your crop
            cl = new CropList();
            pause();
        }
    }
  
    /**
     * It checks if the minProd is 0 and changes the JTP.settext()
     */
    private void jtpSetter(){
         // check if the minProd is 0 and changes the JTP.settext()
         if(myData.getTile(tileRow, tileColumn).getMinProd() == 0){
            jtp.setText("Water: " +myData.getTile(tileRow, tileColumn).getCurrWater() + "/"
                + myData.getTile(tileRow, tileColumn).getMinWater() + "("
                + myData.getTile(tileRow, tileColumn).getMaxWater() + ")\n"
                + "Fertilizer: " +myData.getTile(tileRow, tileColumn).getCurrFert()+ "/" + myData.getTile(tileRow, tileColumn).getMinFert()+"(" + myData.getTile(tileRow, tileColumn).getMaxFert()+")\n"
                + "Product Produce: "+myData.getTile(tileRow, tileColumn).getMaxProd()+"\n"
                + "Selling price per piece: "+myData.getTile(tileRow, tileColumn).getSell()+"\n"
                + "Harvest Days in: "+myData.getTile(tileRow, tileColumn).getHarvestDay()+" Days\n"
                + "EXP yield: "+ myData.getTile(tileRow, tileColumn).getExp());
        }
        else{
            jtp.setText("Water: " +myData.getTile(tileRow, tileColumn).getCurrWater() + "/"
                + myData.getTile(tileRow, tileColumn).getMinWater() + "("
                + myData.getTile(tileRow, tileColumn).getMaxWater() + ")\n"
                + "Fertilizer: " +myData.getTile(tileRow, tileColumn).getCurrFert()+ "/" + myData.getTile(tileRow, tileColumn).getMinFert()+"(" + myData.getTile(tileRow, tileColumn).getMaxFert()+")\n"
                + "Product Produce: "+ myData.getTile(tileRow, tileColumn).getMinProd()+" - "+myData.getTile(tileRow, tileColumn).getMaxProd()+"\n"
                + "Selling price per piece: "+myData.getTile(tileRow, tileColumn).getSell()+"\n"
                + "Harvest Days in: "+myData.getTile(tileRow, tileColumn).getHarvestDay()+" Days\n"
                + "EXP yield: "+ myData.getTile(tileRow, tileColumn).getExp());
        }
    }
    
    /**
     * It's a function that checks if the tile is empty or not, and if it's not empty, it will check if
     * the tile has a crop planted in it, and if it does, it will show the crop's stats.
     */
    private void tileWithCrop() {
    
        /*This function serves as the behaviour functions on how the tools should interact while the tile is NOT empty */
        jtpSetter();
        
        if (!(tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Withered"||tile[tileRow][tileColumn].getText() == "Unplowed"|| tile[tileRow][tileColumn].getText() == "Plowed") && (tools[0].isEnabled() == true && tools[1].isEnabled() == true && tools[2].isEnabled() == true&& tools[3].isEnabled() == true && tools[4].isEnabled() == true&& tools[5].isEnabled() == true)) {
            /* if there is a crop planted tile, its stats will be shown if the tile is click upon */
            JOptionPane.showMessageDialog(jtp, jtp.getText(),  myData.getTile(tileRow, tileColumn).getCropName()+ " Stats",JOptionPane.INFORMATION_MESSAGE);
        } 
        else if ((tools[0].isEnabled() == false || tools[1].isEnabled() == false)
                && !(tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Unplowed"
                        || tile[tileRow][tileColumn].getText() == "Withered" || tile[tileRow][tileColumn].getText() == "Plowed")) { // pickaxe
            JOptionPane.showMessageDialog(frame, "There is an Crop planted in the tile");
        } 
        else if (tools[2].isEnabled() == false && !(tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Unplowed"|| tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Plowed")) {
            if(JOptionPane.showConfirmDialog(frame, "Remove the crop?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { // shovel
                // yes option
                p.addExp(2);
                p.subtractCoin(cost[2]);
                tile[tileRow][tileColumn].setText("Unplowed");
                tile[tileRow][tileColumn].setBackground(new Color(0x594545));
                tile[tileRow][tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
           	 	tile[tileRow][tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
           	 	tile[tileRow][tileColumn].setForeground(Color.WHITE);
           	 	tile[tileRow][tileColumn].setIcon(null);
                myData.removeTile(tileRow, tileColumn);
            } 
            else {
                // no option

            }
        } 
        else if (tools[3].isEnabled() == false) { // water
           if(myData.getTile(tileRow, tileColumn).getCurrWater() >= 
           myData.getTile(tileRow, tileColumn).getMaxWater() ){
                JOptionPane.showMessageDialog(frame, "The Water Level is already at its max");
            }
            else{
                if(myData.getTile(tileRow, tileColumn).getHarvestDay() != 0){
                    p.addExp(0.5);
                    myData.getTile(tileRow, tileColumn).addWater();
                }
                
            }
        } 
        else if (tools[4].isEnabled() == false) { // fertilizer
            if(myData.getTile(tileRow, tileColumn).getCurrFert() >=
                myData.getTile(tileRow, tileColumn).getMaxFert() ){
                JOptionPane.showMessageDialog(frame, "The Fertilizer Level is already at its max");
            }
            else{
                if(myData.getTile(tileRow, tileColumn).getHarvestDay() != 0){
                    p.addExp(4);
                    p.subtractCoin(cost[4]);
                    myData.getTile(tileRow, tileColumn).addFert();
                }
            }
            
        } 
        else if (tools[5].isEnabled() == false) { // harvest
            DecimalFormat df = new DecimalFormat("0.00");
            double harvest = myData.getTile(tileRow, tileColumn).getProduced() * myData.getTile(tileRow, tileColumn).getSell();
            double waterBonus =  harvest* 0.2* (myData.getTile(tileRow, tileColumn).getCurrWater()-1);
            double fertilizerBonus = harvest *0.5 * myData.getTile(tileRow, tileColumn).getCurrFert();
            double finalHarvestPrice = harvest + waterBonus + fertilizerBonus;
            if(myData.getTile(tileRow, tileColumn).getCropType() == "Flower"){
                finalHarvestPrice = finalHarvestPrice * 1.1;
            }
            tools[5].setEnabled(false);
            if(myData.getTile(tileRow, tileColumn).getHarvestDay() == 0){
                p.addExp(myData.getTile(tileRow, tileColumn).getExp());
                JOptionPane.showMessageDialog(frame, "You harvested: "+ myData.getTile(tileRow, tileColumn).getProduced()+" "
                + myData.getTile(tileRow, tileColumn).getCropName()+"(s) \nYou Earned: $"+df.format(finalHarvestPrice) +"\nExperience Gained: "
                + myData.getTile(tileRow, tileColumn).getExp());
                p.addCoin(finalHarvestPrice);
                tile[tileRow][tileColumn].setText("Unplowed");
                tile[tileRow][tileColumn].setBackground(new Color(0x594545));
           	 	tile[tileRow][tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
           	 	tile[tileRow][tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
           	 	tile[tileRow][tileColumn].setForeground(Color.WHITE);
           	 	tile[tileRow][tileColumn].setIcon(null);
                myData.removeTile(tileRow, tileColumn);
            }
            else{
                JOptionPane.showMessageDialog(frame, "The Crop is still not ripe");

            }
            
        }

    }
    
    /**
     * This function serves as the game condition if it will end the game or not
     */
    private void gameOver(){
        // this fuction serve as the game condition if it will end the game or not
        int  a = 0;
        for(int i = 0; i < 5; i++){
            for(int j=0; j< 10; j++){
                if(p.getCoin() < 5  && myData.getTile(i, j) == null ){
                    a++;               
                }
            }
        }
        if(a == 50){
            GameOver g = new GameOver();
            frame.dispose();
        }
    }
    /**
     * If the tile is not a crop, then do this, else do that
     */
    private void cmd() {
        //checks which behaviour will be choosen
        if ((tile[tileRow][tileColumn].getText() == "Rocks" || tile[tileRow][tileColumn].getText() == "Unplowed" || tile[tileRow][tileColumn].getText() == "Plowed" || tile[tileRow][tileColumn].getText() == "Withered")) {
            tileNoCrop();
        } else {
            tileWithCrop();
        }
        reset();
    }


     // The above code is the actionPerformed method of the ActionListener class. It is the method that
    // is called when a button is pressed.
    private void HarvestMe(int row, int col){
        // checks the crops if its ripe and will chance the button if it is 
       if(myData.getTile(row, col).getHarvestDay() == 0){
           tile[row][col].setText("Harvest me!");
           tile[row][col].setBackground(new Color(0xEC7272));
           tile[row][col].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
           tile[row][col].setFont(new Font("Lexend", Font.BOLD, 13));
           tile[row][col].setForeground(Color.BLACK);
           tile[row][col].setIcon(null);
          
       }
            

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // What each button would do
        try {
            myData.tileChecker(tileRow, tileColumn);      
        } catch (Exception c) {
            // TODO: handle exception
        }
        int nos;
        String src = e.getActionCommand();
        nos = Integer.parseInt(src);
        if (nos < 50) {
            tileRow = Character.getNumericValue(src.charAt(0));
            tileColumn = Character.getNumericValue(src.charAt(1));
            cmd();
        } else if (nos > 49) {
            int ToolNos = nos - 50;
            reset();
            if (ToolNos < 6) {
                if (p.getCoin() < cost[ToolNos]) {
                    JOptionPane.showMessageDialog(frame, "You don't have enough coins");
                    reset();
                } else {
                    tools[ToolNos].setEnabled(false);
                }
            } else {
                if (src.equals("56")) { // skipDay
                    for(int i =0; i < 5; i++){
                        for(int j=0; j < 10; j++){
                            if(myData.getTile(i, j)!= null ){
                                if(myData.getTile(i,j) != null &&(myData.getTile(i,j).getCurrWater() < myData.getTile(i,j).getMinWater())){
                                   JOptionPane.showMessageDialog(frame, "The Crop Withered because of thirst"); 
                                   tile[i][j].setText("Withered"); 
                                   tile[i][j].setBackground(Color.BLACK);
                              	   tile[i][j].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                              	   tile[i][j].setFont(new Font("Lexend", Font.BOLD, 15));
                              	   tile[i][j].setIcon(null);
                              	   tile[i][j].setForeground(Color.WHITE);
                                   myData.removeTile(i, j);
                                }
                                else if(myData.getTile(i,j) != null&&( myData.getTile(i,j).getCurrFert() < myData.getTile(i,j).getMinFert())){
                                    JOptionPane.showMessageDialog(frame, "The Crop Withered because of hunger"); 
                                    tile[i][j].setText("Withered");
                                    tile[i][j].setBackground(Color.BLACK);
                               	    tile[i][j].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                               	    tile[i][j].setFont(new Font("Lexend", Font.BOLD, 15));
                               	    tile[i][j].setIcon(null);
                               	    tile[i][j].setForeground(Color.WHITE);
                                    myData.removeTile(i, j);
                                } 
                                else if(myData.getTile(i,j) != null && myData.getTile(i,j).getHarvestDay() < 1 ){
                                    JOptionPane.showMessageDialog(frame, "The Crop Withered because you did not harvest during the harvestDay"); 
                                    tile[i][j].setText("Withered");
                                    tile[i][j].setBackground(Color.BLACK);
                               	   	tile[i][j].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                               	   	tile[i][j].setFont(new Font("Lexend", Font.BOLD, 15));
                               	   	tile[i][j].setIcon(null);
                               	   	tile[i][j].setForeground(Color.WHITE);
                                    myData.removeTile(i,j);
                                }
                               
                                if(myData.getTile(i,j) != null){
                                    myData.getTile(i,j).nextDay();
                                    HarvestMe(i, j);
                                } 
                                
    
                               
                                
                            }
                        }
                        
                    }                   
                    p.nextDay();
                } 
                else if(src.equals("57")){
                    if(p.getCoin() < levelCost[l]){
                        JOptionPane.showMessageDialog(frame, "You don't have enough coins");
                    }
                    else{   
                        p.subtractCoin(levelCost[l]);
                        p.updateLevel();
                        levelUp.setEnabled(false);
                        if(p.getLevel()==5){
                            l=1;
                            status = "Registered Farmer";
                        }
                        else if(p.getLevel()==10){
                           l=2;
                           status = "Distinguished Farmer";
                        }
                        else if(p.getLevel() == 15) {
                            status = "Legendary Farmer";        
                            frame.remove(levelUp);
                            frame.remove(Exp);    
                            frame.remove(labelLevelCost);  
                        }
                       rLabels();
                    }
                }
                else if (src.equals("58")) { //Quit
                    System.exit(0);
                }
            }
        }
        
        if(p.getExp() >= p.getExpCap()){
            p.setExp(p.getExpCap());
            levelUp.setEnabled(true);
        }
        gameOver();
        rLabels();
    }
}
