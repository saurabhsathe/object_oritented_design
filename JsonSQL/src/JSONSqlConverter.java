import java.util.HashMap;
import java.util.Map;



interface CommandBuilder{
    public String buildSQL();

}

interface  SQLFactory{
    public String getSQL(String jsonData);

}
class InsertSQLBuilder implements CommandBuilder{

    private String table;
    private Map<String, String> data;
    public InsertSQLBuilder(String table,Map<String, String> data){
        this.table = table;
        this.data =  data;

    }


    public String buildSQL(){
        StringBuilder columns  = new StringBuilder();
        StringBuilder values  = new StringBuilder();
        for(Map.Entry<String,String> entry:data.entrySet()){
            String col =  entry.getKey();
            String val = entry.getValue();
            columns.append(col).append(", ");
            values.append("'").append(val).append("', ");
        }
        columns.setLength(columns.length()-2);
        values.setLength(values.length()-2);
        return "insert into "+table+"("+columns.toString()+") values ("+values.toString()+") ";

    }

}


class SelectSQLBuilder implements CommandBuilder{

    private String table;
    private Map<String, String> data;
    public SelectSQLBuilder(String table,Map<String, String> data){
        this.table = table;
        this.data =  data;

    }


    public String buildSQL(){
        StringBuilder whereClause = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            whereClause.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' AND ");
        }
        whereClause.setLength(whereClause.length() - 5); // Remove the trailing " AND "
        return  "select * from "+table+" "+ whereClause.toString();
    }

}
class SQLBuilder implements SQLFactory{
    public String getSQL(String jsonData){

//        JsonReader reader = Json.createReader(new StringReader(jsonData));
//        JsonObject jsonObject = reader.readObject();
//        reader.close();
//
//        String command = jsonObject.getString("command");
//        String table = jsonObject.getString("table");
//        JsonObject jsonObject = jsonObject.getJsonObject("data");
//
//
//
        Map<String, String> dataObject = new HashMap<>();
        dataObject.put("command","select");
        dataObject.put("table","users");
        Map<String, String> columns = new HashMap<>();
        columns.put("id","1");
        columns.put("name","saurabh");
        columns.put("age","27");



        Map<String, Object> data = new HashMap<>();

        String command = dataObject.get("command");
        CommandBuilder commandBuilder;
        if(command.equalsIgnoreCase("Insert")){
            commandBuilder = new InsertSQLBuilder(dataObject.get("table"),columns);

        }
        else{
            commandBuilder = new SelectSQLBuilder(dataObject.get("table"),columns);
        }
        return commandBuilder.buildSQL();
    }

}

public class JSONSqlConverter {





    public static void main (String[] args){


        String jsonString = "{ \"command\": \"INSERT\", \"table\": \"users\", \"data\": { \"name\": \"John Doe\", \"email\": \"john.doe@example.com\" } }";
        SQLFactory sqlFactory = new SQLBuilder();
        String respo= sqlFactory.getSQL(jsonString);
        System.out.println(respo);
    }
}
