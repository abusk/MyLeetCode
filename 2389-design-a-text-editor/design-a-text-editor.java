// class Node {
//     Node prev;
//     Node next;
//     char ch;
//     public Node(char ch) {
//         this.prev = null;
//         this.next = null;
//         this.ch = ch;
//     }
// }
// class TextEditor {
    
//     public TextEditor() {
        
//     }
    
//     public void addText(String text) {
        
//     }
    
//     public int deleteText(int k) {
        
//     }
    
//     public String cursorLeft(int k) {
        
//     }
    
//     public String cursorRight(int k) {
        
//     }
// }

// /**
//  * Your TextEditor object will be instantiated and called as such:
//  * TextEditor obj = new TextEditor();
//  * obj.addText(text);
//  * int param_2 = obj.deleteText(k);
//  * String param_3 = obj.cursorLeft(k);
//  * String param_4 = obj.cursorRight(k);
//  */

class TextEditor {
    StringBuilder res;
    int pos=0;
    
    public TextEditor() {
        res = new StringBuilder();
    }
    
    public void addText(String text) {
        res.insert(pos,text);
        pos += text.length();
    }
    
    public int deleteText(int k) {
        int tmp = pos;
        pos -= k;
        if(pos<0) pos=0;
        res.delete(pos,tmp);
        return tmp-pos;
    }
    
    public String cursorLeft(int k) {
        pos-=k;
        if(pos<0) pos = 0;
        if(pos<10) return res.substring(0,pos);
        return res.substring(pos-10,pos);
    }
    
    public String cursorRight(int k) {
        pos+=k;
        if(pos>res.length()) pos = res.length();
        if(pos<10) return res.substring(0,pos);
        return res.substring(pos-10,pos);
    }
}