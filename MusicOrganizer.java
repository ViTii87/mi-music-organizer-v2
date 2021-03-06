import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * Metodo para listar todos archivos de nuestra coleccion
     */
    public void listAllFiles(){
        int posicionArchivo;
        posicionArchivo = 1;
        for(String nombreArchivo : files){
            System.out.println(posicionArchivo + ". " + nombreArchivo);
            posicionArchivo += 1;
        }
    }
    
    /**
     * Metodo para imprimir por pantalla los archivos que coincidan con la cadena introducida por parametro.
     */
    public void listMatching(String textoABuscar){
        boolean loHeEncontrado = false;
        for(String nombreArchivo : files){
            if(nombreArchivo.contains(textoABuscar)){
                System.out.println(nombreArchivo);
                loHeEncontrado = true;
            }
        }
        if(!loHeEncontrado){
            System.out.println("No se ha encontrado ninguna cancion con ese nombre.");
        }
    }
    
    /**
     * Metodo para reproducir los primeros segundos de las canciones de ese artista
     */
    public void reproducePrimerosSegundos(String nombreArtista){
        for(String nombreArchivo : files){
            if(nombreArchivo.contains(nombreArtista)){
                player.playSample(nombreArchivo);
            }
        }
    }
    
    /**
     * Metodo que nos devolvera la posicion del primer elemento encontrado pasado por parametro
     */
    public int findFirst(String textoABuscar){
        boolean found = false;
        int index = 0;
        int tamanhoColeccion = files.size();
        
        while (!found && index < tamanhoColeccion){
            if(files.get(index).contains(textoABuscar)){
                found = true;
            }
            else{
                index += 1;
            }
        }
        if(!found){
            index = -1;
        }
        return index;
    }
}
