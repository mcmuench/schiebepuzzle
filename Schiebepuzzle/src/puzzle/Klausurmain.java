package puzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Klausurmain extends JFrame
{
	JPanel inhalt;	
	JPanel oben;
	JLabel zuege;
	int anzahlZuege;
	Mitte mitte;
	
	public Klausurmain()
	{
		super("Schiebepuzzle");
		

	
		this.anzahlZuege = 0;
		
		inhalt = init();
		this.getContentPane().add(inhalt);
		
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(50,50);
		this.setVisible(true);
		
	}
	
	private JPanel init()
	{
		JPanel a = new JPanel();
		a.setBackground(Color.LIGHT_GRAY);
		a.setLayout(new BorderLayout());
		
		// Komponenten erstellen
		oben = new JPanel();
		zuege = new JLabel("Anzahl Zuege: " + this.anzahlZuege);
		zuege.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
		
		JPanel unten = new JPanel();
		JButton neustart = new JButton("Neustart");
		neustart.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 15));
		neustart.addActionListener(new ActionHandler());
		
		mitte = new Mitte();
		mitte.addMouseListener(new MouseHandler());
		
		// Komponenten hinzufügen
		oben.add(zuege);
		unten.add(neustart);
		
		a.add(oben, BorderLayout.NORTH);
		a.add(mitte, BorderLayout.CENTER);
		a.add(unten, BorderLayout.SOUTH);
		
		return a;
	}
	

	void zugZaehler()	
	{
		this.anzahlZuege++;
		zuege.setText("Anzahl Zuege: " + this.anzahlZuege);
	}
	
	
	void neustart()
	{
		this.anzahlZuege = 0;
		zuege.setText("Anzahl Zuege: " + this.anzahlZuege);
		this.getContentPane().removeAll();
		this.getContentPane().add(init());
		this.revalidate();
		this.repaint();
	}

	
	class ActionHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e ) 
		{
			//JButton source = (JButton)e.getSource();
			Klausurmain.this.neustart();
		}
	}
	
	public void tausche(int y, int x)
	{
		if(y==0 && x==0)
		{
			if(mitte.panels[0][1].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][1];
				mitte.panels[0][1] = mitte.panels[0][0];
				mitte.panels[0][0] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[1][0].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][0];
				mitte.panels[1][0] = mitte.panels[0][0];
				mitte.panels[0][0] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
		}
		
		if(y==0 && x==1)
		{
			if(mitte.panels[0][0].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][0];
				mitte.panels[0][0] = mitte.panels[0][1];
				mitte.panels[0][1] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[1][1].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][1];
				mitte.panels[1][1] = mitte.panels[0][1];
				mitte.panels[0][1] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[0][2].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][2];
				mitte.panels[0][2] = mitte.panels[0][1];
				mitte.panels[0][1] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
		}
		
		if(y==0 && x==2)
		{
			if(mitte.panels[0][1].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][1];
				mitte.panels[0][1] = mitte.panels[0][2];
				mitte.panels[0][2] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[1][2].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][2];
				mitte.panels[1][2] = mitte.panels[0][2];
				mitte.panels[0][2] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
		}
		
		if(y==1 && x==0)
		{
			if(mitte.panels[0][0].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][0];
				mitte.panels[0][0] = mitte.panels[1][0];
				mitte.panels[1][0] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[1][1].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][1];
				mitte.panels[1][1] = mitte.panels[1][0];
				mitte.panels[1][0] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
		}
		
		if(y==1 && x==1)
		{
			if(mitte.panels[1][0].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][0];
				mitte.panels[1][0] = mitte.panels[1][1];
				mitte.panels[1][1] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[0][1].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][1];
				mitte.panels[0][1] = mitte.panels[1][1];
				mitte.panels[1][1] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[1][2].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][2];
				mitte.panels[1][2] = mitte.panels[1][1];
				mitte.panels[1][1] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
		}
		
		if(y==1 && x==2)
		{
			if(mitte.panels[1][1].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[1][1];
				mitte.panels[1][1] = mitte.panels[1][2];
				mitte.panels[1][2] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
			if(mitte.panels[0][2].getBackground().equals(Color.LIGHT_GRAY))
			{
				JPanel temp = mitte.panels[0][2];
				mitte.panels[0][2] = mitte.panels[1][2];
				mitte.panels[1][2] = temp;
				mitte.erneuern();
				this.zugZaehler();
			}
		}
		
		if(mitte.panels[0][0].getBackground().equals(Color.RED) && 
		   mitte.panels[1][0].getBackground().equals(Color.RED) )
		{ 	
			if(((JLabel)(mitte.panels[0][0].getComponent(0))).getText().equals("1"))
			{
				this.zuege.setText("Ende! Anzahl Zuege: " + this.anzahlZuege);
				this.zuege.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 20));
			}
			
		}
	}
	
	class MouseHandler implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent m) 
		{
			JPanel source = (JPanel)m.getSource();
			int hoehe = source.getHeight();
			int breite = source.getWidth();
			int unterbreite = breite/3;
			int unterhoehe = hoehe/2;
			
			int klickX = m.getX();
			int klickY = m.getY();
			
			int seitIndex = klickX/unterbreite;
			int hoeheIndex = klickY/unterhoehe;
			
			//System.out.println("seitIndex: " + seitIndex + "   hoeheIndex: " + hoeheIndex);
			
			// panel [hoeheIndex][seitIndex]
			Klausurmain.this.tausche(hoeheIndex, seitIndex);
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) 
	{
		new Klausurmain();
	}

}
