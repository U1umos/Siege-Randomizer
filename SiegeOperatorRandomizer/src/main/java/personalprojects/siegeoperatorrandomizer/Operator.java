package personalprojects.siegeoperatorrandomizer;

public class Operator {
    private String name;
    private String picturePath;
    private String logoPath;
    private int opNumber;
    private int side = 0;

    public Operator(String name, String picturePath, String logoPath, int opNumber) {
        this.name = name;
        this.picturePath = picturePath;
        this.logoPath = logoPath;
        this.opNumber = opNumber;

        switch(name)
        {
            case "ace":
                this.side = 1;
                break;
            case "alibi":
                this.side = 0;
                break;
            case "amaru":
                this.side = 1;
                break;
            case "aruni":
                this.side = 0;
                break;
            case "ash":
                this.side = 1;
                break;
            case "azami":
                this.side = 0;
                break;
            case "bandit":
                this.side = 0;
                break;
            case "blackbeard":
                this.side = 1;
                break;
            case "blitz":
                this.side = 1;
                break;
            case "brava":
                this.side = 1;
                break;
            case "buck":
                this.side = 1;
                break;
            case "capitao":
                this.side = 1;
                break;
            case "castle":
                this.side = 0;
                break;
            case "caveira":
                this.side = 0;
                break;
            case "clash":
                this.side = 0;
                break;
            case "deimos":
                this.side = 1;
                break;
            case "doc":
                this.side = 0;
                break;
            case "dokkaebi":
                this.side = 1;
                break;
            case "echo":
                this.side = 0;
                break;
            case "ela":
                this.side = 0;
                break;
            case "fenrir":
                this.side = 0;
                break;
            case "finka":
                this.side = 1;
                break;
            case "flores":
                this.side = 1;
                break;
            case "frost":
                this.side = 0;
                break;
            case "fuze":
                this.side = 1;
                break;
            case "glaz":
                this.side = 1;
                break;
            case "goyo":
                this.side = 0;
                break;
            case "gridlock":
                this.side = 1;
                break;
            case "grim":
                this.side = 1;
                break;
            case "hibana":
                this.side = 1;
                break;
            case "iana":
                this.side = 1;
                break;
            case "iq":
                this.side = 1;
                break;
            case "jackal":
                this.side = 1;
                break;
            case "jager":
                this.side = 0;
                break;
            case "kaid":
                this.side = 0;
                break;
            case "kali":
                this.side = 1;
                break;
            case "kapkan":
                this.side = 0;
                break;
            case "lesion":
                this.side = 0;
                break;
            case "lion":
                this.side = 1;
                break;
            case "maestro":
                this.side = 0;
                break;
            case "maverick":
                this.side = 1;
                break;
            case "melusi":
                this.side = 0;
                break;
            case "mira":
                this.side = 0;
                break;
            case "montagne":
                this.side = 1;
                break;
            case "mozzie":
                this.side = 0;
                break;
            case "mute":
                this.side = 0;
                break;
            case "nokk":
                this.side = 1;
                break;
            case "nomad":
                this.side = 1;
                break;
            case "oryx":
                this.side = 0;
                break;
            case "osa":
                this.side = 1;
                break;
            case "pulse":
                this.side = 0;
                break;
            case "ram":
                this.side = 1;
                break;
            case "rook":
                this.side = 0;
                break;
            case "sens":
                this.side = 1;
                break;
            case "sentry":
                this.side = 0;
                break;
            case "skopos":
                this.side = 0;
                break;
            case "sledge":
                this.side = 1;
                break;
            case "smoke":
                this.side = 0;
                break;
            case "solis":
                this.side = 0;
                break;
            case "striker":
                this.side = 1;
                break;
            case "tachanka":
                this.side = 0;
                break;
            case "thatcher":
                this.side = 1;
                break;
            case "thermite":
                this.side = 1;
                break;
            case "thorn":
                this.side = 0;
                break;
            case "thunderbird":
                this.side = 0;
                break;
            case "tubarao":
                this.side = 0;
                break;
            case "twitch":
                this.side = 1;
                break;
            case "valkyrie":
                this.side = 0;
                break;
            case "vigil":
                this.side = 0;
                break;
            case "wamai":
                this.side = 0;
                break;
            case "warden":
                this.side = 0;
                break;
            case "ying":
                this.side = 1;
                break;
            case "zero":
                this.side = 1;
                break;
            case "zofia":
                this.side = 1;
                break;




        }
    }
    public String getName() {
        return name;
    }
    public String getPicturePath() {
        return picturePath;
    }
    public String getLogoPath() {
        return logoPath;
    }
    public int getOpNumber() {
        return opNumber;
    }
    public int getSide() {
        return side;
    }

}
