import javax.swing.JOptionPane;

public class RunnerMain {

	public static void main(String[] args) {
		try {
		EndlessRunner runner = new EndlessRunner();
		runner.createGUI();
		} catch(Throwable t) {
			JOptionPane.showMessageDialog(null, t.getClass().getSimpleName() + ": " + t.getMessage());
			throw t;
		}

	}

}
