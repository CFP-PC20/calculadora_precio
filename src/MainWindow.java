import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class MainWindow {

	protected Shell shell;
	private Text Precio;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		/*
		shell.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					updatePrecio();
				}
			}
		});
		*/
		shell.setSize(450, 300);
		shell.setText("Calculadora de Jose Juan");
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblUnidades = new Label(composite, SWT.NONE);
		lblUnidades.setText("Unidades: ");
		
		Spinner spinner = new Spinner(composite, SWT.BORDER);
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrecio.setText("Precio: ");
		
		Precio = new Text(composite, SWT.BORDER);
		Precio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		

		Button btnCalcular = new Button(composite, SWT.NONE);
				
		
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String output;
				try {
					double precioUnidad = Double.parseDouble(Precio.getText());
					int cantidad = spinner.getSelection();
					double precioTotal = precioUnidad * cantidad;
					output = String.valueOf(precioTotal) + '€' ;
				} catch (IllegalArgumentException error) {
					output = Precio.getText() +  " no es un precio válido";
				}
				text.setText(text.getText() + "\r\n" + output);
				text.setTopIndex(text.getLineCount() - 1);
			}
		});
		btnCalcular.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		btnCalcular.setText("Calcular");
		
		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text = new Text(composite_2, SWT.BORDER | SWT.V_SCROLL);
		text.setEditable(false);

	}
	
	public void updatePrecio() {
		
	}
}
