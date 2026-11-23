import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiSapa {

    public static void main(String[] args) {

        // 1. Top-level Container: JFrame (jendela utama)
        JFrame frame = new JFrame("Aplikasi Sapa");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout 1: BorderLayout untuk frame
        frame.setLayout(new BorderLayout());

        // 2. Intermediate Container: JPanel
        JPanel panelInput = new JPanel();
        // Layout 2: FlowLayout untuk panel
        panelInput.setLayout(new FlowLayout());

        // 3. Atomic Component
        JLabel labelNama = new JLabel("Nama:");
        JTextField kolomNama = new JTextField(15);
        JButton tombolSapa = new JButton("Sapa");
        JButton tombolReset = new JButton("Reset");
        JLabel labelHasil = new JLabel("Silakan isi nama kamu", JLabel.CENTER);

        // Masukkan komponen ke panel
        panelInput.add(labelNama);
        panelInput.add(kolomNama);
        panelInput.add(tombolSapa);
        panelInput.add(tombolReset);

        // Masukkan panel dan label ke frame
        frame.add(panelInput, BorderLayout.NORTH);
        frame.add(labelHasil, BorderLayout.CENTER);

        // 5. Event Listener (Interface): ActionListener
        tombolSapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = kolomNama.getText();
                labelHasil.setText("Halo, " + nama + "!");
            }
        });

        tombolReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kolomNama.setText("");
                labelHasil.setText("Silakan isi nama kamu");
            }
        });

        // Event Adapter Class: MouseAdapter
        tombolSapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tombolSapa.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tombolSapa.setBackground(null);
            }
        });

        frame.setVisible(true);
    }
}
