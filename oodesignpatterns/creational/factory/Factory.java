public class Factory{
    public static void main(String[] args) {
        System.out.println("Inside factory");

        Button btn;
        String selectedType = "MacButton";
        if(selectedType.equalsIgnoreCase("windows")){
            btn = new WindowsButton();
        }
        else{
            btn = new MacButton();
        }
        btn.click();
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