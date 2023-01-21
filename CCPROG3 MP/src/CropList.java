
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//settings for the crop list

public class CropList implements ActionListener {
    public static JFrame frame = new JFrame();
    private JButton rootList,flowerList,fruitList, cancel;
    private Container container;
    private ImageIcon image = new ImageIcon("icon.png");
    
    // The constructor of the class.
    public CropList(){
        // this is the setup when you are about to pick a crop
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,250);
        frame.setLayout(null);
        frame.setTitle("Crop List");
        frame.setIconImage(image.getImage());
        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0x263159));
        
        rootList = new JButton("Root Crops");
        ImageIcon root = new ImageIcon(new ImageIcon("rootcrop.gif").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        rootList.setIcon(root);
        rootList.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        rootList.setForeground(new Color(0xFFFBEB));
        rootList.setFont(new Font("Lexend", Font.BOLD, 15));
        rootList.setHorizontalTextPosition(JLabel.CENTER);
        rootList.setVerticalTextPosition(JLabel.TOP);
        rootList.setBackground(new Color(0x476072));
        rootList.setBounds(10,50,100,90);
        rootList.setActionCommand("RC");
        rootList.addActionListener(this);
        rootList.setFocusable(false);
        container.add(rootList);

        flowerList = new JButton("Flower Crops");
        ImageIcon flower = new ImageIcon(new ImageIcon("flowercrop.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        flowerList.setIcon(flower);
        flowerList.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        flowerList.setForeground(new Color(0xFFFBEB));
        flowerList.setFont(new Font("Lexend", Font.BOLD, 15));
        flowerList.setHorizontalTextPosition(JLabel.CENTER);
        flowerList.setVerticalTextPosition(JLabel.TOP);
        flowerList.setBackground(new Color(0x476072));
        flowerList.setBounds(138,50,110,90);
        flowerList.setActionCommand("FL");
        flowerList.addActionListener(this);
        flowerList.setFocusable(false);
        container.add(flowerList);

        fruitList = new JButton("Fruit Crops");
        ImageIcon fruit = new ImageIcon(new ImageIcon("fruitcrop.gif").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        fruitList.setIcon(fruit);
        fruitList.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        fruitList.setForeground(new Color(0xFFFBEB));
        fruitList.setFont(new Font("Lexend", Font.BOLD, 15));
        fruitList.setHorizontalTextPosition(JLabel.CENTER);
        fruitList.setVerticalTextPosition(JLabel.TOP);
        fruitList.setBackground(new Color(0x476072));
        fruitList.setBounds(275,50,100,90);
        fruitList.setActionCommand("fruit");
        fruitList.addActionListener(this);
        fruitList.setFocusable(false);
        container.add(fruitList);
        
        cancel = new JButton("Cancel");
        cancel.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        cancel.setForeground(new Color(0xFFFBEB));
        cancel.setFont(new Font("Lexend", Font.BOLD, 15));
        cancel.setBackground(new Color(0x476072));
        cancel.setBounds(280,150,90,50);
        cancel.setActionCommand("c");
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        container.add(cancel);

        // To make the window appear centered everytime you launched it 
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
        
    }

    // Checking which cropType you would like to plant.
    @Override
    public void actionPerformed(ActionEvent e) {
        //checks which cropType you would like to plant
        // TODO Auto-generated method stub
        String src = e.getActionCommand(); 
        Window w =  javax.swing.FocusManager.getCurrentManager().getActiveWindow();
        if(w.isActive() == true){
            frame.setEnabled(false);
        }

        if(src.equals("RC")){
            RootCrop rc = new RootCrop();
        }       
        if(src.equals("FL")){
            FlowerCrop fc = new FlowerCrop();
        }       
        if(src.equals("fruit")){
            FruitCrop fl = new FruitCrop();
        }       

        if(src.equals("c")){
            frame.setEnabled(true);
            frame.setVisible(false);
            
          
            MyFarm.frame.setEnabled(true);
            MyFarm.frame.toFront();
        }
    }
}
