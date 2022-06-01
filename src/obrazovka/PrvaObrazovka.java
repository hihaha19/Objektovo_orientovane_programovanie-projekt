package obrazovka;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hlavna.Hlavna;
import zakaznik.*;


/**
 * Prva obrazovka v GUI, ktora obsahuje jedno policko, ktore akceptuje vstupy zivnost, Zivnost, Sro, sro, Akciova spolocnost.
 * Po zadani spravneho vstupu sa vytvori nove okno, do ktoreho sa zadavaju udaje potrebne na vypocet dane z prijmu
 *
 */

public class PrvaObrazovka implements ActionListener {

	private static JLabel podnikanieLabel;
	private static JTextField podnikanieText;
	private static JButton prveTlacidlo;
	private static JFrame framePrihlasenia;
	

	public void vytvorPrvuObrazovku() {
		JPanel panelPrihlasenia = new JPanel();
		framePrihlasenia = new JFrame();
		framePrihlasenia.setSize(600, 500);
		framePrihlasenia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrihlasenia.add(panelPrihlasenia);
		
		panelPrihlasenia.setLayout(null);
		
		podnikanieLabel = new JLabel("Typ podnikania");
		podnikanieLabel.setBounds(10, 20, 150, 25);
		panelPrihlasenia.add(podnikanieLabel);
		
		podnikanieText = new JTextField(20);
		podnikanieText.setBounds(100, 20, 165, 25);
		panelPrihlasenia.add(podnikanieText);
	

		
		prveTlacidlo = new JButton("Prihlásenie");
		prveTlacidlo.setBounds(10, 80, 200, 25);
		prveTlacidlo.addActionListener(this);
		panelPrihlasenia.add(prveTlacidlo);
		
		framePrihlasenia.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String podnikanie = podnikanieText.getText();
		if (podnikanie.equals("Zivnost") || podnikanie.equals("zivnost"))
		{
			framePrihlasenia.setVisible(false);
			obrazovkaZivnostnika ziv = new obrazovkaZivnostnika();
			ziv.vytvorObrazovkuZivnostnika();
		}
		
		else if (podnikanie.equals("Sro") || podnikanie.equals("sro")) {
			framePrihlasenia.setVisible(false);
			obrazovkaSro sro = new obrazovkaSro();
			sro.vytvorObrazovkuSro();
		}
		
		
	}
}
