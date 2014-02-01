/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cameracontroller.opencv;

/**
 *
 * @author Gaming
 */
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CaptureImage {
    private  FrameGrabber grabber=null;
    private Visor view;
    private ShowImage _image = null;
    CanvasFrame _frame;
    Boolean isRunning = true;

    public CaptureImage(Visor view) {
        this.view = view;
    }
    
    public  Image captureFrame() {
        // 0-default camera, 1 - next...so on
        // grabber = new OpenCVFrameGrabber(1);
        try {
            //grabber.start();
            IplImage img = grabber.grab();
            if (img != null) {
                cvSaveImage("capture.jpg", img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageIcon(("capture.jpg")).getImage();
    }
    public void serImageFframe(JLabel label)
    {
        label.setIcon((Icon) new ImageIcon("frame.png"));
    }
    public void showImage()
    {
        //grabber.
        
       // _frame = new CanvasFrame("najarse");  
        _image = new ShowImage();
        isRunning=true;
        System.out.println("something");
        grabber = new OpenCVFrameGrabber(1);
        grabber.setImageWidth(300);
        grabber.setImageHeight(400);
       // grabber.setFormat("mp4");
        Thread w=new Thread(_image);
        w.start();


    }

    public void stop()
    {
        try {
            captureFrame();
            grabber.stop();
            isRunning=false;
        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(CaptureImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /*
      * Nota para mi mismo : Cree la subclass aqui por flojera
      */

    void doSomething() {
        
    }
    
    
    
    class ShowImage implements  Runnable
    {

       
        //JLabel label = new JLabel();
        
        
        
        @Override
        public void run() {
            System.out.println("so?");
            try {
                IplImage img = null;
                BufferedImage bImage = null;
              grabber.start();

            while(isRunning)
            {       
                    try {
                        //img = new FaceDetection1().faceDetection(grabber.grab());
                        //img = grabber.grab();
                        bImage = new FaceDetection1().faceDetection(grabber.grab()).getBufferedImage();
                        ImageIcon icon = new ImageIcon(bImage);
                        view.getjLabel1().setIcon(icon);
                        // _frame.showImage(img);
                    } catch (Exception ex) {
                        Logger.getLogger(CaptureImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                   }

        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(CaptureImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
    }
}