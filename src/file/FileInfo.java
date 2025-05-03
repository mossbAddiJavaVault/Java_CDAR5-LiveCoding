package file;

public class FileInfo {
   private final String path;
   private final long size; 
   private final long creationTime; 
   private final long lastModifiedTime;
   private final boolean isDirectory;

    public FileInfo(String path, long size, long creationTime, long lastModifiedTime, boolean isDirectory) {
        this.path = path;
        this.size = size;
        this.creationTime = creationTime;
        this.lastModifiedTime = lastModifiedTime;
        this.isDirectory = isDirectory;
    }

   
    public String getPath() {
        return path;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "path='" + path + "'" +
                ", size=" + size +
                ", creationTime=" + creationTime + 
                ", lastModifiedTime=" + lastModifiedTime + 
                ", isDirectory=" + isDirectory +
                "}";
    }
}
