/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formattedFields;


import classes.WebServiceCep;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;



/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Feb 27, 2014
 */
public class JTextCep extends JFormattedTextField
{


	public JTextCep ()
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
        //JTextCep = new javax.swing.JFormattedTextField();
		
		try
        {
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMoedaActionPerformed(evt);
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTextCepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextCepFocusLost(evt);
            }
        });

        //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        /*layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(this, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(this)
        );*/
    }// </editor-fold>//GEN-END:initComponents

    private void jTextMoedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMoedaActionPerformed
        this.transferFocus();
    }//GEN-LAST:event_jTextMoedaActionPerformed
	
	 private void JTextCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusLost
        
    }//GEN-LAST:event_jTextMoedaFocusLost
	 
	 private void JTextCepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMoedaFocusGained
        if (this.getText().trim().compareTo("") != 0){
            this.selectAll();
        }
    }//GEN-LAST:event_jTextMoedaFocusGained
	 
	/*
	 * MÉTODOS DA CLASSE
	 */
	public Boolean buscaCep()
	{
		//Verifica se tem espaços em branco
		//Se tiver não foi preenchido completamente
		if(!this.getText().contains(" "))
		{
			try
			{
				controlCep = controlCep.searchCep(this.getText());
				//caso a busca ocorra bem, imprime os resultados.
				if (controlCep.wasSuccessful()) 
				{
					this.setEndereco(controlCep.getLogradouroFull());
					this.setBairro(controlCep.getBairro());
					this.setCidade(controlCep.getCidade());
					this.setEstado(controlCep.getUf());
					return true;
				} 
				//caso haja problemas imprime as exceções
				else 
				{
					 this.setText("");
					 JOptionPane.showMessageDialog(null, "CEP Não encontrado", "CEP Inválido",JOptionPane.INFORMATION_MESSAGE);
					 return false;
				}
			}
			catch(Exception e)
			{
				this.setText("");
				JOptionPane.showMessageDialog(null, "CEP Não encontrado", "CEP Inválido",JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		else
		{
			this.setText("");
			JOptionPane.showMessageDialog(null, "CEP inválido", "CEP Inválido",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	/*
	 * Getter e setter
	 */
	public String getEndereco ()
	{
		return endereco;
	}


	private void setEndereco (String endereco)
	{
		this.endereco = endereco;
	}


	public String getBairro ()
	{
		return bairro;
	}


	private void setBairro (String bairro)
	{
		this.bairro = bairro;
	}


	public String getCidade ()
	{
		return cidade;
	}


	private void setCidade (String cidade)
	{
		this.cidade = cidade;
	}


	public String getEstado ()
	{
		return estado;
	}


	private void setEstado (String estado)
	{
		this.estado = estado;
	}
	
	/*public void setCEP(String cep)
	{
		this.setText(cep);
	}
	
	public String getText()
	{
		return this.JTextCep.getText();
	}
	
	public void setText(String cep)
	{
		this.JTextCep.setText(cep);
	}
	
	public void setEnabled(Boolean habilita)
	{
		this.JTextCep.setEnabled(habilita);
	}*/

	//public	javax.swing.JFormattedTextField JTextCep;
	private WebServiceCep controlCep;
	public	String endereco	= new String();
	public	String bairro	= new String();
	public	String cidade	= new String();
	public	String estado	= new String();
}
