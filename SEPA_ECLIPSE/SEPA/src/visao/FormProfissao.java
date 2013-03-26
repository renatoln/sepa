/*
 * FormProfissao.java
 *
 * Created on 3 de Março de 2013, 18:00
 */
package visao;

import modelo.bd.BDMySql;
import modelo.bd.ProfissaoDao;
import modelo.negocio.Profissao;
import javax.swing.JOptionPane;

/**
 *
 * @author  Jessica
 */
public class FormProfissao extends javax.swing.JDialog {

    ProfissaoDao pd = new ProfissaoDao();
    BDMySql bd = BDMySql.getInstance();
    private int idProfissao = -1;

    public FormProfissao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public FormProfissao(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        preencheTela(id);
        idProfissao = id;


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        btInserir = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlNome.setText("Nome");

        jtfNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btInserir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jlNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btInserir)
                        .addGap(18, 18, 18)
                        .addComponent(btLimpar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btLimpar))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        if (verificarCampos()) {

            Profissao p = new Profissao(
                    jtfNome.getText());
            String msn;
            if (idProfissao == -1) {
                pd.cadastraProfissao(p);
                msn = "Profissao cadastrada com sucesso";
            } else {
                pd.atualizaProfissao(p);
                msn = "Profissao atualizada com sucesso";
                System.out.println(p);
            }
            fechaJanela(msn);
        }
    }//GEN-LAST:event_btInserirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btLimparActionPerformed

    private void limparTela() {
        jtfNome.setText("");
        jtfNome.grabFocus();//coloca o focus no campo
    }

    private boolean verificarCampos() {
        String sErro = "";
        boolean erro = false;
        if (jtfNome.getText().equals("")) {
            sErro = "O nome não pode ficar em branco!";
            jtfNome.grabFocus();
            erro = true;
        }

        if (erro) {
            JOptionPane.showMessageDialog(null, sErro, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    private void preencheTela(int id) {

        Profissao p = pd.getProfissao(id);
        jtfNome.setText(p.getNome());
        btInserir.setText("Atualizar");
    }

    private void fechaJanela(String msn) {
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, msn, "Informação", JOptionPane.INFORMATION_MESSAGE);


    // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormProfissao dialog = new FormProfissao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}