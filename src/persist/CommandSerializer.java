package persist;

import command.KeyboardCommand;

import java.io.*;

public class CommandSerializer {
    private final static String extension = ".ser";

    public static void save(final String player, KeyboardCommand keyboardCommand){

        ObjectOutputStream oos = null;
        try{
            final FileOutputStream file = new FileOutputStream(player + extension);
            oos = new ObjectOutputStream(file);
            oos.writeObject(keyboardCommand);
            oos.flush();
        } catch (final IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static KeyboardCommand load(final String player){
        ObjectInputStream ois = null;
        KeyboardCommand keyboardCommand = null;
        try{
            final FileInputStream file = new FileInputStream(player + extension);
            ois = new ObjectInputStream(file);
            keyboardCommand = (KeyboardCommand) ois.readObject();
        } catch (final IOException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex){
                ex.printStackTrace();
            }
        }
        return keyboardCommand;
    }

    public static Boolean isSaved(final String player){
        String fileName = player + extension;

        return false;
    }
}
