/**
 * @author Kimberley Louw, Matthew Boyes, Mika Smith, Nathan Hardy
 */

package value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

        ArrayList<String> bestItems = new ArrayList<String>();
        bestItems.addAll(findBestItems(new Pair<HashSet<String>, Integer>(new HashSet<String>(), Integer.MIN_VALUE), customer.getItems(), seen).getKey());

    	return bestItems;
    }

    private Pair<HashSet<String>, Integer> findBestItems(Pair<HashSet<String>, Integer> current, ArrayList<String> itemsLeft, HashSet<HashSet<String>> seen) {
        Pair<HashSet<String>, Integer> max = current;
        for (String item : itemsLeft) {
            HashSet<String> next = new HashSet<String>();
            next.addAll(current.getKey());
            next.add(item);
            if (seen.contains(next)) continue;

            ArrayList<String> nextArray = new ArrayList<String>();
            nextArray.addAll(next);
            if (site.getCost(nextArray) > budget) continue;

            int gain = 0;
            for (String i : nextArray) {
                gain += customer.getValue(i);
            }

            ArrayList<String> newItemsLeft = new ArrayList<String>();
            for (String itemLeft : itemsLeft) {
                if (!itemLeft.equals(item)) newItemsLeft.add(itemLeft);
            }

            Pair<HashSet<String>, Integer> deeper = findBestItems(new Pair<HashSet<String>, Integer>(next, gain), newItemsLeft, seen);

            max = deeper.getValue() > max.getValue() ? deeper : max;
        }

        return max;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
