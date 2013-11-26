
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Animator extends JFrame{
	JButton start, stop;
	JPanel ballPanel;
	Ball ball; 
	Timer moveBallTimer;
	boolean animate;

	public Animator(){
		super("Animation");
		start = new JButton("Start");
		stop = new JButton("Stop");
		Box buttons = new Box(BoxLayout.X_AXIS);
		buttons.add(start);
		buttons.add(stop);
		getContentPane().add(buttons, BorderLayout.NORTH); 


		ballPanel = new JPanel(){   
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				ball.paint(g);
			} 
		};
		ball = new Ball(ballPanel);
		getContentPane().add(ballPanel); 


		moveBallTimer = new Timer(100, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ball.move(); 
				repaint(); 
			} 

		});


		start.addActionListener(new ActionListener(){ 

			public void actionPerformed(ActionEvent e){ 
				if(moveBallTimer.isRunning() == false){
					moveBallTimer.start();
				}
			}
		});

		stop.addActionListener(new ActionListener(){ 
			@Override 
			public void actionPerformed(ActionEvent e){
				if(moveBallTimer.isRunning()){  
					moveBallTimer.stop(); 
				}
			}

		});
	} 

	public static void main(String[] args){
		JFrame f = new Animator();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(300, 300, 300, 200);
		f.setVisible(true);
	}

}
