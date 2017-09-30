package value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * The class for bargain finders.
 *
 * @author MichaelAlbert
 */
public class BargainFinder {

    private SiteInfo site;
    private CustomerInfo customer;
    private int budget;

    public BargainFinder(SiteInfo site, CustomerInfo customer, int budget) {
        this.site = site;
        this.customer = customer;
        this.budget = budget;
    }

    public ArrayList<String> shoppingList() {
        HashMap<String, Integer> wantedItems = new HashMap<String, Integer>();
        for (String item : customer.getItems()) {
            wantedItems.put(item, customer.getValue(item));
        }

        HashSet<HashSet<String>> seen = new HashSet<HashSet<String>>();

        // ArrayList<String> itemsLeft = new ArrayList<String>();
        // itemsLeft.addAll(wantedItems.keySet());

    	return null;
    }



}
