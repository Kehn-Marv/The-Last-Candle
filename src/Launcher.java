import java.io.*;
import java.nio.file.*;
import java.util.jar.*;
import java.util.Enumeration;

public class Launcher {
    
    public static void main(String[] args) {
        try {
            // Get the directory where the JAR is located
            String jarPath = Launcher.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File jarFile = new File(jarPath);
            String gameDir = jarFile.getParent();
            
            // Check if resources need to be extracted
            File resDir = new File(gameDir, "res");
            if (!resDir.exists()) {
                System.out.println("Extracting game resources...");
                extractResources(jarFile, gameDir);
                System.out.println("Resources extracted successfully!");
            }
            
            // Set working directory
            System.setProperty("user.dir", gameDir);
            
            // Launch the main game
            System.out.println("Starting The Last Candle...");
            Boilerplate.MainApplication.main(args);
            
        } catch (Exception e) {
            System.err.println("Error starting game: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private static void extractResources(File jarFile, String destDir) throws IOException {
        JarFile jar = new JarFile(jarFile);
        Enumeration<JarEntry> entries = jar.entries();
        
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            
            // Only extract res/ folder
            if (name.startsWith("res/")) {
                File destFile = new File(destDir, name);
                
                if (entry.isDirectory()) {
                    destFile.mkdirs();
                } else {
                    // Create parent directories
                    destFile.getParentFile().mkdirs();
                    
                    // Extract file
                    try (InputStream in = jar.getInputStream(entry);
                         FileOutputStream out = new FileOutputStream(destFile)) {
                        byte[] buffer = new byte[8192];
                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        }
        jar.close();
    }
}
