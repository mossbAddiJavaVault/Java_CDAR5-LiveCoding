package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public boolean createFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            return false;
        }
        return file.createNewFile();
    }

    public boolean deleteFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
    }

    public void copyFile(String source, String destination) throws IOException {
        Path sourcePath = Paths.get(source);
        Path destPath = Paths.get(destination);
        Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public void moveFile(String source, String destination) throws IOException {
        Path sourcePath = Paths.get(source);
        Path destPath = Paths.get(destination);
        Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING); 
    }

    public List<String> listFiles(String directory) throws IOException {
        // Instancier une liste qui sera notre valeur de retour
        List<String> files = new ArrayList<>();
        // Récupérer le stream du dossier
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directory))) {
            // Parcourir le stream du dossier
            for (Path p : stream) {
                // Vérifier s'il s'agit d'un fichier
                if (Files.isRegularFile(p)) {
                    // Ajouter son chemin à ma liste de retour
                    files.add(p.toString());
                }
                
            }
        };



        // Retourner notre liste 
        return files;
    }

    public List<String> listDirectories(String directory) throws IOException {
        // Instancier une liste qui sera notre valeur de retour
        List<String> directories = new ArrayList<>();
        // Récupérer le stream du dossier
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directory))) {
            // Parcourir le stream du dossier
            for (Path p : stream) {
                // Vérifier s'il s'agit d'un fichier
                if (Files.isDirectory(p)) {
                    // Ajouter son chemin à ma liste de retour
                    directories.add(p.toString());
                }
                
            }
        };

        // Retourner notre liste 
        return directories;
    }

    public FileInfo getFileInfo(String path) throws IOException {
        Path filePath = Paths.get(path);
        BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
        return new FileInfo(
            path,
            attributes.size(),
            attributes.creationTime().toMillis(),
            attributes.lastModifiedTime().toMillis(),
            attributes.isDirectory());
    }

    public boolean createDirectory(String path) {
        File dir = new File(path);
        return dir.mkdirs();
    }


    public void deleteDirectory(String path) throws IOException {
        Path dirPath = Paths.get(path);
        Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
