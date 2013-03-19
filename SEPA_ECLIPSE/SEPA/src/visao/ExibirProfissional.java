/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Controle;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author WELLITON
 */
public class ExibirProfissional extends javax.swing.JFrame {
Controle controle = new Controle();
 private JDialog cadastraProfissional;
    /**
     * Creates new form ExibirProfissional
     */
    public ExibirProfissional() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfissional = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonInserir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableProfissional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9", "Título 10", "Título 11"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProfissional);

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserir)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserir)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSair)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
         if (cadastraProfissional == null) {
        //JFrame mainFrame = TelaPrincipal.getApplication().getMainFrame();
        cadastraProfissional= new CadastraProfissional(this, true);
         cadastraProfissional.setLocationRelativeTo(this);
    }
    cadastraProfissional.setVisible(true);
    atualizaTabela();
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
    int i = jTableProfissional.getSelectedRow();
    if (i == -1) JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela","Erro",JOptionPane.ERROR_MESSAGE);
    else {
            int  id = Integer.parseInt((String)jTableProfissional.getValueAt(i, 0));
            try {
                cadastraProfissional = new CadastraProfissional(this, true, id);
            } catch (ParseException ex) {
                Logger.getLogger(ExibirProfissional.class.getName()).log(Level.SEVERE, null, ex);
            }
            cadastraProfissional.setLocationRelativeTo(this);
            cadastraProfissional.setVisible(true);
            atualizaTabela();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
  System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
  Object[] options = { "Confirmar", "Cancelar" };
    int m = JOptionPane.showOptionDialog(null,
                    "Deseja realmente exluir o registro selecionado?", "Informação",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
    if (m == 0) {
            int i = jTableProfissional.getSelectedRow();
            if (i == -1) JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela","Erro",JOptionPane.ERROR_MESSAGE);
            else {
                    int  id = Integer.parseInt((String)jTableProfissional.getValueAt(i, 0));
                    controle.deletaProficional(id);
                    JOptionPane.showMessageDialog(null,"Registro excluído com sucesso","Informação",JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabela();

            }
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExibirProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExibirProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExibirProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExibirProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new ExibirProfissional().setVisible(true);
                
                ExibirProfissional exibir = new ExibirProfissional();
                exibir.setVisible(true);
                exibir.atualizaTabela();
            }
        });
    }
        public void atualizaTabela(){
		Object[][] lista =controle.listaProfissional();
		jTableProfissional.setModel(new javax.swing.table.DefaultTableModel(
				lista, new String[] { "Codigo","Nome","      Data Nascimento","CPF","Cidade","Telefone","Coselho","Email","Tipo","Profissao","Hospital"}) {
			
		});
		jTableProfissional.getColumnModel().getColumn(0).setPreferredWidth(50);
		jTableProfissional.getColumnModel().getColumn(0).setResizable(true);
		jTableProfissional.getColumnModel().getColumn(1).setPreferredWidth(150);
		jTableProfissional.getColumnModel().getColumn(1).setResizable(true);
		jTableProfissional.getColumnModel().getColumn(2).setPreferredWidth(60);
		jTableProfissional.getColumnModel().getColumn(2).setResizable(true);
		jTableProfissional.getColumnModel().getColumn(3).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(3).setResizable(true);
                jTableProfissional.getColumnModel().getColumn(4).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(4).setResizable(true);
                 jTableProfissional.getColumnModel().getColumn(5).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(5).setResizable(true);
                 jTableProfissional.getColumnModel().getColumn(6).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(6).setResizable(true);
                 jTableProfissional.getColumnModel().getColumn(7).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(7).setResizable(true);
                 jTableProfissional.getColumnModel().getColumn(8).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(8).setResizable(true);
                jTableProfissional.getColumnModel().getColumn(9).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(9).setResizable(true);
                jTableProfissional.getColumnModel().getColumn(10).setPreferredWidth(160);
		jTableProfissional.getColumnModel().getColumn(10).setResizable(true);



	}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfissional;
    // End of variables declaration//GEN-END:variables
}