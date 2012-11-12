package banque.view.tablemodels;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import banque.model.entites.client.Client;

@SuppressWarnings("serial")
public class ClientTableModel extends AbstractTableModel {
	
	List<Client> lesClients ;
	
	public ClientTableModel(List<Client> lesClients){
		super();
		this.lesClients = lesClients;
	}

	public Client getClientAt(int pos){
		return this.lesClients.get(pos);
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		if ( arg0 == 0 ){
			return "Identite";
		}
		return "Adresse";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.lesClients.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Client leClient = this.lesClients.get(arg0);
		if ( arg1 == 0){
			return leClient.getIdentite();
		}
		return leClient.getAdresse();
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
}
