import java.util.*;
public class Composite {


    public static void main(String[] args) {
        FileComponent file1 = new FileComponent("file1.txt","content1");
        FileComponent file2 = new FileComponent("file2.txt","content2");
        FileComponent file3 = new FileComponent("file3.txt","content3");
        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");
        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder2.addComponent(folder1);
        folder2.addComponent(file3);
        //folder2.addComponent(folder1);
        folder2.showItems();
    }
}
abstract class Component{
    String componentName;
    protected  Component(String componentName){
        this.componentName = componentName;
    }
    public abstract void showItems();




}

class FileComponent extends Component{
    String content;
    FileComponent(String name, String data){
        super(name);
        this.content = data;
    }

    public void showItems(){
        System.out.println(componentName +"Here is the file contents: -->"+content );
    }





}
class Folder extends Component{

    List<Component> content;
    Folder(String name){
        super(name);
        content= new ArrayList<>();

    }

    public void addComponent(Component component){
        content.add(component);
    }

    public void showItems(){
        System.out.println("Folder : "+componentName);

        for(Component component:content){
            component.showItems();
        }
    }


}