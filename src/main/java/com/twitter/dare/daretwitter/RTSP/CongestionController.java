package com.twitter.dare.daretwitter.RTSP;

import java.awt.event.*;
import javax.swing.Timer;

//------------------------
//Controls RTP sending rate based on traffic
//------------------------
class CongestionController implements ActionListener {
	
    //Video variables:
    //----------------
    static int FRAME_PERIOD = 100; //Frame period of the video to stream, in ms

    Timer timer;    //timer used to send the images at the video frame rate
    byte[] buf;     //buffer used to store the images to send to the client 
    int sendDelay;  //the delay to send images over the wire. Ideally should be
                    //equal to the frame rate of the video file, but may be 
                    //adjusted when congestion is detected.

    //RTCP variables
    //----------------
    int congestionLevel;

    private Timer ccTimer;
    int interval;   //interval to check traffic stats
    int prevLevel;  //previously sampled congestion level

    public CongestionController(int interval) {
        this.interval = interval;
        ccTimer = new Timer(interval, this);
        ccTimer.start();
    }

    public void actionPerformed(ActionEvent e) {

        //adjust the send rate
        if (prevLevel != congestionLevel) {
            sendDelay = FRAME_PERIOD + congestionLevel * (int)(FRAME_PERIOD * 0.1);
            timer.setDelay(sendDelay);
            prevLevel = congestionLevel;
            System.out.println("Send delay changed to: " + sendDelay);
        }
    }
}