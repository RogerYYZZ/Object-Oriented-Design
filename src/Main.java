import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main extends JFrame 
implements ActionListener, KeyListener{
  Map canvas = new Map(this);
  MapZoom  zoomCanvas = new MapZoom(this);
  directionPanel  directionControl = new directionPanel(canvas,this);
  StatePanel   state = new StatePanel(this);
// * initiate the counter
  private int currrentFrame;
    private int frame = 0;
    private int frame_2 = 0;
    private int frame_3 = 0;
    private int zoomFrame = 0;
    public boolean zoom;
  //  public  directionControl;
    public int getZoomFrame() {
		return zoomFrame;
	}
	public void setZoom(boolean zoom) {
		this.zoom = zoom;
	}

	public int getFrame_2() {
		return frame_2;
	}
	public void setFrame_2(int frame_2) {
		this.frame_2 = frame_2;
	}
	public int getFrame_3() {
		return frame_3;
	}
	public void setFrame_3(int frame_3) {
		this.frame_3 = frame_3;
	}

	Timer timer = new Timer (100, new CustomActionListener()); // 100 milliseconds
//	timer.start();
  public static void main (String [] args){
	  
	  new Main();
  }
  public Main () {
	  //Window setup
	  setLocation(100,100);
	  setSize (650,650);
	  setDefaultCloseOperation (EXIT_ON_CLOSE);
	
	  Container content = getContentPane();
	  content.setLayout (new BorderLayout());
	  addKeyListener (this);
	   
        //put the panel to choose color from R, G, B
//	    JPanel scrollBarPanel = new JPanel();
//		scrollBarPanel.setLayout(new GridLayout(3,2));
//		JLabel label1 = new JLabel ("Red:");
//		scrollBarPanel.add(label1);
//		scrollBarPanel.add(new ColorScrollbar("Red", canvas));
//		JLabel label2 = new JLabel ("Green:");
//		scrollBarPanel.add(label2);
//		scrollBarPanel.add(new ColorScrollbar("Green", canvas));
//		JLabel label3 = new JLabel ("Blue:");
//		scrollBarPanel.add(label3);
//		scrollBarPanel.add(new ColorScrollbar("Blue", canvas));
//	  
//		String[] messageStrings = {"All", "Plane1", "Plane2", "Plane3"};
//		final JComboBox cmbMessageList = new JComboBox(messageStrings);
//		//JComboBox cmbMessageList = new JComboBox(messageStrings);
//		//cmbMessageList.setSelectedIndex(1);
//		cmbMessageList.addActionListener(new ActionListener(){
//			
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if (e.getSource() == cmbMessageList){
//					JComboBox cb = (JComboBox)e.getSource();
//					String msg = (String)cb.getSelectedItem();
//					canvas.isAll = false;
//
//					if (msg == "Plane1" ) canvas.setPlane(canvas.getPlanes().get(0));
//					else if (msg == "Plane2") canvas.setPlane(canvas.getPlanes().get(1)); 
//					else if (msg == "Plane3") canvas.setPlane(canvas.getPlanes().get(2)); 
//					else {
//						canvas.isAll = true; canvas.repaint();}
//					System.out.println ("Scrollbar: " + msg);
//					}	
//				}
//		});
		 canvas.getOne().setCurrentX1(canvas.getOne().getInit_x());
		 canvas.getOne().setCurrentY1(canvas.getOne().getInit_y());
		 canvas.getTwo().setCurrentX1(canvas.getTwo().getInit_x());
		 canvas.getTwo().setCurrentY1(canvas.getTwo().getInit_y());
		 canvas.getThree().setCurrentX1(canvas.getThree().getInit_x());
		 canvas.getThree().setCurrentY1(canvas.getThree().getInit_y());
	     canvas.getOne().setX1(canvas.getOne().getCurrentX1());
	     canvas.getOne().setY1(canvas.getOne().getCurrentY1());
	     canvas.getTwo().setX1(canvas.getTwo().getCurrentX1());
	     canvas.getTwo().setY1(canvas.getTwo().getCurrentY1());
	     canvas.getThree().setX1(canvas.getThree().getCurrentX1());
	     canvas.getThree().setY1(canvas.getThree().getCurrentY1());
//		String[] messageStrings_2 = {"50 50", "150 150", "200 200"};
//		final JComboBox cmbMessageList_2 = new JComboBox(messageStrings_2);
//		cmbMessageList_2.addActionListener(new ActionListener(){
//			
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if (e.getSource() == cmbMessageList_2){
//					JComboBox cb_2 = (JComboBox)e.getSource();
//					String msg_2 = (String)cb_2.getSelectedItem();
//					int x = Integer.parseInt(msg_2.split("\\s+")[0]);
//					int y = Integer.parseInt(msg_2.split("\\s+")[1]);
//					canvas.getPlane().setInit_x(x);
//					canvas.getPlane().setInit_y(y);
//					canvas.repaint();
//					}	
//				}
//		});
//		
//		JPanel controls = new JPanel();
//		controls.setLayout(new FlowLayout());
//		controls.add(cmbMessageList);
//	//	controls.add(cmbMessageList_2);
//		controls.add(scrollBarPanel);
		
		
		JPanel button_control = new JPanel();
		button_control.setLayout(new FlowLayout());

		//add three buttons start, stop, reset to controll the movement of the plane

		
		JButton button_1 = new JButton ("Start");
		button_control.add(button_1);
	//	button_1.addActionListener(this);
		button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			timer.start();
		}});
		
		
		JButton button_2 = new JButton ("Stop");
		button_control.add(button_2);
	//	button_2.addActionListener(this);
		button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			timer.stop();
			
		}});
		
		JButton button_3 = new JButton ("Reset");
		button_control.add(button_3);
	//	button_3.addActionListener(this);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.p1Disappear = false;
				canvas.p2Disappear = false;
				canvas.p3Disappear = false;
				frame=0;
				frame_2 = 0;
				frame_3 = 0;
				 canvas.getOne().setCurrentX1(canvas.getOne().getInit_x());
				 canvas.getOne().setCurrentY1(canvas.getOne().getInit_y());
				 canvas.getTwo().setCurrentX1(canvas.getTwo().getInit_x());
				 canvas.getTwo().setCurrentY1(canvas.getTwo().getInit_y());
				 canvas.getThree().setCurrentX1(canvas.getThree().getInit_x());
				 canvas.getThree().setCurrentY1(canvas.getThree().getInit_y());
			     canvas.getOne().setX1(canvas.getOne().getCurrentX1());
			     canvas.getOne().setY1(canvas.getOne().getCurrentY1());
			     canvas.getTwo().setX1(canvas.getTwo().getCurrentX1());
			     canvas.getTwo().setY1(canvas.getTwo().getCurrentY1());
			     canvas.getThree().setX1(canvas.getThree().getCurrentX1());
			     canvas.getThree().setY1(canvas.getThree().getCurrentY1());
				zoomFrame = 0;
				timer.stop();
				canvas.repaint ();	
				//if reset is pressed when zoom, give it's original position
				if(zoom){
					zoomCanvas.setInit_Plane1(new Point(canvas.getOne().getInit_x(), canvas.getOne().getInit_y()));
                    zoomCanvas.setInit_Plane2(new Point(canvas.getTwo().getInit_x(), canvas.getTwo().getInit_y()));
                    zoomCanvas.setInit_Plane3(new Point(canvas.getThree().getInit_x(), canvas.getThree().getInit_y()));
					zoomCanvas.repaint();
					
				}

			}});
		
