// class FileNode {
//     private FileNode parent;
//     private String path;
//     private boolean isFile;
//     private String content;
//     private Map<String, FileNode> subDirectories;
//     public FileNode(String path, boolean isFile, FileNode parent) {
//         this.path = path;
//         this.isFile = isFile;
//         this.parent = parent;
//         this.subDirectories = new HashMap<>();
//     }
//     public void addNewNode(String name, FileNode node) {
//         subDirectories.put(name, node);
//     }
//     public void deleteNoe(String name) {
//         subDirectories.remove(name);
//     }
//         public FileNode getParent() {
//         return parent;
//     }

//     public void setParent(FileNode parent) {
//         this.parent = parent;
//     }

//     public String getPath() {
//         return path;
//     }

//     public void setPath(String path) {
//         this.path = path;
//     }

//     public boolean isFile() {
//         return isFile;
//     }

//     public void setFile(boolean file) {
//         isFile = file;
//     }

//     public String getContent() {
//         return content;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public Map<String, FileNode> getSubDirectories() {
//         return subDirectories;
//     }

//     public void setSubDirectories(Map<String, FileNode> subDirectories) {
//         this.subDirectories = subDirectories;
//     }
// }

// class FileSystem {
//     public static FileNode currentFileNode;
//     public static FileNode root;
    
//     public FileSystem() {
//         root = new FileNode("/", false, null);
//         currentFileNode = root;
//     }
    
//     public List<String> ls(String path) {
//                 FileNode next = root;
//         String[] files = path.trim().split("/");
//         if(files.length == 0) {
//             return new ArrayList<>(root.getSubDirectories().keySet());
//         }
//         for (int i = 1; i< files.length; i++) {
//             next = next.getSubDirectories().get(files[i]);
//         }
//         currentFileNode = next;
//         return new ArrayList<>(currentFileNode.getSubDirectories().keySet());
//     }
    
//     public void mkdir(String path) {
//         FileNode next = root;
//         FileNode prv;
//         String[] files = path.trim().split("/");
//         for(int i = 1; i< files.length; i++) {
//             prv = next;
//             next = next.getSubDirectories().get(files[i]);
//             if(next == null) {
//                 FileNode newNode = new FileNode(prv.getPath() + "/" + files[i], false, prv);
//                 prv.addNewNode(files[i], newNode);
//                 next = newNode;
//             }
//         }
//     }
    
//     public void addContentToFile(String filePath, String content) {
//         FileNode next = root;
//         FileNode prv = root;
//         String[] files = filePath.trim().split("/");
//         for(int i = 1; i< files.length; i++) {
//             prv = next;
//             next = next.getSubDirectories().get(files[i]);
//             if(next == null) {
//                 FileNode newNode = new FileNode(prv.getPath() + "/" + files[i], false, prv);
//                 prv.addNewNode(files[i], newNode);
//                 next = newNode;
//             }
//         }
//         if(prv.getSubDirectories().containsKey(files[files.length-1])) {
//            FileNode updateNode = prv.getSubDirectories().get(files[files.length-1]);
//             String uContent = updateNode.getContent() + content;
//             updateNode.setContent(uContent);
//             prv.getSubDirectories().put(files[files.length-1], updateNode);
            
//         } else {
//             FileNode fileNode = new FileNode(prv.getPath() + "/" + files[files.length-1], true, prv);
//             fileNode.setContent(content);
//             prv.addNewNode(files[files.length-1], fileNode);
//         }
//     }
    
//     public String readContentFromFile(String filePath) {
//         FileNode next = root;
//         String[] files = filePath.trim().split("/");
//         for (int i = 1; i< files.length; i++) {
//             next = next.getSubDirectories().get(files[i]);
//         }
//         if (next.isFile()){
//             return next.getContent();
//         }
//         return null;
//     }
// }

// /**
//  * Your FileSystem object will be instantiated and called as such:
//  * FileSystem obj = new FileSystem();
//  * List<String> param_1 = obj.ls(path);
//  * obj.mkdir(path);
//  * obj.addContentToFile(filePath,content);
//  * String param_4 = obj.readContentFromFile(filePath);
//  */

public class FileSystem {
    class File {
        boolean isfile = false;
        HashMap < String, File > files = new HashMap < > ();
        String content = "";
    }
    File root;
    public FileSystem() {
        root = new File();
    }

    public List < String > ls(String path) {
        File t = root;
        List < String > files = new ArrayList < > ();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.files.get(d[i]);
            }
            if (t.isfile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List < String > res_files = new ArrayList < > (t.files.keySet());
        Collections.sort(res_files);
        return res_files;
    }

    public void mkdir(String path) {
        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.files.containsKey(d[i]))
                t.files.put(d[i], new File());
            t = t.files.get(d[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        if (!t.files.containsKey(d[d.length - 1]))
            t.files.put(d[d.length - 1], new File());
        t = t.files.get(d[d.length - 1]);
        t.isfile = true;
        t.content = t.content + content;
    }

    public String readContentFromFile(String filePath) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        return t.files.get(d[d.length - 1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

