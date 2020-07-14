package puzzle;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Mitte extends JPanel
{
	JPanel[][] panels;
	
	JPanel eins;
	JPanel zwei;
	JPanel grau;
	JPanel gelb1;
	JPanel gelb2;
	JPanel gelb3;
	
	public Mitte()
	{
		JLabel a = new JLabel("1");
		a.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		a.setForeground(Color.WHITE);
		a.setHorizontalAlignment(JLabel.CENTER); 
		JLabel b = new JLabel("2");
		b.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		b.setForeground(Color.WHITE);
		b.setHorizontalAlignment(JLabel.CENTER); 
		
		JPanel eins = new JPanel();
		eins.setSize(50,50);
		eins.setBackground(Color.RED);
		eins.setLayout(new GridLayout());
		eins.add(a);
		
		JPanel zwei = new JPanel();
		zwei.setSize(50,50);
		zwei.setBackground(Color.RED);
		zwei.setLayout(new GridLayout());
		zwei.add(b);
		
		JPanel grau = new JPanel();
		grau.setSize(50,50);
		grau.setBackground(Color.LIGHT_GRAY);
		
		JPanel gelb1 = new JPanel();
		gelb1.setSize(50,50);
		gelb1.setBackground(Color.YELLOW);
		JPanel gelb2 = new JPanel();
		gelb2.setSize(50,50);
		gelb2.setBackground(Color.YELLOW);
		JPanel gelb3 = new JPanel();
		gelb3.setSize(50,50);
		gelb3.setBackground(Color.YELLOW);
		
		panels = new JPanel[2][3];
		panels[0][0] = zwei;
		panels[0][1] = grau;
		panels[0][2] = gelb1;
		panels[1][0] = eins;
		panels[1][1] = gelb2;
		panels[1][2] = gelb3;
		
		this.setLayout(new GridLayout(2, 3, 2, 2));
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<3; j++)
			{
				this.add(panels[i][j]);
			}
		}
		
	}
	
	public void erneuern()
	{
		this.removeAll();
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<3; j++)
			{
				this.add(panels[i][j]);
			}
		}
		this.revalidate();
		this.repaint();
		
	}
	
}
