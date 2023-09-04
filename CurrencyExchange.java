import java.util.*;

public class CurrencyExchange {

    public static double maxAmountOfExchange(List<List<String>> exchanges, double[] rates, String fromCurrency, String toCurrency){
        Map<String, Map<String, Double>> exchangeGraph = new HashMap<>();
        List<Double> amounts = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i< exchanges.size(); i++){
            List<String> exchange = exchanges.get(i);
            String currFrom = exchange.get(0);
            String currTo = exchange.get(1);
            if(!exchangeGraph.containsKey(currFrom)){
                exchangeGraph.put(currFrom, new HashMap<>());
            }
            exchangeGraph.get(currFrom).put(currTo, rates[i]);
            if(!exchangeGraph.containsKey(currTo)){
                exchangeGraph.put(currTo, new HashMap<>());
            }
            exchangeGraph.get(currTo).put(currFrom, 1/rates[i]);
        }
        if (!exchangeGraph.containsKey(fromCurrency) || !exchangeGraph.containsKey(toCurrency)) {
            return -1.0;
        }

        dfs(exchangeGraph, fromCurrency, toCurrency, amounts, 1.0, visited);
        return amounts.size() > 0 ? Collections.max(amounts) : -1.0;
    }

    private static void dfs(Map<String, Map<String, Double>> exchangeGraph, String fromCurrency, String toCurrency,
                            List<Double> amounts, double currentAmount, Set<String> visited){
        if (fromCurrency.equals(toCurrency)) {
            amounts.add(currentAmount);
            return;
        }
        visited.add(fromCurrency);

        for(Map.Entry<String, Double> set: exchangeGraph.get(fromCurrency).entrySet()){
            String currentCurrency = set.getKey();
            double currentRate = set.getValue();

            if(!visited.contains(currentCurrency)){
                dfs(exchangeGraph, currentCurrency, toCurrency, amounts, currentAmount * currentRate, visited);
            }
        }
    }
    public static void main(String[] args) {
        List<List<String>> exchanges = new ArrayList<>();
        exchanges.add(List.of("USD", "CAD"));
        exchanges.add(List.of("USD", "GBP"));
        exchanges.add(List.of("USD", "JPY"));
        exchanges.add(List.of("GBP", "JPY"));

        double[] rates = new double[]{1.3, 0.71, 109, 155};

        System.out.println(maxAmountOfExchange(exchanges, rates, "USD", "JPY"));

        List<List<String>> exchangeTwo = new ArrayList<>();
        exchanges.add(List.of("USD", "GBP"));
        exchanges.add(List.of("USD", "JPY"));
        exchanges.add(List.of("GBP", "JPY"));
        exchanges.add(List.of("CAD", "CNY"));
        exchanges.add(List.of("CAD", "KRW"));

        double[] ratesTwo = new double[]{0.7, 109, 155, 5.27, 921};
        System.out.println(maxAmountOfExchange(exchangeTwo, ratesTwo, "USD", "CNY"));
    }
}
