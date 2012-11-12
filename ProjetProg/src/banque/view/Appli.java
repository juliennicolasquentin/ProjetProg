package banque.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import banque.controller.Controleur;
import banque.model.entites.client.Client;
import banque.view.panels.AffichageClientsPanel;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import java.awt.Dimension;

public class Appli {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	private AffichageClientsPanel tabClients; // tab 0
	
	private Controleur monControleur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appli window = new Appli();
					Controleur ctrl = new Controleur(window);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Appli() {
		initialize();
		// initialiser les onglets
		this.tabClients = new AffichageClientsPanel();
		tabbedPane.setPreferredSize(new Dimension(750, 350));
		tabbedPane.setMinimumSize(new Dimension(750, 350));
		tabbedPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_tabbedPane_focusGained(arg0);
			}
		});
		// ajouter tous les onglets
		this.tabbedPane.addTab("Clients", this.tabClients);

		// activer le premier onglet uniquement
		this.tabbedPane.setEnabledAt(0, true);
		this.desactiverOnglets();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 400));
		frame.setMinimumSize(new Dimension(800, 400));
		frame.setSize(new Dimension(730, 330));
		frame.setBounds(100, 100, 655, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
					.addGap(14))
		);
		
		frame.getContentPane().setLayout(groupLayout);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
	}

	private void desactiverOnglets() {
		// seul l'onglet Clients est actif, les autres sont inaccessibles
		for (int i = 1; i < this.tabbedPane.getTabCount(); i++){
			this.tabbedPane.setEnabledAt(i, false);
		}		
	}
	
	protected void do_tabbedPane_focusGained(FocusEvent arg0) {
		// si l'utilisateur clique sur l'onglet Clients
		// on dŽsactive tous les autres et on les rŽinitialise
		if ( this.tabbedPane.getSelectedComponent().equals(tabClients)){
			this.desactiverOnglets();
		}
		// si l'utilisateur clique sur l'onglet Comptes
		// on dŽsactive l'onglet OpŽrations et on le rŽinitialise
		// on dŽsactive l'onglet CrŽer Compte et on le rŽinitialise
	}


	public void initVue(Controleur ctrl, List<Client> clients) {
		this.monControleur = ctrl;
		this.tabClients.init(this, ctrl, clients);
	}

	
}
