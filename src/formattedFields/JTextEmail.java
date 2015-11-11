/*
 * Copyright (C) 2014 Rogério Eduardo Pereira
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package formattedFields;


import java.awt.BorderLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/*
 *	Arquivo  JTextEmail.java
 *	Campo Formatado para e-mail
 *	
 *	Sistema:	CamposFormatados
 *	Autor:      Rogério Eduardo Pereira
 *	Data:       28/02/2014
 */
public class JTextEmail extends JTextField
{
	public JTextEmail ()
	{
		initComponents();
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        //JTextEmail = new javax.swing.JTextField();

        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextEmailActionPerformed(evt);
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTextEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextEmailFocusLost(evt);
            }
        });

        //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        /*layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTextEmail)
        );*/
    }// </editor-fold>//GEN-END:initComponents

    private void JTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMoedaActionPerformed
        this.transferFocus();
    }//GEN-LAST:event_jTextMoedaActionPerformed
	
	 private void JTextEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusLost
       if(!this.validaEmail())
	   {
			this.setText("");
			this.requestFocus();
	   }
    }//GEN-LAST:event_jTextMoedaFocusLost
	 
	 private void JTextEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusGained
        if (this.getText().trim().compareTo("") != 0){
            this.selectAll();
        }
	}//GEN-LAST:event_jTextMoedaFocusGained
	
	private Boolean validaEmail()
	{
		String email = this.getText();
		
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(email); 
		if (m.find())
		  return true;
		else
		{
			JOptionPane.showMessageDialog(null, "E-mail Inválido", "E-mail Inválido",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	public Boolean validaEmail(String email)
	{
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(email); 
		if (m.find())
		  return true;
		else
		{
			JOptionPane.showMessageDialog(null, "E-mail Inválido", "E-mail Inválido",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	/*public String getText()
	{
		return this.JTextEmail.getText();
	}
	
	public void setText(String email)
	{
		this.JTextEmail.setText(email);
	} */
	 
	//public JTextField JTextEmail;
}