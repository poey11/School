import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

//genarates the game over window

public class GameOver implements ActionListener {
    
    private JFrame frame = new JFrame();
    private JButton Qbutton;
    private Container container;
    private JLabel title;
    private ImageIcon image = new ImageIcon("icon.png");
    ImageIcon gameover = new ImageIcon(new ImageIcon("gameover.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
   

    // The constructor of the class GameOver. It is used to create the window and the components inside
    // the window.
    public GameOver(){
        //The setting for the GameOver Window 
		 	
		 	frame.setSize(500,500);
	        frame.setLayout(null);
	        frame.setIconImage(image.getImage());
	        container = frame.getContentPane();
	        container.setLayout(null);
	        container.setBackground(new Color(0x263159));
	    
	        
	        //Title of the window
	        frame.setTitle("My Farm Simulator");
	        
	        
	        //Label of the  window
	        title = new JLabel(); 
	        title.setText("Game Over");
	        title.setIcon(gameover);
	        title.setHorizontalTextPosition(JLabel.CENTER);
	        title.setVerticalTextPosition(JLabel.TOP);
	        title.setFont(new Font("Lexend", Font.BOLD, 40));
	        title.setForeground(new Color(0xFFFBEB));
	        title.setBounds(150,0,300,300);
	        container.add(title);


	        //Quit button 
	        Qbutton = new JButton("Quit");
	        Qbutton.setBounds(150,270,200,40);
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

  

    @Override
    // The action listener for the button. It is used to make the button do something when it is
    // clicked.
    public void actionPerformed(ActionEvent e) {
        // What each button would do
        
        String commandString = e.getActionCommand();
        if(commandString.equals("Quit")){
            //exit the window and terminate the whole program
            System.exit(0);
        }      
    }

    
    
    
}
