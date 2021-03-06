package it.polimi.ingsw.client.gui;

import com.jfoenix.controls.JFXSpinner;
import it.polimi.ingsw.client.ClientInformation;
import it.polimi.ingsw.client.gui.notify.BonusTileChoiceNotifier;
import it.polimi.ingsw.client.middleware.ClientSender;
import it.polimi.ingsw.client.middleware.ClientSenderHandler;
import it.polimi.ingsw.shared.model.GeneralColor;
import it.polimi.ingsw.shared.requests.clientserver.BaseInformation;
import it.polimi.ingsw.shared.requests.clientserver.ChosenBonusTile;
import it.polimi.ingsw.shared.requests.clientserver.Ready;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages the choice of the Bonus Tile at the beginning of the game, the player clicks on the one he wants, then the
 * choice goes to the next player, while waiting for his turn to choose there's a waiting message
 */


public class TileChoiceController implements Observer {
    private static final Logger LOGGER = Logger.getLogger(TileChoiceController.class.getName());
    private static final String BACKGROUND_URL = "/client/backgrounds/";

    private BaseInformation baseInformation;
    private List<ImageView> tileList;
    private List<String> bonusTileIdentifiers;
    private Map<GeneralColor, String> backgrounds;

    @FXML
    private ImageView tile1;
    @FXML
    private ImageView tile2;
    @FXML
    private ImageView tile3;
    @FXML
    private ImageView tile4;

    @FXML
    private JFXSpinner spinner;

    @FXML
    private Label waiting;
    @FXML
    private Label namePlayer;

    @FXML
    private AnchorPane root;

    public TileChoiceController() {
        baseInformation = new BaseInformation(ClientInformation.getCurrentGameId(), ClientInformation.getPlayerName());
        tileList = new ArrayList<>();
        bonusTileIdentifiers = new ArrayList<>();
        backgrounds = new EnumMap<>(GeneralColor.class);
    }

    public void initialize() {
        BonusTileChoiceNotifier.getInstance().addObserver(this);
        initEnumMap();
        setTileList();

        setBackground();
        setPlayerName();
        ClientSender clientSender = new ClientSenderHandler();
        clientSender.sendToServer(new Ready(ClientInformation.getCurrentGameId(), "tileChoice"));
    }

    private void initEnumMap() {
        backgrounds.put(GeneralColor.GREEN, BACKGROUND_URL + "green.jpg");
        backgrounds.put(GeneralColor.BLUE, BACKGROUND_URL + "blue.jpg");
        backgrounds.put(GeneralColor.YELLOW, BACKGROUND_URL + "yellow.jpg");
        backgrounds.put(GeneralColor.PURPLE, BACKGROUND_URL + "red.jpg");
    }

    private void setTileList() {
        tileList.add(tile1);
        tileList.add(tile2);
        tileList.add(tile3);
        tileList.add(tile4);
    }

    private void setBackground() {
        root.setBackground(new Background(new BackgroundImage(
                new Image(backgrounds.get(ClientInformation.getPlayerColor())),
                null,null, null, new BackgroundSize(
                        BackgroundSize.AUTO, BackgroundSize.AUTO,
                false, false, true, true))));
    }

    @Override
    public void update(Observable o, Object arg) {
        hideWaiting();
        if (arg != null) {
            setTiles((List<String>)arg);
        } else {
            startGameBoard();
        }
    }

    private void hideWaiting() {
        waiting.setVisible(false);
        spinner.setVisible(false);
    }

    private void showWaiting() {
        waiting.setVisible(true);
        spinner.setVisible(true);
    }


    private void setTiles(List<String> availableTiles) {
        bonusTileIdentifiers = new ArrayList<>(availableTiles);
        for (int i = 0; i < availableTiles.size(); i++) {
            Image newTile = new Image("client/bonustiles/"  + availableTiles.get(i) +  ".png");
            tileList.get(i).setImage(newTile);
        }
    }

    private void startGameBoard() {
        Platform.runLater(() ->  {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/client/gui/gameboard.fxml"));
                Parent root = fxmlLoader.load();
                Stage gameBoardStage = new Stage();
                gameBoardStage.setScene(new Scene(root));
                gameBoardStage.show();
                closeStage();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An exception was thrown: cannot launch player tiles board", e);
            }
        });
    }

    public void closeStage() {
        Stage stage = (Stage)root.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void selectTile1() {
        ClientSender clientSender = new ClientSenderHandler();
        clientSender.sendToServer(new ChosenBonusTile(baseInformation, bonusTileIdentifiers.get(0)));
        disable();
        hideBonusTiles();
        showWaiting();
    }

    @FXML
    public void selectTile2() {
        ClientSender clientSender = new ClientSenderHandler();
        clientSender.sendToServer(new ChosenBonusTile(baseInformation, bonusTileIdentifiers.get(1)));
        disable();
        hideBonusTiles();
        showWaiting();
    }

    @FXML
    public void selectTile3() {
        ClientSender clientSender = new ClientSenderHandler();
        clientSender.sendToServer(new ChosenBonusTile(baseInformation, bonusTileIdentifiers.get(2)));
        disable();
        hideBonusTiles();
        showWaiting();
    }

    @FXML
    public void selectTile4() {
        ClientSender clientSender = new ClientSenderHandler();
        clientSender.sendToServer(new ChosenBonusTile(baseInformation, bonusTileIdentifiers.get(3)));
        disable();
        hideBonusTiles();
        showWaiting();
    }

    public void setPlayerName() {
        namePlayer.setText(ClientInformation.getPlayerName());
        namePlayer.prefWidth(namePlayer.getText().length());
    }

    public void disable() {
        for (ImageView image : tileList) {
                image.setMouseTransparent(true);
        }
    }

    public void hideBonusTiles() {
        for (ImageView imageView : tileList) {
            imageView.setVisible(false);
        }
    }
}