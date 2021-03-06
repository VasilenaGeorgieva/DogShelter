package Pack1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Worker {
    private int id;
    private String name;
    private ArrayList<Dog> assignedDogsID;

    public Worker(String name, ArrayList<Dog> assignedDogsID) {
        this.id = idInitialization();
        this.name = name;
        this.assignedDogsID = assignedDogsID;
    }

    private void assignDog(Dog dogToAdd, Worker workerToAcceptTheDog) {
        assignedDogsID.add(dogToAdd);
        dogToAdd.setWorkerID(workerToAcceptTheDog.id);
    }

    private void removeAssignedDog(Dog dogToRemove) {
        assignedDogsID.remove(dogToRemove);
        dogToRemove.setWorkerID(0);
    }

    private int idInitialization() {

        Random random = new Random();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

        LocalDateTime today = LocalDateTime.now();

        String[] todayisTheDay = today.format(formatter).split("/");

        String finalId = "";

        for (int i = 0; i < todayisTheDay.length; i++) {
            finalId += todayisTheDay[i];
        }

        for (int i = 0; i < 4; i++) {
            finalId += random.nextInt(9);
        }

        try {
            //return Integer.parseInt(finalId);
            //System.out.println(finalId);// here is the id
            return Integer.parseInt(finalId);
        } catch (NumberFormatException e) {
            System.out.println("Error!");
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Dog> getAssignedDogsID() {
        return assignedDogsID;
    }

    public void setAssignedDogsID(ArrayList<Dog> assignedDogsID) {
        this.assignedDogsID = assignedDogsID;
    }
}
