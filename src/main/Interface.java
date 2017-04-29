package main;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import main.RegularAction.TypeOfAction;

import javax.swing.JRadioButton;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnDeduct;
	private JRadioButton rdbtnMultiply;
	private JRadioButton rdbtnDivide;
	private JLabel lblValue;
	private JLabel lblMinimalValue;
	private JTextField txtMinvalue;
	private JTextField txtValue;
	private JButton btnApply;
	private JTextField txtSearchvalue;
	private JLabel lblStartSymbo;
	private JTextField txtStartsymbol;
	private JLabel lblEndsymbol;
	private JTextField txtEndsymbol;
	private ButtonGroup groupRButtons;
	private TypeOfAction typeAction = TypeOfAction.Divide;
	private JLabel lblRegular;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() {
		setTitle("Regular replace file values");
		setBounds(100, 100, 461, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("82px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(76dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				RowSpec.decode("21px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		lblRegular = new JLabel("Regular");
		contentPane.add(lblRegular, "2, 2, center, default");

		txtSearchvalue = new JTextField();
		txtSearchvalue.setText("[0-9]+");
		contentPane.add(txtSearchvalue, "4, 2, fill, default");
		txtSearchvalue.setColumns(10);

		btnApply = new JButton("Apply");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegularAction rAction = new RegularAction(txtSearchvalue.getText(), txtStartsymbol.getText(),
						txtEndsymbol.getText(), Integer.parseInt(txtValue.getText()),
						Integer.parseInt(txtMinvalue.getText()), typeAction);
				FileJob fileAction = new FileJob();
				fileAction.applyFileAction(rAction);

			}
		});
		contentPane.add(btnApply, "8, 2, 1, 2");

		lblValue = new JLabel("Value");
		contentPane.add(lblValue, "2, 3, center, default");

		txtValue = new JTextField();
		txtValue.setText("2");
		contentPane.add(txtValue, "4, 3, fill, default");
		txtValue.setColumns(10);

		lblMinimalValue = new JLabel("Min Value");
		contentPane.add(lblMinimalValue, "2, 5, center, default");

		txtMinvalue = new JTextField();
		txtMinvalue.setText("10");
		contentPane.add(txtMinvalue, "4, 5, fill, default");
		txtMinvalue.setColumns(10);

		lblStartSymbo = new JLabel("StartSymbol");
		contentPane.add(lblStartSymbo, "2, 7, center, default");

		txtStartsymbol = new JTextField();
		txtStartsymbol.setText("=");
		contentPane.add(txtStartsymbol, "4, 7, fill, default");
		txtStartsymbol.setColumns(10);

		lblEndsymbol = new JLabel("EndSymbol");
		contentPane.add(lblEndsymbol, "2, 9, center, default");

		txtEndsymbol = new JTextField();
		txtEndsymbol.setText("");
		contentPane.add(txtEndsymbol, "4, 9, fill, default");
		txtEndsymbol.setColumns(10);

		rdbtnNewRadioButton = new JRadioButton("Addition");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				typeAction = TypeOfAction.Addition;
			}
		});
		contentPane.add(rdbtnNewRadioButton, "2, 10, center, center");

		rdbtnDeduct = new JRadioButton("Deduct");
		rdbtnDeduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				typeAction = TypeOfAction.Deduct;
			}
		});
		contentPane.add(rdbtnDeduct, "4, 10, center, center");

		rdbtnMultiply = new JRadioButton("Multiply");
		rdbtnMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				typeAction = TypeOfAction.Multiply;
			}
		});
		contentPane.add(rdbtnMultiply, "6, 10, center, default");

		rdbtnDivide = new JRadioButton("Divide");
		rdbtnDivide.setSelected(true);
		rdbtnDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				typeAction = TypeOfAction.Divide;
			}
		});
		contentPane.add(rdbtnDivide, "8, 10, center, default");

		groupRButtons = new ButtonGroup();
		groupRButtons.add(rdbtnDivide);
		groupRButtons.add(rdbtnDeduct);
		groupRButtons.add(rdbtnMultiply);
		groupRButtons.add(rdbtnDivide);
	}
}
