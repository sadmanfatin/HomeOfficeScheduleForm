import java.util.ArrayList;
import java.util.List;

public class HTMLTableBuilder {


 private int columns;
 private final StringBuilder table = new StringBuilder();
 public  String htmlTable;
 public static String HTML_START = "<html>";
 public static String HTML_END = "</html>";
 public static String TABLE_START_BORDER = "<table border=\"1\">";
 public static String TABLE_START = "<table>";
 public static String TABLE_END = "</table>";
 public static String HEADER_START = "<th>";
 public static String HEADER_END = "</th>";
 public static String ROW_START = "<tr>";
 public static String ROW_END = "</tr>";
 public static String COLUMN_START = "<td>";
 public static String COLUMN_END = "</td>";


 /**
  * @param header
  * @param border
  * @param rows
  * @param columns
  */
 public HTMLTableBuilder(String header, boolean border, int rows, int columns) {
    System.out.println("=============  HTMLTableBuilder class instantiated ");
  this.columns = columns;
  if (header != null) {
   table.append("<b>");
   table.append(header);
   table.append("</b>");
  }
  table.append(HTML_START);
  table.append(border ? TABLE_START_BORDER : TABLE_START);
  table.append(TABLE_END);
  table.append(HTML_END);
 }
 
    public HTMLTableBuilder() {
     System.out.println("=============  HTMLTableBuilder class instantiated ");
     boolean border = true;
     table.append(HTML_START);
     table.append(border ? TABLE_START_BORDER : TABLE_START);
     table.append(TABLE_END);
     table.append(HTML_END);
    }
 
 

 /**
  * @param values
  */
 public void addTableHeader(String... values) {
  if (values.length != columns) {
   System.out.println("Error column lenth");
  } else {
   int lastIndex = table.lastIndexOf(TABLE_END);
   if (lastIndex > 0) {
    StringBuilder sb = new StringBuilder();
    sb.append(ROW_START);
    for (String value : values) {
     sb.append(HEADER_START);
     sb.append(value);
     sb.append(HEADER_END);
    }
    sb.append(ROW_END);
    table.insert(lastIndex, sb.toString());
   }
  }
 }


 /**
  * @param values
  */
 public void addRowValues(String... values) {
  if (values.length != columns) {
   System.out.println("Error column lenth");
  } else {
   int lastIndex = table.lastIndexOf(ROW_END);
   if (lastIndex > 0) {
    int index = lastIndex + ROW_END.length();
    StringBuilder sb = new StringBuilder();
    sb.append(ROW_START);
    for (String value : values) {
        if(value== null){
            value ="";
        }
     sb.append(COLUMN_START);
     sb.append(value);
     sb.append(COLUMN_END);
    }
    sb.append(ROW_END);
    table.insert(index, sb.toString());
   }
  }
 }


 /**
  * @return
  */
 public String build() {
  return table.toString();
 }


 public void buildHtmlTable(  ArrayList<String> header,  ArrayList<ArrayList<String>> rows) {
     System.out.println(" ====================  buildHtmlTable() ");
 // HTMLTableBuilder htmlBuilder = new HTMLTableBuilder(null, true, 2, 3);
  //
     this.columns= header.size(); 
     
    
  String[] tableHeader,  tableRow  ;
  // List rowArr;
 //  header = new String[] {"1H", "2H", "3H"};
  // tableHeader =  new String[header.size()];
     tableHeader = (String[])header.toArray(new String[header.size()]);
      addTableHeader(tableHeader);
      
    // ArrayList<String> rowArr = (ArrayList<String>)rows.get(0);
     //addRowValues(rowArr.toArray()); 
     for (ArrayList<String> rowArr : rows ) {    
         tableRow= (String[])rowArr.toArray(new String[header.size()]);
         addRowValues(tableRow);
     }
      
//     for(ArrayList<String> : rows){
//         System.out.println(ll.toString()+"/n");
//     }
      
//    row = new String[]{"1", "2", "3"};
//     addRowValues(row);
//     row = new String[]{"4", "5", "6"};
//     addRowValues(row);
//     row = new String[]{"7", "7", "7"};
//     addRowValues(row);
     String table =  build();
     setHtmlTable(table);

  //  System.out.println(table.toString());
 }

    public  void setHtmlTable(String  htmlTable ) {
       this.htmlTable = htmlTable;
    }


    public  String getHtmlTable() {
        return htmlTable;
    }
}
