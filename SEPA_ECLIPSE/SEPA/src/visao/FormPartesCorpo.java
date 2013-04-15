/*
 * FormPessoa.java
 *
 * Created on 21 de Abril de 2010, 16:59
 */

package visao;


import javax.swing.JOptionPane;
import modelo.bd.BDMySql;
import modelo.bd.PartesCorpoDao;
import modelo.negocio.PartesCorpo;


/**
 *
 */
public class FormPartesCorpo extends javax.swing.JDialog {

    PartesCorpoDao pc = new PartesCorpoDao();
    BDMySql bd  = BDMySql.getInstance();
    private int idPartesCorpo = -1;
    /** Creates new form FormPessoa */
     
    public FormPartesCorpo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public FormPartesCorpo(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();        
        preencheTela(id);
        idPartesCorpo = id;
        
    }

    public void inicializaCampos(){
        jbInserir.setText("Inserir");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Nome");
        jLabel1.setName("jLabel1"); // NOI18N

        jtfNome.setName("jtfNome"); // NOI18N

        jbInserir.setText("Inserir");
        jbInserir.setName("jbInserir"); // NOI18N
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.setName("jbLimpar"); // NOI18N
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel2.setText("Cadastra Partes Corpo");
        jLabel2.setName("jLabel2"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jLabel1)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(8, 8, 8)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(layout.createSequentialGroup()
                                .add(52, 52, 52)
                                .add(jbInserir)
                                .add(40, 40, 40)
                                .add(jbLimpar)))
                        .add(100, 100, 100))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jtfNome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(jLabel2)
                .add(46, 46, 46)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jtfNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(82, 82, 82)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbInserir)
                    .add(jbLimpar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
    limparTela();
}//GEN-LAST:event_jbLimparActionPerformed

private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
  if (verificarCampos()){
       
     PartesCorpo p = new PartesCorpo(idPartesCorpo, jtfNome.getText());
                       
        String msn;
        if (idPartesCorpo == -1){
                pc.cadastraPartesCorpo(p);
                msn = "Cadastro realizado com sucesso";
        }
        else {
                pc.atualizaPartesCorpo(p);
                msn = "Atualizado com sucesso";
        }
        limparTela();
        fechaJanela(msn);
    }
    idPartesCorpo = -1;
}//GEN-LAST:event_jbInserirActionPerformed
     private void limparTela(){
        jtfNome.setText("");
        //jrbNone.setSelected(true);        
        jtfNome.grabFocus();//coloca o focus no campo
    }
    
    private boolean verificarCampos(){
        String sErro = "";
        boolean erro = false;
        if (jtfNome.getText().equals("")) {
                sErro = "O nome não pode ficar em branco!";
                jtfNome.grabFocus();
                erro = true;       
        }
        return true;

    }
    private void preencheTela(int id){
       PartesCorpo p = pc.getPartesCorpo(id);
        jtfNome.setText(p.getNome());              
        
        jbInserir.setText("Atualizar");
    }
    private void fechaJanela(String msn){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null,msn,"Informação",JOptionPane.INFORMATION_MESSAGE);
            
    }
    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPessoa dialog = new FormPessoa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables

}
