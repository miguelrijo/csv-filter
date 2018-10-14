package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.CSVFileManagment;

import view.CSVFilterView;

/**
 * This class is responsible for listening the events from CSVFilterView Class
 * 
 * 
 * @author Miguel Rijo
 * 
 */

public class FilterCSVController implements ActionListener {

	private CSVFilterView selectFileWindow = null;
	private CSVFileManagment cVSManagment = null;
	private boolean successful;

	public FilterCSVController(CSVFilterView selectFileWindow) {
		this.selectFileWindow = selectFileWindow;
		this.cVSManagment = new CSVFileManagment();
	}

	/*
	 * This method is responsible for controlling each event produced by the
	 * user as the event or the start button search button, also validates that
	 * the fields are not empty.
	 * 
	 * @throws Exception
	 */

	public void actionPerformed(ActionEvent sender) {

		String actionCommand = sender.getActionCommand();

		if (actionCommand.equals("Search")) {
			JFileChooser fileSelector = new JFileChooser();
			fileSelector.showOpenDialog(this.selectFileWindow.getJTextField());
			String path = (fileSelector.getSelectedFile() != null) ? fileSelector
					.getSelectedFile().getPath()
					: "";
			this.selectFileWindow.getJTextField().setText(path);

		} else if (actionCommand.equals("Start")) {
			if (this.selectFileWindow.getJTextFieldAcceptedFileName().getText()
					.trim().isEmpty()
					|| this.selectFileWindow.getJTextFieldRejectedFileName()
							.getText().trim().isEmpty()
					|| this.selectFileWindow.getJTextField().getText().trim()
							.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"There're fields left in blank", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {

					this.successful = this.cVSManagment.startCVSProcess(
							this.selectFileWindow.getJTextField().getText(),
							this.selectFileWindow
									.getJTextFieldAcceptedFileName().getText(),
							this.selectFileWindow
									.getJTextFieldRejectedFileName().getText(),
							this.selectFileWindow.getJComboBoxMainColumn()
									.getSelectedIndex());
					if (this.successful)
						JOptionPane.showMessageDialog(null,
								"Operation successful", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane
								.showMessageDialog(
										null,
										"There was an error while writing or reading files",
										"Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "There was an error",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		}

	}
}