//		JButton button_4 = new JButton ("Zoom In");
//		button_control.add(button_4);
//	//	button_4.addActionListener(this);
//		button_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				canvas.setVisible(false);
//			    if(!zoom){
//                zoom = true;
//                zoomCanvas.setInit_Plane1(new Point(canvas.getOne().getX1(), canvas.getOne().getY1()));
//                zoomCanvas.setInit_Plane2(new Point(canvas.getTwo().x1, canvas.getTwo().y1));
//                zoomCanvas.setInit_Plane3(new Point(canvas.getThree().x1, canvas.getThree().y1));
//                zoomCanvas.repaint();
//			    }
//
//			}});
//		
//		JButton button_5 = new JButton ("Zoom Out");
//		button_control.add(button_5);
//	//	button_5.addActionListener(this);
//		button_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				canvas.setVisible(true);
//			}});
		 
		
		button_control.add(directionControl);
		JPanel control_together = new JPanel(); 
	//	control_together.setLayout(new GridLayout(2,1));
		control_together.setLayout(new BoxLayout(control_together,BoxLayout.Y_AXIS));
		control_together.add(state);
		control_together.add(button_control);
	//	control_together.add(directionControl);
	//	control_together.add(controls);
		
		canvas.setBorder (new LineBorder(Color.RED,2));
		JPanel canvasPanel = new JPanel();		
		canvasPanel.setLayout(new FlowLayout());
		canvasPanel.setLayout(new GridLayout(1,1));
		
		LayoutManager overlay = new OverlayLayout(canvasPanel);
		canvasPanel.setLayout(overlay);
		
		//canvas.setVisible(false);
		canvasPanel.add(canvas);
	//	canvasPanel.add(zoomCanvas);
		
	//	content.add(canvas, BorderLayout.CENTER);
		content.add(canvasPanel, BorderLayout.CENTER);
		content.add(control_together, BorderLayout.SOUTH);
		canvas.repaint();
	//	content.add(controls, BorderLayout.SOUTH);
	//	content.add(button_control, BorderLayout.SOUTH);
	//	content.add(choosePlane, BorderLayout.NORTH);
		
	
	  
		setVisible (true);
		
	   //start a timer
		// Start timer
