package com.NetChat.client;



import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

// Добавлю действие на закрытие окна
// Добавление изменение размера техтАреа
// ИБ навалить
public class Controller implements Initializable {
    public TextArea textArea;
    public TextField textField;

    public TextField loginField;
    public PasswordField passField;
    public ListView clientsList;
    public ObservableList<String> observClients;
    public HBox bottomPanel;
    public HBox upperPanel;

    public String myNick="";

    private boolean authorized;

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
        if (!this.authorized) {

            upperPanel.setManaged(true);
            bottomPanel.setManaged(false);
            upperPanel.setVisible(true);
            bottomPanel.setVisible(false);
            // еще листь на пмы  типо открытые чаты с их историей,
            // а еще по клику на ник сразу в чат добавлялась запись в пм

            clientsList.setVisible(false);
            clientsList.setManaged(false);
        } else {
            upperPanel.setManaged(false);
            bottomPanel.setManaged(true);
            upperPanel.setVisible(false);
            bottomPanel.setVisible(true);
            clientsList.setVisible(true);
            clientsList.setManaged(true);
            textArea.clear();
            textArea.requestFocus();

        }

    }

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
// переделать поток
    // сделать логирование !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAuthorized(false);
    }





    public void start(){
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            setAuthorized(false);

            observClients = FXCollections.observableArrayList();
            clientsList.setItems(observClients);

            Thread t = new Thread(() -> {
                try {
                    while (true) {//авторизация , переделать

                        String str = in.readUTF();
                        if(str.startsWith("/authok")) {
                            myNick=str.split(" ")[1];
                                textField.requestFocus();
                            setAuthorized(true);
                            break;
                        }
                        textArea.appendText(str + "\n");
                    }
                    while (true) {//  служеб комнады(swith потснуть)
                        String str = in.readUTF();
                        if (str.startsWith("/")) {
                            if (str.equals("/help") ) {
                                //допилить
                                showAlert("/chnick /end ... ");
                            }
                            if (str.startsWith("/chnick")) {
                                myNick=str.split(" ")[1];}

                            if (str.equals("/end") ) {
                                break;
                            }

                        }
                        if (str.startsWith("/clients")){
                            String[]s =str.split("\\s");
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    observClients.clear();
                                    for (int i = 1; i <s.length ; i++) {

                                        clientsList.getItems().add(s[i]);
                                    }
                                }
                            });



                        }
                        else {
                            textArea.appendText(str + "\n");}


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setAuthorized(false);
                }
            });

            t.start();
        } catch (IOException e) {
            showAlert("ой,чёт не так");
            Platform.exit();
        }
    }

    public void onSendMsg() {
        try {
            out.writeUTF(textField.getText());
            if (textField.getText().equals("/end")) {
                socket.close();
            }
            if (out.equals("/help") ) {
                //допилить
                showAlert("/chnick /end ... ");
            }
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            showAlert("чёт не так с сетью видимо");
            e.printStackTrace();
        }
    }



    public void  closeconnect(){

        try {

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("ну тут хз чо не так");
        }
    }

    public void showAlert(String f) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Header");
        alert.setContentText(f);
        alert.setTitle("title");
        alert.showAndWait();

    }

    public void onAuthClick() {
        if (socket==null||socket.isClosed()){
            start();}

        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
            loginField.clear();
            passField.clear();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pmListClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2){
            textField.setText("/w"+ clientsList.getSelectionModel().getSelectedItems().toString()+" ");
            textField.requestFocus();
            textField.selectEnd();

        }

    }

    public void listClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2){
            textField.setText("/w"+ clientsList.getSelectionModel().getSelectedItems().toString()+" ");
            textField.requestFocus();
            textField.selectEnd();

        }

    }
}

