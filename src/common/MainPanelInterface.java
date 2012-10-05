package common;

import bussiness.Article;
import bussiness.Customer;

/**
 *
 * @author RVAFOD
 */
public interface MainPanelInterface {

    void updateMainComponent(Customer c);

    void updateMainComponent(Article c);

    void updateMainComponent();

    void reset();
}
