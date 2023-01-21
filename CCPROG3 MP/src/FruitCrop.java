
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//the settings for the fruit crops

public class FruitCrop implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton mango, apple, cancel;
    private Container container;
    private JLabel pMango, pApple;
    private String[] cost = { "100", "200" };
    private String[] names = { "Mango", "Apple" };
    private int nos;
    private ImageIcon image = new ImageIcon("icon.png");
    private ImageIcon mangoIcon = new ImageIcon(new ImageIcon("mango.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    private ImageIcon appleIcon = new ImageIcon(new ImageIcon("apple.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

   /**
     * It creates a label for each fruit and sets the text to the cost of the fruit
     */
    private void label() {
        // setup for the label
        pMango = new JLabel();
        pMango.setText("$" + cost[0]);
        pMango.setBounds(76, 10, 150, 55);
        pMango.setFont(new Font("Lexend", Font.BOLD, 20));
        pMango.setForeground(Color.WHITE);
        frame.add(pMango);

        pApple = new JLabel();
        pApple.setText("$" + cost[1]);
        pApple.setFont(new Font("Lexend", Font.BOLD, 20));
        pApple.setForeground(Color.WHITE);
        pApple.setBounds(267, 10, 150, 55);
        frame.add(pApple);
    }

    // The code is a constructor for the class FruitCrop.
    public FruitCrop() {
        // the intial lauch for FruitCrop and for the players to see what available FruitCrop there are to plant

        if(MyFarm.p.getLevel() == 5) {
            cost[0]= "99";
            cost[1]= "199";
        }
        else if(MyFarm.p.getLevel() == 10){
            cost[0]= "98";
            cost[1]= "298";
        }
        else if(MyFarm.p.getLevel() == 15){
            cost[0]= "97";
            cost[1]= "297";
        }
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setTitle("Fruit Crop");
        frame.setIconImage(image.getImage());
        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0x263159));

        label();

        mango = new JButton("Mango");
        mango.setBounds(50, 50, 100, 90);
        mango.setIcon(mangoIcon);
        mango.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        mango.setForeground(new Color(0xFFFBEB));
        mango.setFont(new Font("Lexend", Font.BOLD, 15));
        mango.setHorizontalTextPosition(JLabel.CENTER);
        mango.setVerticalTextPosition(JLabel.TOP);
        mango.setBackground(new Color(0x476072));
        mango.setActionCommand("0");
        mango.addActionListener(this);
        mango.setFocusable(false);
        frame.add(mango);

        apple = new JButton("Apple");
        apple.setBounds(240, 50, 100, 90);
        apple.setIcon(appleIcon);
        apple.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        apple.setForeground(new Color(0xFFFBEB));
        apple.setFont(new Font("Lexend", Font.BOLD, 15));
        apple.setHorizontalTextPosition(JLabel.CENTER);
        apple.setVerticalTextPosition(JLabel.TOP);
        apple.setBackground(new Color(0x476072));
        apple.setActionCommand("1");
        apple.addActionListener(this);
        apple.setFocusable(false);
        frame.add(apple);

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

        CropList.frame.setEnabled(true);
        CropList.frame.dispose();

        MyFarm.frame.setEnabled(true);
        MyFarm.frame.toFront();
        MyFarm.rLabels();
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

    /**
     * It checks if the surrounding tiles of the chosen tile are empty or not. If it is empty, it will
     * plant the fruit tree. If not, it will show a message dialog
     */
    private void fruitTreeCheck(){
        // to check the surronding tiles of the Fruit tree and to either let Fruit tree be planted or not if there is a planted crop there already surrounding the chosen tile
        int i =1;
        boolean a = false;
        if(MyFarm.tileRow == 0 && MyFarm.tileColumn == 0){ 
            // top left corner 
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn+1) == null){
                if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn+1) == null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn) == null){
                        a= true;
                    }   
                }
            }

        }
        else if(MyFarm.tileRow == 0 && (MyFarm.tileColumn > 0 && MyFarm.tileColumn <9)){
            // top
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn+1 )== null){
                if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn+1) == null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn)== null){
                        if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn-1) == null){
                            if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn-1) == null){
                                a = true;
                            }
                        }
                    }   
                }
            }
        }
        else if(MyFarm.tileRow == 0 && MyFarm.tileColumn == 9){
            //top right corner
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn-1) == null){
                if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn) == null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn-1) == null){
                        a= true;
                    }   
                }
            }
        }
        else if(MyFarm.tileColumn == 0 && (MyFarm.tileRow >0 &&  MyFarm.tileRow < 4)){
            //left
            if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn)==null){
                if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn+1)==null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn+1)==null){
                        if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn+1)==null){
                            if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn)==null){
                                a = true;
                            }
                        }
                    }
                }
            }

        }
        else if(MyFarm.tileColumn == 9 && (MyFarm.tileRow > 0 &&  MyFarm.tileRow < 4)){
            //right
            if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn)==null){
                if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn-1)==null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn-1)==null){
                        if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn)==null){
                            if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn-1)==null){
                                a = true;
                            }
                        }
                    }
                }
            }

        }
        else if(MyFarm.tileRow == 4 && MyFarm.tileColumn == 0){
            //bottom left corner
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn+1) == null){
                if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn+1) == null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn) == null){
                        a= true;
                    }   
                }
            }
        }
        else if(MyFarm.tileRow == 4 && (MyFarm.tileColumn > 0 && MyFarm.tileColumn <9)){
            // bottom    
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn+1) == null){
                if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn-1) == null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn-1) == null){
                        if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn) == null){
                            if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn+1) == null){
                                a = true;
                            }
                        }
                    }   
                }
            }         
        }
        else if(MyFarm.tileRow == 4 && MyFarm.tileColumn == 9){
            //bottom right corner
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn-1) == null){
                if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn) == null){
                    if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn-1) == null){
                        a= true;
                    }   
                }
            }
        }
        else {
            // if its in the middle of the field and not at the boundary and corners
            if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn+1) == null){
                i++;
                if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn+1) ==null ){
                    i++;
                    if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn) == null){
                        i++;
                        if(MyFarm.myData.getTile(MyFarm.tileRow,MyFarm.tileColumn-1) == null){
                            i++;
                            if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn-1) ==null){
                                i++;
                                if(MyFarm.myData.getTile(MyFarm.tileRow-1,MyFarm.tileColumn+1) ==null){
                                    i++;
                                    if(MyFarm.myData.getTile(MyFarm.tileRow+1,MyFarm.tileColumn-1) == null){
                                        i++;
                                    }
                                }
                            }
                        }
                    }
        
                }
        
            }
         
        }

        if(i==8 || a == true){
            MyFarm.p.subtractCoin(Integer.parseInt(cost[nos]));
            MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setText(names[nos]);
            
            if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Mango")) {
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(mangoIcon);
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
                  MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
                  
              } else if(MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].getText().equals("Apple")) {
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setIcon(appleIcon);
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setForeground(new Color(0xFFFBEB));
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setFont(new Font("Lexend", Font.BOLD, 15));
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setHorizontalTextPosition(JLabel.CENTER);
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setVerticalTextPosition(JLabel.TOP);
              	MyFarm.tile[MyFarm.tileRow][MyFarm.tileColumn].setBackground(new Color(0x557153));
             	
              }
            quit(); //dapat bang may quit dito?
        }
        else{
            JOptionPane.showMessageDialog(frame, "There is already a planted Crop around the chosen tile");
            quit();
        }
    }

    // A method that is called when a button is pressed.
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // changing the button name into the chosen crop
        String src = e.getActionCommand();
        
        try {
            nos = Integer.parseInt(src);
            if(MyFarm.p.getCoin() < Integer.parseInt(cost[nos])){
                JOptionPane.showMessageDialog(frame, "You don't have enough coins");
            }
            else{  
                fruitTreeCheck();
            }
        } catch (Exception c) {
            // TODO: handle exception
            quit_B();
        }

    }

}
