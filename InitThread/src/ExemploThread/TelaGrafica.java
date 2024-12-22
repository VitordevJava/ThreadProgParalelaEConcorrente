package ExemploThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaGrafica extends JDialog {

	JPanel jpanel = new JPanel(new GridBagLayout()); /* Painel de componentes */

	private Label DescricaoTime1 = new Label("Nome");
	private JTextField MostraTempo = new JTextField();

	private Label DescricaoTime2 = new Label("E-mail");
	private JTextField MostraTempo2 = new JTextField();

	JButton jButton1 = new JButton("Add Lista");
	JButton jButton2 = new JButton("Stop");
	
	
	private ImplementaçãoFila fila = new ImplementaçãoFila();


	public TelaGrafica() {
		setTitle("Tela Gráfica de Threads");
		setSize(new Dimension(280, 280));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.0;

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
		DescricaoTime1.setPreferredSize(new Dimension(200, 25));
		jpanel.add(DescricaoTime1, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
		MostraTempo.setPreferredSize(new Dimension(220, 25));
		jpanel.add(MostraTempo, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
		DescricaoTime2.setPreferredSize(new Dimension(200, 25));
		jpanel.add(DescricaoTime2, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		MostraTempo2.setPreferredSize(new Dimension(220, 25));
		gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
		jpanel.add(MostraTempo2, gridBagConstraints);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		jButton1.setPreferredSize(new Dimension(94, 25));
		jButton2.setPreferredSize(new Dimension(94, 25));
		buttonPanel.add(jButton1);
		buttonPanel.add(jButton2);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
		jpanel.add(buttonPanel, gridBagConstraints);

		
		jButton1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 
		    	
		    	if(fila == null) {
		    		fila = new ImplementaçãoFila();
		    		fila.start();
		    	}
		        for (int qtd = 1; qtd <= 100; qtd++) { /* Simulando 100 envios em massa */
		            ObjetoFilaThread filaThread = new ObjetoFilaThread();

		            /* Concatena o contador 'qtd' ao nome */
		            filaThread.setNome(MostraTempo.getText() + " - " + qtd);
		            filaThread.setEmail(MostraTempo2.getText());

		            fila.add(filaThread); /* Adiciona o objeto à fila*/
		        }
		    }
		});
	
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		jButton2.addActionListener(new ActionListener() { /* Executa o botão Stop */

			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
		});
		

		fila.start(); // Inicia a execução da thread

		add(jpanel, BorderLayout.CENTER); /* Centraliza o painel no layout */
		setVisible(true);
	}
}
