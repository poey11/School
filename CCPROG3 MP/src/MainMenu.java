import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**@author Malcolm Payao
 * @author Kimberly Tan
 */
 //generates the main menu

public class MainMenu implements ActionListener {
    
    private JFrame frame = new JFrame();
    private JButton Sbutton,Qbutton;
    private Container container;
    private ImageIcon image = new ImageIcon("icon.png");
    private ImageIcon pIcon = new ImageIcon(new ImageIcon("farm.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    private ImageIcon rock = new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

   

    public MainMenu(){
        //The setting for the MainMenu Window 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setIconImage(image.getImage());
        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(0x263159));
    
    
        
        //Title of the window
        frame.setTitle("Main Menu");
        
        //Label of the starting window
        JLabel title = new JLabel(); 
        title.setIcon(pIcon);
        title.setText("My Farm Simulator");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.TOP);
        title.setFont(new Font("Lexend", Font.BOLD, 20));
        title.setForeground(new Color(0xFFFBEB));
        title.setBounds(150,60,200,200);
        container.add(title);


        //Start Button of main menu
        Sbutton = new JButton("Start");
        Sbutton.setBounds(150,250,200,40);
        Sbutton.setBackground(new Color(0xB8E3FF));
        Sbutton.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        Sbutton.setForeground(Color.black);
        Sbutton.setFont(new Font("Lexend", Font.BOLD, 20));
        Sbutton.setActionCommand("Start");
        Sbutton.addActionListener(this);
        Sbutton.setFocusable(false);
        Sbutton.setEnabled(true);
        container.add(Sbutton);

        //Quit button of main menu
        Qbutton = new JButton("Quit");
        Qbutton.setBounds(150,300,200,40);
        Qbutton.setBackground(new Color(0xB8E3FF));
        Qbutton.setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
        Qbutton.setForeground(Color.black);
        Qbutton.setFont(new Font("Lexend", Font.BOLD, 20));
        Qbutton.setActionCommand("Quit");
        Qbutton.addActionListener(this);
        Qbutton.setFocusable(false);
        container.add(Qbutton);

        // To make the window appear centered everytime you launched it 
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        // make the window appear in the screen
        frame.setVisible(true);
    }

    /**
     * The start of the game
     */
    public static void main(String[] args) {
        
        new MainMenu();
    }


    /**
     * It reads a text file and then sets the text of a JLabel to "Rocks" if the last character of the
     * line is an "r"
     */
    private void read(){
        BufferedReader reader;
        int lineColumn = 0;
        int lineRow =0;
        try {
             reader = new BufferedReader(new FileReader("src/rocks.txt"));
             String line = reader.readLine();
             while(line != null){
                if(line.charAt(line.length()-1) == 'r'){
                    MyFarm.tile[lineRow][lineColumn].setText("Rocks");
                    MyFarm.tile[lineRow][lineColumn].setIcon(rock);
                    MyFarm.tile[lineRow][lineColumn].setHorizontalTextPosition(JLabel.CENTER);
                    MyFarm.tile[lineRow][lineColumn].setVerticalTextPosition(JLabel.TOP);
                    MyFarm.tile[lineRow][lineColumn].setBackground(new Color(0x7F8487));
                    MyFarm.tile[lineRow][lineColumn].setBorder(BorderFactory.createEtchedBorder(1, new Color(0x251749), Color.WHITE));
                    MyFarm.tile[lineRow][lineColumn].setFont(new Font("Lexend", Font.BOLD, 15));
                    MyFarm.tile[lineRow][lineColumn].setForeground(Color.WHITE);
                }
                lineColumn++;
                if(lineColumn == 10){
                    lineRow++;
                    lineColumn =0;
                }
                line = reader.readLine();
            }

          
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

     // The action listener of the buttons. It is the code that would be executed when the button is
    // clicked.
    @Override
    public void actionPerformed(ActionEvent e) {
        // What each button would do
        
        String commandString = e.getActionCommand();
        
        if(commandString.equals("Start")){
            // Open the MyFarm window and starts the game
            MyFarm farm = new MyFarm();
            read();
            frame.setVisible(false);
          
        }
        if(commandString.equals("Quit")){
            //exit the window and terminate the whole program
            System.exit(0);
        }      
    }

    
   
    
}
