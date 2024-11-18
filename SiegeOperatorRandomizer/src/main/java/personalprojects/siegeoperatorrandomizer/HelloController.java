package personalprojects.siegeoperatorrandomizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {
    static Scene scene;
    static FXMLLoader fxmlLoader;
     profileAccess profileAccess;
    List<Operator> operators = new ArrayList<Operator>();
    List<Operator> attackers = new ArrayList<Operator>();
    List<Operator> defenders = new ArrayList<Operator>();
    List<String> bannedList = new ArrayList<String>();
    int sideActive = 0;
    int extraBans = 0;
    final int operatorAmount = 37;
    String[] operatorNames = {"ace", "alibi", "amaru", "aruni", "ash", "azami", "bandit", "blackbeard", "blitz", "brava", "buck", "capitao", "castle", "caveira", "clash", "deimos", "doc", "dokkaebi", "echo", "ela", "fenrir", "finka", "flores", "frost", "fuze", "glaz", "goyo", "gridlock", "grim", "hibana", "iana", "iq", "jackal", "jager", "kaid", "kali", "kapkan", "lesion", "lion", "maestro", "maverick", "melusi", "mira", "montagne", "mozzie", "mute", "nokk", "nomad", "oryx", "osa", "pulse", "ram", "rook", "sens", "sentry", "skopos", "sledge", "smoke", "solis", "striker", "tachanka", "thatcher", "thermite", "thorn", "thunderbird", "tubarao", "twitch", "valkyrie", "vigil", "wamai", "warden", "ying", "zero", "zofia"};
    @FXML
    private Button btnGenerate;
    Random rand = new Random();
    @FXML
    private Label OpName;
    @FXML
    private ImageView OpPicture;
    @FXML
    private ImageView OpLogo;
    @FXML
    private Label generatingSide;
    @FXML
    private ListView banList;
    @FXML
    private TextField banInput;
    @FXML
    private Button btnBanAdd;
    @FXML
    private Button btnProfileCreate;



    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 350, 450);
         profileAccess = fxmlLoader.getController();
    }

    @FXML
    private void generateOperator(ActionEvent actionEvent) {
        int randomNumber = rand.nextInt(operatorNames.length);
        boolean banned = false;
        boolean full = false;
        Operator tempOperator = null;

        if (operators.isEmpty())
        {
            tempOperator = createOperator(randomNumber);
            for (String bannedOperator : bannedList)
            {
                if(bannedOperator.equals(tempOperator.getName()))
                {

                    banned = true;
                    break;
                }
            }
            if(!banned) {
                if(tempOperator.getSide() == sideActive) {
                    addOperator(tempOperator);
                    setOperatorDisplay(tempOperator);
                }
                else
                {
                    banned = true;
                }
            }
        }
        else
        {
            if(sideActive == 0)
            {
                if(defenders.size() == 37)
                {
                    full = true;
                }
            }
            else if(sideActive == 1)
            {
                {
                    if(attackers.size() == 37)
                    {
                        full = true;
                    }
                }
            }
            if(!full) {
                tempOperator = createOperator(randomNumber);
                for (String operator : bannedList) {
                    if (operator.equals(tempOperator.getName())) {
                        banned = true;
                        break;
                    }
                }
                if (!banned) {
                    if (tempOperator.getSide() == sideActive) {
                        addOperator(tempOperator);
                        setOperatorDisplay(tempOperator);
                    } else {
                        banned = true;
                    }
                }
            }
            else
            {
                OpName.setText("All operators used");
            }
        }

        if(banned)
        {
            generateOperator(actionEvent);
        }
    }

    private Operator createOperator(int randomNumber) {
        return new Operator(operatorNames[randomNumber],
                "/images/" + operatorNames[randomNumber] + ".png", // /images/ace.png"
                "/images2/" + operatorNames[randomNumber] + "_icon.png",
                randomNumber);
    }

    private void addOperator(Operator operator) {
        bannedList.add(operator.getName());
        banList.getItems().add(operator.getName());
        operators.add(operator);
        addToSide(operator);
        setOperatorDisplay(operator);
    }

    private void setOperatorDisplay(Operator operator) {
        OpName.setText(operator.getName());
        Image image = new Image(getClass().getResourceAsStream(operator.getPicturePath()));
        Image image_logo = new Image(getClass().getResourceAsStream(operator.getLogoPath()));
        OpPicture.setImage(image);
        OpLogo.setImage(image_logo);
    }


    @FXML
    private void onSwitch(ActionEvent actionEvent) {
        if(sideActive == 0)
        {
            sideActive = 1;
            generatingSide.setText("Currently generating: Attackers");

        }
        else if (sideActive == 1)
        {
            sideActive = 0;
            generatingSide.setText("Currently generating: Defenders");
        }
    }

    private void addToSide(Operator operator)
    {
        if(operator.getSide() == 0)
        {
            defenders.add(operator);
        }
        else if(operator.getSide() == 1)
        {
            attackers.add(operator);
        }

    }

    @FXML
    private void onBanAdd(ActionEvent actionEvent) {
        String bannedOpName = banInput.getText();
        int operatorNumber = 0;
        Operator tempOperator = null;
        for(int i = 0; i < operatorNames.length; i++)
        {
            if(operatorNames[i].equals(bannedOpName))
            {
                operatorNumber = i;
                break;
            }
        }
        tempOperator = createOperator(operatorNumber);
        addOperator(tempOperator);

    }

    @FXML
    private void onBanReset(ActionEvent actionEvent) {
        attackers.clear();
        defenders.clear();
        operators.clear();
        bannedList.clear();
        banList.getItems().clear();
    }

    @FXML
    private void onProfileCreate(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setTitle("The Best History");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void onReroll(ActionEvent actionEvent) {
        bannedList.remove(bannedList.size() - 1);
        Operator tempOperator = operators.get(operators.size() - 1);
        operators.remove(operators.size() - 1);
        if(tempOperator.getSide() == 0)
        {
            defenders.remove(defenders.size() - 1);
        }
        else
        {
            attackers.remove(attackers.size() - 1);
        }
        banList.getItems().remove(banList.getItems().size() - 1);
        generateOperator(actionEvent);


    }
}
