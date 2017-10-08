/**
 * @author Kimberley Louw, Matthew Boyes, Mika Smith, Nathan Hardy
 */

package value;

import java.util.ArrayList;
import java.util.List;

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
        return findBestItems(customer.getItems(), budget, new Pair<ArrayList<String>, Integer>(new ArrayList<>(), 0)).getKey();
    }

    private Pair<ArrayList<String>, Integer> findBestItems(List<String> items, int budget, Pair<ArrayList<String>, Integer> partial) {
        Pair<ArrayList<String>, Integer> max = partial;
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            ArrayList<String> tmp = new ArrayList<>();
            tmp.addAll(partial.getKey());
            tmp.add(item);

            if (site.getCost(tmp) > budget) return partial;

            Pair<ArrayList<String>, Integer> deeper = findBestItems(
                items.subList(i + 1, items.size()), budget,
                new Pair<ArrayList<String>, Integer>(tmp, partial.getValue() + customer.getValue(item))
            );
            if (deeper.getValue() > max.getValue()) max = deeper;
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
