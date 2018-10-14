package view;

import java.awt.GridBagConstraints;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.FilterCSVController;


public class CSVFilterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelSelectFile = null;
	private JLabel jLabel1 = null;
	private JTextField jTextField = null;
	private JButton jButtonSelectInputFile = null;
	private JLabel RejectedOutputFileName = null;
	private JTextField jTextFieldRejectedFileName = null;
	private JLabel jLabelAcceptedFileName = null;
	private JTextField jTextFieldAcceptedFileName = null;
	private JLabel jLabelMainColumn = null;
	private JComboBox jComboBoxMainColumn = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JButton jButtonStart = null;
	/**
	 * This is the default constructor
	 */
	public CSVFilterView() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(388, 434);
		this.setContentPane(getJContentPane());
		jButtonSelectInputFile.addActionListener(new FilterCSVController(this));
		jButtonStart.addActionListener(new FilterCSVController(this));
		this.setTitle("CSVFilter");
	
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelSelectFile(), null);
			jContentPane.add(getJMenu(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelSelectFile	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSelectFile() {
		if (jPanelSelectFile == null) {
			jLabelMainColumn = new JLabel();
			jLabelMainColumn.setBounds(new Rectangle(19, 251, 173, 23));
			jLabelMainColumn.setText("Select main column");
			jLabelAcceptedFileName = new JLabel();
			jLabelAcceptedFileName.setBounds(new Rectangle(17, 180, 172, 23));
			jLabelAcceptedFileName.setText("Name of AcceptedOutputFile");
			RejectedOutputFileName = new JLabel();
			RejectedOutputFileName.setBounds(new Rectangle(14, 103, 171, 29));
			RejectedOutputFileName.setText("Name of RejectedOutPutFile");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 26, 161, 30));
			jLabel1.setText("Select InputCSVFile");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jPanelSelectFile = new JPanel();
			jPanelSelectFile.setLayout(null);
			jPanelSelectFile.setBounds(new Rectangle(0, 0, 369, 391));
			jPanelSelectFile.add(jLabel1, null);
			jPanelSelectFile.add(getJTextField(), null);
			jPanelSelectFile.add(getJButtonSelectInputFile(), null);
			jPanelSelectFile.add(RejectedOutputFileName, null);
			jPanelSelectFile.add(getJTextFieldRejectedFileName(), null);
			jPanelSelectFile.add(jLabelAcceptedFileName, null);
			jPanelSelectFile.add(getJTextFieldAcceptedFileName(), null);
			jPanelSelectFile.add(jLabelMainColumn, null);
			jPanelSelectFile.add(getJComboBoxMainColumn(), null);
			jPanelSelectFile.add(getJButtonStart(), null);
		}
		return jPanelSelectFile;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setEditable(false);
			jTextField.setBounds(new Rectangle(15, 60, 241, 24));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButtonSelectInputFile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSelectInputFile() {
		if (jButtonSelectInputFile == null) {
			jButtonSelectInputFile = new JButton();
			jButtonSelectInputFile.setBounds(new Rectangle(270, 58, 94, 24));
			jButtonSelectInputFile.setText("Search");
			
		}
		return jButtonSelectInputFile;
	}

	/**
	 * This method initializes jTextFieldRejectedFileName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextFieldRejectedFileName() {
		if (jTextFieldRejectedFileName == null) {
			jTextFieldRejectedFileName = new JTextField();
			jTextFieldRejectedFileName.setBounds(new Rectangle(16, 136, 245, 25));
		}
		return jTextFieldRejectedFileName;
	}

	/**
	 * This method initializes jTextFieldAcceptedFileName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextFieldAcceptedFileName() {
		if (jTextFieldAcceptedFileName == null) {
			jTextFieldAcceptedFileName = new JTextField();
			jTextFieldAcceptedFileName.setBounds(new Rectangle(16, 209, 247, 23));
		}
		return jTextFieldAcceptedFileName;
	}

	/**
	 * This method initializes jComboBoxMainColumn	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	public JComboBox getJComboBoxMainColumn() {
		if (jComboBoxMainColumn == null) {
			jComboBoxMainColumn = new JComboBox();
			jComboBoxMainColumn.addItem("Last Name");
			jComboBoxMainColumn.addItem("First Name");
			jComboBoxMainColumn.addItem("Department");
			jComboBoxMainColumn.addItem("Hired Date");
			jComboBoxMainColumn.setSelectedIndex(0);
			jComboBoxMainColumn.setBounds(new Rectangle(18, 281, 246, 23));
		}
		return jComboBoxMainColumn;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("File");
			jMenu.setBounds(new Rectangle(195, 0, 139, 13));
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Open File");
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem.setText("Exit");
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jButtonStart	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setBounds(new Rectangle(225, 345, 121, 31));
			jButtonStart.setText("Start");
		}
		return jButtonStart;
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"