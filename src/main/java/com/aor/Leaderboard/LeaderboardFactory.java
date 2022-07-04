package com.aor.Leaderboard;

import java.io.*;
import java.util.ArrayList;

public class LeaderboardFactory {
    private String fileName;
    public LeaderboardFactory(String fileName){
        this.fileName = fileName;
        try
        {
            File tempFile = new File(fileName);
            if(tempFile.exists())
                    return;
            else{
                tempFile.createNewFile();
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write("PlayerName,Time");
                myWriter.close();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    public ArrayList<LeaderboardObject> getLeaderboardsList(){
        ArrayList<LeaderboardObject> l = new ArrayList<LeaderboardObject>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(",");
                LeaderboardObject l2 = new LeaderboardObject(parts[0].toString(),Integer.parseInt(parts[1].toString()));
                l.add(l2);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        l.sort(new LeadComparator());
        return l;
    }
    private boolean notinLeaderboard(ArrayList<LeaderboardObject> leaderboard,LeaderboardObject leaderboardObject){
        for(LeaderboardObject sus:leaderboard){
            if(leaderboard.equals(leaderboardObject)){
                return false;
            }
        }
        return true;
    }
    public void updateLeaderboardFile(LeaderboardObject leaderboardObject) throws IOException {
        ArrayList<LeaderboardObject> leaderboard = getLeaderboardsList();
        if(notinLeaderboard(leaderboard,leaderboardObject)){
            leaderboard.add(leaderboardObject);
        }
        leaderboard.sort(new LeadComparator());
        PrintWriter erasor = new PrintWriter(fileName);
        erasor.close();
        FileWriter myWriter = new FileWriter(fileName);
        myWriter.write("PlayerName,Time");
        for(LeaderboardObject l1 : leaderboard){
            Integer time = l1.getTime();
            String name = l1.getName();
            myWriter.write("\n" +name + "," + time.toString());
        }
        myWriter.close();
    }

}
