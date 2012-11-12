package banque.view.panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import banque.controller.Controleur;
import banque.model.entites.client.Client;
import banque.view.Appli;
import banque.view.tablemodels.ClientTableModel;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class AffichageClientsPanel extends JPanel {
	
	// attributs
	private Controleur monCtrl;
	private Appli maFenetre;
	private ClientTableModel tmClient;
	
	// widgets
	private final JScrollPane spAffTableClients = new JScrollPane();
	private final JTable tableClients = new JTable();
	private final JButton btnAfficherComptes = new JButton("Afficher les comptes");
	private final JButton btnCreerClient = new JButton("Cr\u00E9er un nouveau client");
	private final JLabel lblListeDesClients = new JLabel("Liste des clients");

	/**
	 * Create the panel.
	 */
	public AffichageClientsPanel() {
		setMinimumSize(new Dimension(730, 330));
		setPreferredSize(new Dimension(730, 330));
		// code généré par WB
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(spAffTableClients, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(btnAfficherComptes)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(btnCreerClient)
					.addGap(29))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(282)
					.addComponent(lblListeDesClients)
					.addContainerGap(346, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblListeDesClients)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spAffTableClients, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAfficherComptes)
						.addComponent(btnCreerClient))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		btnAfficherComptes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAfficherComptes_actionPerformed(arg0);
			}
		});
		btnCreerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCreerClient_actionPerformed(arg0);
			}
		});
		
		spAffTableClients.setViewportView(tableClients);
		setLayout(groupLayout);

	}

	public void init(Appli fenetre, Controleur ctrl, List<Client> lesClients){
		this.maFenetre = fenetre;
		this.monCtrl = ctrl;
		this.tmClient = new ClientTableModel(lesClients);
		this.tableClients.setModel(this.tmClient);
	}
	
	protected void do_btnAfficherComptes_actionPerformed(ActionEvent arg0) {
	}

	protected void do_btnCreerClient_actionPerformed(ActionEvent arg0) {
	}

	public void rafraichir() {
		this.tableClients.revalidate();
	}
}
