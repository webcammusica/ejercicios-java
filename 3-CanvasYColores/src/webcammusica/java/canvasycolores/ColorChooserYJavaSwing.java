package webcammusica.java.canvasycolores;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JToolTip;
import javax.swing.JTree;
import javax.swing.JViewport;

public class ColorChooserYJavaSwing extends JFrame{

	public  ColorChooserYJavaSwing(){
		
		JTree tr = new JTree();
		JList<String> li = new JList<String>();
		JCheckBoxMenuItem jcmi = new JCheckBoxMenuItem();
		JColorChooser cc = new JColorChooser();
	    JFileChooser fc = new JFileChooser();
	    JComboBox<String> jcb= new JComboBox<String>();
	    jcb.addItem("item1");
	    JMenu menu = new JMenu();
	    //JLayer<> la = new JLayer<>();
	    JMenuBar jMenuBar = new JMenuBar(); 
	    JEditorPane edp = new JEditorPane();
	    JOptionPane opp = new JOptionPane();
	    JRootPane rpa = new JRootPane();
	    JPasswordField pf = new JPasswordField();
	    JSlider slider = new JSlider();
	    JSpinner spi = new JSpinner();
	    JToolBar tBar = new JToolBar();
	    JViewport vPJViewport = new JViewport();
	    JToolTip tTip = new JToolTip();
	    
	    add(cc);
	    pack();
	    setVisible(true);
	
	}
	
	public static void main(String[] args) {
		ColorChooserYJavaSwing e = new ColorChooserYJavaSwing();
	}
}
