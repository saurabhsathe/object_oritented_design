import javax.print.attribute.HashDocAttributeSet;
import java.util.*;

enum NodeState{
    New,
    Installed,
    Deleted

}


class Node{
    String name;
    NodeState state;

    public Node(String name){
        this.name = name;
        state = NodeState.New;
    }

}

public class PackageInstaller {
      /*
      * [(1,0)]
      * [(1,0),(0,1)]
      *
      *
      *
      *
      * * * * * * */


    public boolean install(Map<Integer, List<Integer>> dependencies){
        try {
                    HashMap<Integer,Integer> graph =  new HashMap<>();
                    for(Integer node : dependencies.keySet()){

                    }


        }
        catch(RuntimeException ex){
            System.out.println("Encountered an exception"+ex.toString());
            return false;
        }
        return true;




    }

    public List<Integer> installOrder(){

        return null;
    }


    public static void main(String[] args) {
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        dependencies.put(0, new ArrayList<>());
        dependencies.put(1, Arrays.asList(0));
        dependencies.put(2, Arrays.asList(1));
        dependencies.put(3, Arrays.asList(1, 2));
        dependencies.put(4, Arrays.asList(3));
        System.out.println(new PackageInstaller().install(dependencies));
    }



}
