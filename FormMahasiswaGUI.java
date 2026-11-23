import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Latihan/Eksplorasi GUI Java (Swing).
 *
 * 1. Top-level Container     : JFrame
 * 2. Intermediate Container  : JPanel, JScrollPane
 * 3. Atomic Component        : JLabel, JTextField, JComboBox, JCheckBox, JButton, JTextArea
 * 4. Layout Classes          : BorderLayout, GridLayout, FlowLayout
 * 5. Event Listener          : ActionListener (interface), MouseAdapter & WindowAdapter (adapter class)
 */
public class FormMahasiswaGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormMahasiswaGUI::buatDanTampilkanGUI);
    }

    private static void buatDanTampilkanGUI() {
        // ===== 1. TOP-LEVEL CONTAINER =====
        JFrame frame = new JFrame("Form Data Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(480, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10)); // Layout 1: BorderLayout

        // ===== 2. INTERMEDIATE CONTAINER =====
        // Panel judul (utara)
        JPanel panelJudul = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Layout 2: FlowLayout
        panelJudul.setBackground(new Color(40, 90, 160));
        JLabel lblJudul = new JLabel("FORM DATA MAHASISWA");
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 18));
        panelJudul.add(lblJudul);

        // Panel form (tengah)
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 8, 8)); // Layout 3: GridLayout
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));

        // ===== 3. ATOMIC COMPONENT =====
        JLabel lblNim = new JLabel("NIM");
        JTextField txtNim = new JTextField();
        JLabel lblNama = new JLabel("Nama");
        JTextField txtNama = new JTextField();
        JLabel lblJurusan = new JLabel("Program Studi");
        JComboBox<String> cmbJurusan = new JComboBox<>(new String[]{
                "Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Teknik Sipil"});
        JLabel lblSemester = new JLabel("Semester");
        JComboBox<Integer> cmbSemester = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        JCheckBox chkSetuju = new JCheckBox("Data yang saya isi sudah benar");

        panelForm.add(lblNim);      panelForm.add(txtNim);
        panelForm.add(lblNama);     panelForm.add(txtNama);
        panelForm.add(lblJurusan);  panelForm.add(cmbJurusan);
        panelForm.add(lblSemester); panelForm.add(cmbSemester);
        panelForm.add(new JLabel()); panelForm.add(chkSetuju);

        // Panel tombol
        JButton btnSimpan = new JButton("Simpan");
        JButton btnReset = new JButton("Reset");
        JButton btnKeluar = new JButton("Keluar");
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelTombol.add(btnSimpan);
        panelTombol.add(btnReset);
        panelTombol.add(btnKeluar);

        // Area output di dalam JScrollPane (intermediate container)
        JTextArea areaOutput = new JTextArea(6, 30);
        areaOutput.setEditable(false);
        areaOutput.setBorder(BorderFactory.createTitledBorder("Hasil"));
        JScrollPane scrollOutput = new JScrollPane(areaOutput);

        // Panel bawah menggabungkan tombol dan output
        JPanel panelBawah = new JPanel(new BorderLayout());
        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(scrollOutput, BorderLayout.CENTER);
        panelBawah.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));

        frame.add(panelJudul, BorderLayout.NORTH);
        frame.add(panelForm, BorderLayout.CENTER);
        frame.add(panelBawah, BorderLayout.SOUTH);

        // ===== 5. EVENT LISTENER =====

        // (a) ActionListener (Event Listener Interface) -> override actionPerformed
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText().trim();
                String nama = txtNama.getText().trim();

                if (nim.isEmpty() || nama.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "NIM dan Nama wajib diisi!",
                            "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!chkSetuju.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Centang pernyataan terlebih dahulu.",
                            "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                areaOutput.setText(
                        "NIM           : " + nim + "\n" +
                        "Nama          : " + nama + "\n" +
                        "Program Studi : " + cmbJurusan.getSelectedItem() + "\n" +
                        "Semester      : " + cmbSemester.getSelectedItem());
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNim.setText("");
                txtNama.setText("");
                cmbJurusan.setSelectedIndex(0);
                cmbSemester.setSelectedIndex(0);
                chkSetuju.setSelected(false);
                areaOutput.setText("");
            }
        });

        btnKeluar.addActionListener(e -> frame.dispatchEvent(
                new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));

        // (b) MouseAdapter (Event Adapter Class) -> override mouseEntered & mouseExited
        btnSimpan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSimpan.setBackground(new Color(144, 238, 144));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSimpan.setBackground(null);
            }
        });

        // (c) WindowAdapter (Event Adapter Class) -> override windowClosing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int pilih = JOptionPane.showConfirmDialog(frame,
                        "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (pilih == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);
    }
}
