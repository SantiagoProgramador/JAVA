import javax.swing.*;
import java.util.ArrayList;

public class musicList {
    public static void main(String[] args) {
        ArrayList<String> playList = new ArrayList<>();

        int option = 0;
        int actualSong = 0;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                        Type a number according to the following options.
                        1. Add song.
                        2. Remove song.
                        3. Show actual song and next's in the list.
                        4. Skip song.
                        5. EXIT.
                        """));

                switch (option){
                    case 1:
                        String newSong = JOptionPane.showInputDialog("Write the name of your song.");
                        if (newSong.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Type a valid song");
                            break;
                        }
                        playList.add(newSong.toLowerCase());

                        JOptionPane.showMessageDialog(null,newSong + " Has been added correctly!");
                        break;
                    case 2:
                        String removeSong = JOptionPane.showInputDialog("Write the name of the song you want to remove from your playlist.");
                        if (playList.remove(removeSong.toLowerCase())){
                            JOptionPane.showMessageDialog(null,removeSong + " removed successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null,"The song is not in the playList.");
                        }
                        break;
                    case 3:
                        if(playList.isEmpty()){
                            JOptionPane.showMessageDialog(null,"The playlist is empty.");
                        } else {
                            String totalList = "";
                            totalList += "Actual song: " + playList.get(actualSong)+"\n" + "Next songs:\n";
                            for (int i = actualSong; i < playList.size() -1; i++){
                                 totalList +=  playList.get(i+1) + "\n";
                            }
                            JOptionPane.showMessageDialog(null,totalList);
                        }
                        break;
                    case 4:
                        if (actualSong + 1 < playList.size()){
                            actualSong++;
                            JOptionPane.showMessageDialog(null,playList.get(actualSong) + " Reproduced successfully!");

                        } else {
                            JOptionPane.showMessageDialog(null,"Playlist ended!");
                            actualSong = 0;
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,"Thanks for using your playListApp!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please enter a number between 1 and 5.");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Please enter a valid option" + e);
            }
        }while (option != 5);

    }
}