//		Timer timer = new Timer (100, this); // 100 milliseconds
//		timer.start();
		
		
  }
  
 public int getFrame () { return frame; }
//@Override
class CustomActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
    
	if(directionControl.getCurrentButton() == "up"){
		canvas.getOne().setX1(canvas.getOne().getCurrentX1());
		canvas.getOne().setY1(canvas.getOne().getCurrentY1()-5*frame);
	}
	else if(directionControl.getCurrentButton() == "down"){
		canvas.getOne().setX1(canvas.getOne().getCurrentX1());
		canvas.getOne().setY1(canvas.getOne().getCurrentY1()+5*frame);
	}
	else if(directionControl.getCurrentButton() == "left"){
		canvas.getOne().setX1(canvas.getOne().getCurrentX1()-5*frame);
		canvas.getOne().setY1(canvas.getOne().getCurrentY1());
	}
	else{
		canvas.getOne().setX1(canvas.getOne().getCurrentX1()+5*frame);
		canvas.getOne().setY1(canvas.getOne().getCurrentY1());
	}
	
	if(canvas.getTwo().isChange() == false){
	    canvas.getTwo().setX1(canvas.getTwo().getCurrentX1()+5*frame_2);
	    canvas.getTwo().setY1(canvas.getTwo().getCurrentY1()-5*frame_2);
	    }
	else if(canvas.getTwo().isChange() == true){
	    canvas.getTwo().setX1(canvas.getTwo().getCurrentX1()-5*frame_2);
	    canvas.getTwo().setY1(canvas.getTwo().getCurrentY1()+5*frame_2);
	}
	
	if(canvas.getThree().isChange() == false){
		canvas.getThree().setX1(canvas.getThree().getCurrentX1());
	    canvas.getThree().setY1(canvas.getThree().getCurrentY1()+5*frame_3);
	}
	else if(canvas.getThree().isChange() == true){
	    canvas.getThree().setX1(canvas.getThree().getCurrentX1());
	    canvas.getThree().setY1(canvas.getThree().getCurrentY1()-5*frame_3);
	}
	frame++;
	frame_2++;
	frame_3++;
	canvas.repaint ();	
	//System.out.println(frame);
	if(zoom){
		zoomFrame++;
		zoomCanvas.repaint();
		
	}
}}

@Override
public void keyPressed(KeyEvent e) {
	//if (e.getKeyCode()==KeyEvent.VK_ESCAPE) System.exit (0);
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
public void setFrame(int frame) {
	this.frame = frame;
}
}