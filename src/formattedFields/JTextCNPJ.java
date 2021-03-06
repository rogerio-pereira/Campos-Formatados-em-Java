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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/*
 *	Arquivo  JTextCNPJ.java
 *	Campo Formatado para CNPJ
 *	
 *	Sistema:	CamposFormatados
 *	Autor:      Rogério Eduardo Pereira
 *	Data:       27/02/2014
 */
public class JTextCNPJ extends JFormattedTextField
{
	public JTextCNPJ ()
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
        //JTextCNPJ = new javax.swing.JFormattedTextField();
		
		try
        {
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextCNPJActionPerformed(evt);
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTextCNPJFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextCNPJFocusLost(evt);
            }
        });

        //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        /*layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTextCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTextCNPJ)
        );*/
    }// </editor-fold>//GEN-END:initComponents

    private void JTextCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMoedaActionPerformed
        this.transferFocus();
    }//GEN-LAST:event_jTextMoedaActionPerformed
	
	 private void JTextCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusLost
        if(!this.getText().contains(" "))
		{
			//CPF Invalido
			if(!this.validaCNPJ())
			{
				JOptionPane.showMessageDialog(null, "CNPJ Inválido", "CNPJ Inválido",JOptionPane.INFORMATION_MESSAGE);
				this.setText("");
				this.requestFocus();
			}
		}
		//Espaço em branco
		else
		{
			//Se não é a mascara em branco
			if(!this.getText().equals("  .   .   /    -  "))
			{
				JOptionPane.showMessageDialog(null, "CNPJ Inválido", "CNPJ Inválido",JOptionPane.INFORMATION_MESSAGE);
				this.setText("");
				this.requestFocus();
			}
		}
    }//GEN-LAST:event_jTextMoedaFocusLost
	 
	 private void JTextCNPJFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusGained
        if (this.getText().trim().compareTo("") != 0){
            this.selectAll();
        }
	}//GEN-LAST:event_jTextMoedaFocusGained
	 
	 public Boolean validaCNPJ()
	 {
		 if(this.validaSequencia())
			if(this.validaPrimeiroDigito())
				if(this.validaSegundoDigito())
					return true;
		 
		 
		 return false;
	 }
	 
	 public Boolean validaSequencia()
	 {
		 String cnpj	= new String();
		 cnpj			= this.getText().toString();
		 
		 cnpj			= cnpj.replace(".", "");
		 cnpj			= cnpj.replace("/", "");
		 cnpj			= cnpj.replace("-", "");
		 cnpj			= cnpj.substring(0, 8) + cnpj.substring(12, 14);
		 
		 if (                 
				 cnpj.equals("1111111111") ||
				 cnpj.equals("2222222222") ||
				 cnpj.equals("3333333333") ||
				 cnpj.equals("4444444444") ||
				 cnpj.equals("5555555555") ||
				 cnpj.equals("6666666666") ||
				 cnpj.equals("7777777777") ||
				 cnpj.equals("8888888888") ||
				 cnpj.equals("9999999999") ||
				 cnpj.equals("0000000000")
			)
			 return false;
		 else return true;
	 }
	 
	 public Boolean validaPrimeiroDigito()
	 {
		 String cnpj	= new String();
		 int	soma	= 0;
		 int	j       = 5;
		 int	compara;
		 cnpj			= this.getText().toString();
		 
		 cnpj			= cnpj.replace(".", "");
		 cnpj			= cnpj.replace("/", "");
		 cnpj			= cnpj.replace("-", "");
		 
		 for(int i=0; i<12; i++)
		 {
			 if(i == 4)
				 j = 9;
			 
			 soma += Integer.parseInt(cnpj.substring(i, i+1)) * j;
					
			 j--;
		 }
		 
		 soma = soma % 11;
		 
		 if((soma == 0) || (soma == 1))
			 compara = 0;
		 else
			 compara = 11 - soma;
		 
		 if(Integer.parseInt(cnpj.substring(12, 13)) == compara)
			return true;
		 else
			return false;
	 }
	 
	 public Boolean validaSegundoDigito()
	 {
		 String cnpj	= new String();
		 int	soma	= 0;
		 int	j       = 6;
		 int	compara;
		 cnpj			= this.getText().toString();
		 
		 cnpj			= cnpj.replace(".", "");
		 cnpj			= cnpj.replace("/", "");
		 cnpj			= cnpj.replace("-", "");
		 
		 for(int i=0; i<13; i++)
		 {
			 if(i == 5)
				 j = 9;
			 
			 soma += Integer.parseInt(cnpj.substring(i, i+1)) * j;
					
			 j--;
		 }
		 
		 soma = soma % 11;
		 
		 if((soma == 0) || (soma == 1))
			 compara = 0;
		 else
			 compara = 11 - soma;
		 
		 if(Integer.parseInt(cnpj.substring(13, 14)) == compara)
			return true;
		 else
			return false;
	 }
	 
	 public String getCNPJ()
	 {
		 if(getText().equals("  .   .   /    -  "))
			 return null;
		 else
			 return getText();
	 }
	 
	/*public String getText()
	{
		if(getText())
		return this.getText();
	}
	
	public void setText(String cep)
	{
		this.setText(cep);
	} 
	
	public void setEnabled(Boolean habilita)
	{
		this.setEnabled(habilita);
	}*/
	 
	 //public JFormattedTextField JTextCNPJ;
}
