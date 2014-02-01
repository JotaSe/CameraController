/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Camcapturer;
/**
*
* @author mohamed khalaf
*/import javax.media.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import java.io.File;
/**
 *
 * @author Gaming
 */


public class Test extends JFrame {
boolean saved=false;
File file=null;
public Container c=getContentPane();
public Player _player=null;
public Image img=null;
public Buffer buffer=null;
public BufferToImage btoi=null;
public ImagePanel imagepanel=null;
class ImagePanel extends JFrame{



public Image myimg;
public ImagePanel() {

setLayout(new FlowLayout());
setSize(300,300);
setVisible(true);
}
public void setmage(Image img){
this.myimg=img;
repaint();

}
public void paint(Graphics g){
if(myimg!=null){
g.drawImage(myimg,0,0, this);
}
}
}


Test() {

addWindowListener( new WindowAdapter() {
public void windowClosing( WindowEvent e ) {
_player.stop();
_player.deallocate();
_player.close();

System.exit( 0 );
}
});


JPanel panel = (JPanel)getContentPane();

panel.setLayout( new FlowLayout() );

JButton b=new JButton("Start");
b.setMnemonic('S');
b.setCursor(new Cursor(Cursor.HAND_CURSOR));
panel.add(b);
JButton s=new JButton("Stop");
s.setMnemonic('S');
s.setCursor(new Cursor(Cursor.WAIT_CURSOR));
panel.add(s);
JButton c=new JButton("Take photo");
c.setMnemonic('T');
c.setCursor(new Cursor(Cursor.HAND_CURSOR));
panel.add(c);

b.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
_player.start();



}
});
s.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
_player.stop();
}
});

c.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
String mlcoation="vfw:Microsoft WDM Image Capture (Win32):0";


FrameGrabbingControl fgc = (FrameGrabbingControl)_player.getControl("javax.media.control.FrameGrabbingControl");

buffer=fgc.grabFrame();
btoi=new BufferToImage((VideoFormat)buffer.getFormat());
img=btoi.createImage(buffer);
ImagePanel imagepanel=new ImagePanel();






}
});


String mediaFile = "vfw:Microsoft WDM Image Capture (Win32):0";
try {
MediaLocator mlr = new MediaLocator( mediaFile );

_player =Manager.createRealizedPlayer(mlr);

if (_player.getVisualComponent() != null){
setSize(200,200);
panel.add("South", _player.getVisualComponent());
}
}
catch (Exception e) {
System.err.println( "Got exception " + e );
}

}

public static void main(String[] args) {
Test jmfTest = new Test();
jmfTest.setSize(800,800);
jmfTest.show();
}
    }



