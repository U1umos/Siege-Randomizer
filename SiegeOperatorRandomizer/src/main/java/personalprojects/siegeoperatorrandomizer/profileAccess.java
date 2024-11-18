package personalprojects.siegeoperatorrandomizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class profileAccess {
    File users;
    ArrayList<String> usersList = new ArrayList<>();
    private Map<String, ArrayList<String>> usersMap = new HashMap<>();
    ArrayList<String> tempList = new ArrayList<>();

    public void initialize() throws IOException {
        users = new File("users.txt");

        if (users.createNewFile()) {
            System.out.println("File created: " + users.getName());
        } else {
            System.out.println("File already exists: " + users.getName());
        }

        Scanner usersScanner = new Scanner(users);
        while (usersScanner.hasNextLine()) {
            usersList.add(usersScanner.nextLine());
        }
        usersScanner.close();
        createUserFiles();

    }

    public void createUserFiles() throws IOException {
        for(String username : usersList)
        {

            File user = new File(username + ".txt");
            tempList.clear();
            if(user.createNewFile())
            {
                System.out.println("File created: " + user.getName());
            }
            else
            {
                System.out.println("File already exists: " + user.getName());
            }

            Scanner scanner = new Scanner(user);
            while (scanner.hasNextLine()) {
                tempList.add(scanner.nextLine());
            }
            scanner.close();
            usersMap.put(username, new ArrayList<>());
        }
    }

}