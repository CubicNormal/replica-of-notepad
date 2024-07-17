package javahandlingmenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MainFrame extends JFrame
{
    private JMenuBar menuBar;
    private JMenu   menuFile,menuEdit,menuFormat,menuWindow;
    private JMenuItem fileNew,fileOpen,fileExit;
    private JMenuItem formatFont,formatColor;
    private JColorChooser colChoose;
    private JDialog colChooseDlg;
    private JTextArea txtEditor;
    private JScrollPane spnEditor;
    public MainFrame()
    {
        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        
        menuFile=new JMenu("File");
        menuFile.setFont(new Font("Verdana",1,12));
        menuBar.add(menuFile);
        
        fileNew=new JMenuItem("New");
        fileNew.setFont(new Font("Verdana",1,12));
        menuFile.add(fileNew);
        
        menuFile.addSeparator();
        
        fileOpen=new JMenuItem("Open");
        fileOpen.setFont(new Font("Verdana",1,12));
        menuFile.add(fileOpen);
        
        menuFile.addSeparator();
        
        fileExit=new JMenuItem("Exit");
        fileExit.setFont(new Font("Verdana",1,12));
        menuFile.add(fileExit);
        
        menuEdit=new JMenu("Edit");
        menuEdit.setFont(new Font("Verdana",1,12));
        menuBar.add(menuEdit);
        
        menuFormat=new JMenu("Format");
        menuFormat.setFont(new Font("Verdana",1,12));
        menuBar.add(menuFormat);
        
        formatFont=new JMenuItem("Font");
        fileNew.setFont(new Font("Verdana",1,12));
        formatFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            FontFrame frame = new FontFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(500,400);
            frame.setResizable(false);
            frame.setTitle("Font");
            frame.setLocationRelativeTo(null);
                
            }
            
        });
        menuFormat.add(formatFont);
        
        formatColor=new JMenuItem("Color");
        
        formatColor.setFont(new Font("Verdana",1,12));
        formatColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               colChoose= new JColorChooser();
               colChooseDlg = JColorChooser.createDialog(null,"Color Palette",true ,colChoose,act,null);
               colChooseDlg.setVisible(true);
            }
        });
        menuFormat.add(formatColor);
        
        
       txtEditor=new JTextArea("Notepad Editor");
       txtEditor.setFont(new Font("Verdana",1,12));
       spnEditor=new JScrollPane(txtEditor);
       spnEditor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       spnEditor.setBounds(10,10,680,480);
       add(spnEditor);
        
        
        
        
    }
    //End of Constructor 
     ActionListener act=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEditor.setForeground(colChoose.getColor());
            }
        };
}
public class MainClass
{
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(700,500);
        frame.setResizable(true);
        frame.setTitle("Notepad");
        frame.setLocationRelativeTo(null);
    }
}

