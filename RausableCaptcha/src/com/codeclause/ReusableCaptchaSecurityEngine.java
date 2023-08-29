package com.codeclause;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.annotation.processing.Generated;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class ReusableCaptchaSecurityEngine extends JFrame
{
 private JLabel captchaLabel;
 private JTextField captchJTextField;
 private JButton genButton;
 private String generatedcaptcha;
 
 public ReusableCaptchaSecurityEngine()
 {
	 setTitle("Reusable Captcha Generator");
	 setSize(500,200);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setLocationRelativeTo(null);
	 
	 captchaLabel=new JLabel();
	 captchaLabel.setFont(new Font("Arial",Font.BOLD,20));
	 captchaLabel.setForeground(Color.blue);
	 captchJTextField =new JTextField(10);
	 genButton=new JButton("Genrate Captcha");
	 genButton.setForeground(Color.red);
	 genButton.setFont(new Font("Arial",Font.BOLD,20));
	 
	 genButton.addActionListener(new ActionListener() 
	 {
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
		    generatedcaptcha=gencaptcha();
		    captchaLabel.setText(generatedcaptcha);
			
		}
	});
	 JPanel panel=new JPanel();
	 panel.add(captchaLabel);
	 panel.add(captchJTextField);
	 panel.add(genButton);
	 
	 add(panel);
 }
    private String gencaptcha()
    {
    	String character="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    	StringBuilder captcha=new StringBuilder();
    	Random rd=new Random();
    	for(int i=0;i<8;i++)
    	{
    		char c=character.charAt(rd.nextInt(character.length()));
    		captcha.append(c);
    	}
    	return captcha.toString();
    }
    public static void main(String[]args)
    {
    	SwingUtilities.invokeLater(new Runnable() 
    	{
			
			@Override
			public void run() 
			{
				new ReusableCaptchaSecurityEngine().setVisible(true);
				
			}
		});
    }
 
}

