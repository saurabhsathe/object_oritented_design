public class AbstractFactory{
    public static void main(String[] args) {
        System.out.println("Inside abstract factory");

        Factory factory;
        String selectedType = "windows";
        if(selectedType.equalsIgnoreCase("windows")){
            factory = new WindowsFactory();
        }
        else{
            factory = new MacFactory();
        }
        factory.createButton().click();
        factory.createDialog().createPopup();
    }
}

interface Button{

    public void click();
}

class WindowsButton implements  Button{

    public  void click(){
        System.out.println("You just clicked a windows button");
    }
}

class MacButton implements  Button{

    public  void click(){
        System.out.println("You just clicked a mac button");
    }
}

interface Dialog{

    public void createPopup();
}

class WindowsDialog implements  Dialog{

    public  void createPopup(){
        System.out.println("You just created a windows popup");
    }
}

class MacDialog implements  Dialog{

    public  void createPopup(){
        System.out.println("You just created a mac popup");
    }
}

interface Factory{

    public Button createButton();
    public Dialog createDialog();
}
class WindowsFactory implements Factory{
    public Button createButton(){
            return new WindowsButton();
    }
    public Dialog createDialog(){
            return new WindowsDialog();
    }

}

class MacFactory implements Factory{
    public Button createButton(){
        return new MacButton();
    }
    public Dialog createDialog(){
        return new MacDialog();
    }

}

