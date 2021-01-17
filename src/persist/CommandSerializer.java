package persist;

import command.KeyboardCommand;

import java.io.*;

/**
 * The type Command serializer.
 */
public class CommandSerializer {
    private final static String extension = ".txt";

    /**
     * Save.
     *
     * @param player          the player
     * @param keyboardCommand the keyboard command
     */
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

    /**
     * Load keyboard command.
     *
     * @param player the player
     * @return keyboard command
     */
    public static KeyboardCommand load(final String player){
        ObjectInputStream ois = null;
        KeyboardCommand keyboardCommand = null;
        try{
            final FileInputStream file = new FileInputStream(player + extension);
            ois = new ObjectInputStream(file);
            keyboardCommand = (KeyboardCommand) ois.readObject();
            keyboardCommand.initInput();
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

    /**
     * Is saved boolean.
     *
     * @param player the player
     * @return boolean boolean
     */
    public static Boolean isSaved(final String player){
        String fileName = player + extension;
        File f = new File(fileName);
        return f.exists();
    }
}
