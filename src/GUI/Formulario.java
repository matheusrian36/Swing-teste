package GUI;

import Bean.FormularioBean;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame{
    private JTextField textFieldNome;
    private JTextField textFieldTelefone;
    private JTextField textFieldEndereco;
    private JTextField textFieldCidade;
    private JTextField textFieldEmail;
    private JComboBox estadoBox;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JRadioButton outroRadioButton;
    private JCheckBox alemaoCheckBox;
    private JCheckBox espanholCheckBox1;
    private JCheckBox francesCheckBox1;
    private JCheckBox inglesCheckBox1;
    private JCheckBox italianoCheckBox;
    private JCheckBox japonesCheckBox;
    private JTextArea textAreaMotivo;
    private JButton salvarButton;
    private JPanel mainPanel;
    private ButtonGroup buttonGroup1;

    public Formulario(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioBean bean = new FormularioBean();

                bean.setNome(textFieldNome.getText());
                bean.setTelefone(textFieldTelefone.getText());
                bean.setEndereco(textFieldEndereco.getText());
                bean.setCidade(textFieldCidade.getText());
                bean.setEmail(textFieldEmail.getText());
                bean.setMotivo(textAreaMotivo.getText());

                bean.setEstado((String) estadoBox.getSelectedItem());

                if(masculinoRadioButton.isSelected()){
                    bean.setGenero("Masculino");
                }
                else if(femininoRadioButton.isSelected()){
                    bean.setGenero("Feminino");
                }
                else{
                    bean.setGenero("Outro");
                }

                if(alemaoCheckBox.isSelected()) bean.setAlemao(true);
                if(espanholCheckBox1.isSelected()) bean.setEspanhol(true);
                if(francesCheckBox1.isSelected()) bean.setFrances(true);
                if(inglesCheckBox1.isSelected()) bean.setIngles(true);
                if(italianoCheckBox.isSelected()) bean.setItaliano(true);
                if(japonesCheckBox.isSelected()) bean.setJapones(true);

                limpar();

                JOptionPane.showMessageDialog(null, "O Cadastro foi Salvo!");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new Formulario("Cadastro de Cursos");
        frame.setVisible(true);
    }

    public void limpar(){
        textFieldCidade.setText("");
        textFieldEmail.setText("");
        textFieldEndereco.setText("");
        textFieldNome.setText("");
        textFieldTelefone.setText("");
        textAreaMotivo.setText("");

        espanholCheckBox1.setSelected(false);
        alemaoCheckBox.setSelected(false);
        francesCheckBox1.setSelected(false);
        inglesCheckBox1.setSelected(false);
        italianoCheckBox.setSelected(false);
        japonesCheckBox.setSelected(false);

        buttonGroup1.clearSelection();

        estadoBox.setSelectedIndex(-1);
    }
}
