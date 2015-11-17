

import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollBar;

/*
 * Scrollbar that controls the color of the plane
 */
public class ColorScrollbar extends JScrollBar implements AdjustmentListener{

	private String whichColor;
	private Map canvas;
	
	public ColorScrollbar (String whichColor, Map canvas) {
		super(JScrollBar.HORIZONTAL, 100, 10, 0, 255);

		this.whichColor = whichColor;
		this.canvas = canvas;
		
		addAdjustmentListener (this);
	}

	public Dimension getPreferredSize() {
		return new Dimension(125,20);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent arg0) {
		canvas.setColor (whichColor, getValue());	
	}

	
}
