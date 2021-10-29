package notepadsamu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;



public class FileText1 implements I_File{
    
    
    private File file;
    
    
    public FileText1(File file)      { this.file = file;             }
    public FileText1(String file)    { this.file = new File(file);   }
    
    
    
    @Override public void print() {
        
        
        
        int car;
        try (FileReader in=new FileReader(file)) {
            //Try whith resources a partir de JDK 7
            while((car=in.read())!=-1){
                System.out.print((char)car);
            }
        } catch (Exception e) { e.printStackTrace(); }
        System.out.println();
    }
    
    
    
    @Override public String getText() {
       StringBuilder sb=new StringBuilder();
       int car;
       
       
        try (FileReader in=new FileReader(file)) {
            while((car=in.read())!=-1){
                sb.append((char)car);
            }
        } catch (Exception e) {
        }
       return sb.toString();
    }
    
    @Override public void setText(String text) {
        
        
        try (FileWriter out=new FileWriter(file)){
            out.write(text);
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    
    
    @Override public void appendText(String text) {
        
        
        
       try (FileWriter out=new FileWriter(file,true)){
            out.write(text);
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    
    
    @Override public void clear() { setText(""); }
    @Override public void addLine(String line) { appendText(line+"\n"); }
    @Override public void addLines(List<String> list) {
        //list.forEach(this::addLine); //practico pero poco performante
        
        try (BufferedWriter out=new BufferedWriter(new FileWriter(file,true))) {
            
            //Si una linea da exception se detiene el insert
            //for(String line:list) out.write(line+"\n");
            
            //Si una linea lanza expcetion no se detiene el loop
            list.forEach(item->{ try { out.write(item+"\n"); }catch(Exception e){}});
            
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    
    
    
    @Override public List<String> getLines() {
        
        
        try (BufferedReader in=new BufferedReader(new FileReader(file))){
            return in.lines().collect(Collectors.toList());
        } catch (Exception e) { 
            e.printStackTrace(); 
            return new ArrayList();
        }
    }
    
    
    @Override public List<String> getLines(String filter) {
        
        
        try (BufferedReader in=new BufferedReader(new FileReader(file))){
            return in
                    .lines()
                    .filter(l->l.toLowerCase().contains(filter.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) { 
            e.printStackTrace(); 
            return new ArrayList();
        }
    }
    
    
    @Override public List<String> getOrderedLines() {
        return getLines().stream().sorted().collect(Collectors.toList());
    }
    
    
    @Override public List<String> getOrderedRevesedLines() {
        return getLines().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    
    
    @Override public LinkedHashSet<String> getLinkedHashSet() {
        LinkedHashSet<String> set=new LinkedHashSet();
        getLines().forEach(set::add);
        return set;
    }
    
    
    @Override public TreeSet<String> getTreeSet() {
        
        TreeSet<String> set=new TreeSet();
        getLines().forEach(set::add);
        return set;
    }
    
    
    
    @Override public void removeLine(String line) {
        
        List<String>lista=getLines();
        lista.remove(line);
        clear();
        addLines(lista);
    }    
}