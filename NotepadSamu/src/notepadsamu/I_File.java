package notepadsamu;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;


public interface I_File {
    
    
    void print();
    String getText();
    void setText(String text);
    void appendText(String text);
    void clear();
    void addLine(String line);
    void addLines(List<String>list);
    List<String>getLines();
    List<String>getLines(String filter);
    List<String>getOrderedLines();
    List<String>getOrderedRevesedLines();
    LinkedHashSet<String>getLinkedHashSet();
    TreeSet<String>getTreeSet();
    void removeLine(String line);
}