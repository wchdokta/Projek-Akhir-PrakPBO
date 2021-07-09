
package projekfix;

import projekfix.models.Database;
import projekfix.views.ViewHome;

public class ProjekFix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database DB = new Database();
        ViewHome viewhome = new ViewHome(DB);
        viewhome.setVisible(true);
    }
    
}
