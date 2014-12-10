/*
 * jTextMoeda.java
 *
 * Created on 9 de Novembro de 2007, 16:59
 */

package formattedFields;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author  mauro
 */
public class jTextMoeda extends JFormattedTextField {
    
    /** Creates new form jTextMoeda */
    public jTextMoeda() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        //jTextMoeda = new javax.swing.JTextField();

        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMoedaActionPerformed(evt);
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextMoedaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextMoedaFocusLost(evt);
            }
        });
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextMoedaKeyReleased(evt);
            }
        });

        //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        /*layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextMoeda, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextMoeda)
        );*/
    }// </editor-fold>//GEN-END:initComponents

    private void jTextMoedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMoedaActionPerformed
        this.transferFocus();
    }//GEN-LAST:event_jTextMoedaActionPerformed

    private void jTextMoedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMoedaKeyReleased
        double valor = 0;
        
        if (this.getText().length() != 0) {
            String str = this.getText();
            str = str.replace(',','.');
            try {
                valor = Double.parseDouble(str);
            } catch (java.lang.NumberFormatException ex) {
                this.setText("");
                JOptionPane.showMessageDialog(null, "Esse campo só aceita números \n Ex.: 380,52", "ATENÇÃO",
                        JOptionPane.INFORMATION_MESSAGE);
                this.grabFocus();
                
            }
        }
    }//GEN-LAST:event_jTextMoedaKeyReleased

    private void jTextMoedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusLost
        if (this.getText().trim().compareTo("") != 0){
            String str = this.getText();
            
            str = str.replaceAll("\\.","");
            str = str.replace(',','.');
            str = mascaraDinheiro(Double.parseDouble(str),DINHEIRO_REAL);
			str = "R$ " + str;
            this.setText(str);
        }else
            this.setText("");
    }//GEN-LAST:event_jTextMoedaFocusLost

    private void jTextMoedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusGained
        if (this.getText().trim().compareTo("") != 0){
            String str = this.getText();
            
            str = str.replaceAll("\\.","");
            this.setText(str);
            this.selectAll();
            
        }
    }//GEN-LAST:event_jTextMoedaFocusGained
	
	/*public String getText()
	{
		return this.getText();
	}*/
	
	public Double getValue()
	{
		String valor = this.getText();
		valor = valor.replace("R$ ", "");
		valor = valor.replace(".", "");
		valor = valor.replace(",", ".");
		
		return Double.parseDouble(valor);
	}
	
	public void setText(Double valor)
	{
		String str;
		str = mascaraDinheiro(Double.parseDouble(valor.toString()),DINHEIRO_REAL);
		str = "R$ " + str;
		
		this.setText(str);
	}
	
	/*public void setEnabled(Boolean habilita)
	{
		this.setEnabled(habilita);
	}*/
    
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    //private javax.swing.JTextField jTextMoeda;
    // Fim da declaração de variáveis//GEN-END:variables
    
    private static final Locale BRAZIL = new Locale("pt","BR");
    private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
    public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("###,###,##0.00",REAL);
    // ¤ 
    public static String mascaraDinheiro(double valor, DecimalFormat moeda){
        return moeda.format(valor);
    }
}