/*
 * TelaArea.java
 *
 * Created on 3 de Março de 2013, 16:56
 */
package visao;

import modelo.bd.AreaDao;
import modelo.bd.BDMySql;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author  Jessica
 */
public class TelaArea extends javax.swing.JFrame {

    AreaDao areaDao = new AreaDao();
    BDMySql bd = BDMySql.getInstance();
    private JDialog formArea;

    public TelaArea() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaAreas = new javax.swing.JTable();
        btInserir = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtListaAreas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtListaAreas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descricao"
            }
        ));
        jScrollPane1.setViewportView(jtListaAreas);

        btInserir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btInserir)
                        .addGap(18, 18, 18)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btSair)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btAtualizar)
                    .addComponent(btExcluir)
                    .addComponent(btSair))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed

        int i = jtListaAreas.getSelectedRow();

        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.parseInt((String) jtListaAreas.getValueAt(i, 0));

            formArea = new FormArea(this, true, id);
            formArea.setLocationRelativeTo(this);
            formArea.setVisible(true);
            atualizaTabela();
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Object[] options = {"Confirmar", "Cancelar"};
        int m = JOptionPane.showOptionDialog(null,
                "Deseja realmente exluir o registro selecionado?", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (m == 0) {
            int i = jtListaAreas.getSelectedRow();
            if (i == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                int id = Integer.parseInt((String) jtListaAreas.getValueAt(i, 0));
                areaDao.deletaArea(id);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabela();

            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        if (formArea == null) {
            //JFrame mainFrame = TelaPrincipal.getApplication().getMainFrame();
            formArea = new FormArea(this, true);
            formArea.setLocationRelativeTo(this);
        }
        formArea.setVisible(true);
        atualizaTabela();
    }//GEN-LAST:event_btInserirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TelaArea t = new TelaArea();
                t.setTitle("Sistema de Evolução de pacientes");
                t.atualizaTabela();
                t.setVisible(true);
            }
        });
    }

    public void atualizaTabela() {
        Object[][] lista = areaDao.listaAreas();
        jtListaAreas.setModel(new javax.swing.table.DefaultTableModel(
                lista, new String[]{"id", "Nome", "Descricao"}) {
        });
        jtListaAreas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtListaAreas.getColumnModel().getColumn(0).setResizable(true);
        jtListaAreas.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtListaAreas.getColumnModel().getColumn(1).setResizable(true);
        jtListaAreas.getColumnModel().getColumn(2).setPreferredWidth(60);
        jtListaAreas.getColumnModel().getColumn(2).setResizable(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListaAreas;
    // End of variables declaration//GEN-END:variables
}