
package libririan_project;

/**
 *
 * @author UMAKANTH
 */
public class LibririanForm extends javax.swing.JFrame {


    public LibririanForm() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        issueBtn = new javax.swing.JButton();
        viesIssBtn = new javax.swing.JButton();
        rtnBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIBRIRIAN SECTION");

        addBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addBtn.setText("ADD BOOKS");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        viewBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewBtn.setText("VIEW BOOKS");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        issueBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        issueBtn.setText("ISSUE BOOK");
        issueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnActionPerformed(evt);
            }
        });

        viesIssBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viesIssBtn.setText("VIEW ISSUED BOOKS");
        viesIssBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viesIssBtnActionPerformed(evt);
            }
        });

        rtnBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtnBtn.setText("RETURN BOOK");
        rtnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtnBtnActionPerformed(evt);
            }
        });

        logOutBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOutBtn.setText("LOG OUT");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(issueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(viesIssBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                .addComponent(rtnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viesIssBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viesIssBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viesIssBtnActionPerformed

        ViewIssuedBooks ob = new ViewIssuedBooks();
        ob.setVisible(true);
        dispose();
        //
    }//GEN-LAST:event_viesIssBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed

        Welcome_page ob = new Welcome_page();
        ob.setVisible(true);
        dispose();
        //
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        AddBooks ob = new AddBooks();
        ob.setVisible(true);
        dispose();
        //
    }//GEN-LAST:event_addBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed

        ViewBooks ob = new ViewBooks();
        ob.setVisible(true);
        dispose();
        //
    }//GEN-LAST:event_viewBtnActionPerformed

    private void issueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnActionPerformed

        IssueBook ob = new IssueBook();
        ob.setVisible(true);
        dispose();
        //
    }//GEN-LAST:event_issueBtnActionPerformed

    private void rtnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtnBtnActionPerformed

        ReturnBookForm ob = new ReturnBookForm();
        ob.setVisible(true);
        dispose();
        //
    }//GEN-LAST:event_rtnBtnActionPerformed


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
            java.util.logging.Logger.getLogger(LibririanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibririanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibririanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibririanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibririanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton issueBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton rtnBtn;
    private javax.swing.JButton viesIssBtn;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
