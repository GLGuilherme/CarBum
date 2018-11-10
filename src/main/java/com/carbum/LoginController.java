package com.carbum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnSignin;
    public Label btnForgot;
    public Button btnFB;
    public Button btnSignup;
    public Label lblErrors;
    public AnchorPane rootPane;
    private ConexaoBanco conexao;
    private String sql;
    public static int idUsuario;

    public LoginController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void handleButtonAction(MouseEvent mouseEvent) {

    }

    public void validarLogin(){
        try {
            sql = "SELECT emaillogin, senha, idpessoa FROM pessoa WHERE emaillogin = ? AND senha = ?";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setString(1, txtUsername.getText());
            pstatement.setString(2, txtPassword.getText());
            ResultSet rs = pstatement.executeQuery();
            if (rs.next()){
                String email = rs.getString("emaillogin");
                idUsuario = rs.getInt("idpessoa");
                rootPane.getChildren().clear();
                try {
                    AnchorPane telaInicial = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TesteDashBoard.fxml"));
                    rootPane.getChildren().setAll(telaInicial);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                lblErrors.setText("Email ou senha inválido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Entrar(ActionEvent actionEvent) {
        validarLogin();
    }

    public void Cadastrar(ActionEvent actionEvent) {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaCadastroPessoa.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEnter(ActionEvent actionEvent) {
        validarLogin();
    }
}
