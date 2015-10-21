package simplegame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Rectangle;

public class Main {

	protected Shell shlSimpleGame;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
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
		shlSimpleGame.open();
		shlSimpleGame.layout();
		while (!shlSimpleGame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSimpleGame = new Shell();

		shlSimpleGame.setSize(450, 300);
		shlSimpleGame.setText("Simple Game");
		shlSimpleGame.setLayout(null);

		final Label lblJeton = new Label(shlSimpleGame, SWT.NONE);
		lblJeton.setBounds(10, 100, 50, 50);
		lblJeton.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));

		Label lblMoveMeThis = new Label(shlSimpleGame, SWT.NONE);
		lblMoveMeThis.setFont(SWTResourceManager.getFont(".Helvetica Neue DeskInterface", 20, SWT.NORMAL));
		lblMoveMeThis.setBounds(10, 36, 280, 24);
		lblMoveMeThis.setText("Move me in this direction » » »");

		Label lblFinish = new Label(shlSimpleGame, SWT.SEPARATOR | SWT.VERTICAL);
		lblFinish.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblFinish.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblFinish.setText("Finish");
		lblFinish.setBounds(390, 95, 2, 64);
		
		final Label lblGreat = new Label(shlSimpleGame, SWT.NONE);
		lblGreat.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblGreat.setFont(SWTResourceManager.getFont(".Helvetica Neue DeskInterface", 19, SWT.NORMAL));
		lblGreat.setBounds(179, 178, 57, 24);
		lblGreat.setText("Great!");
		lblGreat.setVisible(false);

		shlSimpleGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.keyCode == 16777220)
				{
					Rectangle bounds = lblJeton.getBounds();

					if(bounds.x <= 330)
						lblJeton.setBounds(bounds.x+10, bounds.y, bounds.width, bounds.height);

					if(bounds.x == 330)
						lblGreat.setVisible(true);
				}
			}
		});
	}
}
